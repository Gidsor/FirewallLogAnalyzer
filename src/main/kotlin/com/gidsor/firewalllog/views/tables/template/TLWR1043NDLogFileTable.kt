package com.gidsor.firewalllog.views.tables.template

import com.gidsor.firewalllog.controllers.analysis.InformationIP
import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import com.gidsor.firewalllog.utils.ParserLog
import javafx.scene.control.TableView
import tornadofx.*


class TLWR1043NDLogFileTable(nameOfLogFile: String) : View("My View") {
    private val store: TLWR1043NDStore by inject()
    public var table: TableView<TLWR1043NDLogFile>
    init {
        table = tableview(store.getLogs().filtered { it.nameOfLogFile == nameOfLogFile }) {
            column("Дата события", TLWR1043NDLogFile::time)
            column("Время события", TLWR1043NDLogFile::date)
            column("Тип события", TLWR1043NDLogFile::type)
            column("Уровень значимости", TLWR1043NDLogFile::level)
            column("Содержание лога", TLWR1043NDLogFile::logContent)

            smartResize()

        }
    }
    override val root = hbox {  }
}
