package com.gidsor.firewalllog.views.tables.template

import com.gidsor.firewalllog.controllers.analysis.InformationIP
import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import com.gidsor.firewalllog.utils.ParserLog
import javafx.scene.control.Alert
import javafx.scene.control.TableView
import tornadofx.*

class KasperskyLogFileTable(nameOfLogFile: String) : View("My View") {
    private val store: KasperskyStore by inject()
    private val informationIP: InformationIP by inject()

    public var table: TableView<KasperskyLogFile>
    init {
        table = tableview(store.getLogs().filtered { it.nameOfLogFile == nameOfLogFile }) {
            column("Дата события", KasperskyLogFile::date)
            column("Время события", KasperskyLogFile::time)
            column("Наименование", KasperskyLogFile::name)
            column("Вид защиты", KasperskyLogFile::protect)
            column("Программа", KasperskyLogFile::application)
            column("Результат", KasperskyLogFile::result)
            column("Объект", KasperskyLogFile::objectAttack)

            smartResize()


            onDoubleClick {
                val info = informationIP.getInformation(ParserLog.getFirstIpAddress(this.selectedItem!!.objectAttack))
                alert(Alert.AlertType.INFORMATION, "Информация об IP", info).dialogPane.add(
                    scrollpane {
                        text(info)
                    }
                )
            }
        }
    }
    override val root = hbox {  }
}
