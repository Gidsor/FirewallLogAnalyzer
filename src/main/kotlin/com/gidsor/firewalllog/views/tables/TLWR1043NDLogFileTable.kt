package com.gidsor.firewalllog.views.tables

import com.gidsor.firewalllog.controllers.analysis.InformationIP
import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import com.gidsor.firewalllog.models.logfiles.TLWR1043NDLogFile
import com.gidsor.firewalllog.utils.ParserLog
import javafx.scene.control.Alert
import javafx.scene.control.TableView
import tornadofx.*

class TLWR1043NDLogFileTable(nameOfLogFile: String) : View("My View") {
    private val store: TLWR1043NDStore by inject()
    private val informationIP: InformationIP by inject()

    public var table: TableView<TLWR1043NDLogFile>

    init {
        table = tableview(store.getLogs().filtered { it.nameOfLogFile == nameOfLogFile }) {
            column("Дата события", TLWR1043NDLogFile::time)
            column("Время события", TLWR1043NDLogFile::date)
            column("Тип события", TLWR1043NDLogFile::type)
            column("Уровень значимости", TLWR1043NDLogFile::level)
            column("Содержание лога", TLWR1043NDLogFile::logContent)

            smartResize()


            onDoubleClick {
                val info = informationIP.getInformation(ParserLog.getFirstIpAddress(this.selectedItem!!.logContent))
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
