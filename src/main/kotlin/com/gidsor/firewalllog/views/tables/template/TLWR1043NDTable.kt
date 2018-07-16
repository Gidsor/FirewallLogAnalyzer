package com.gidsor.firewalllog.views.tables.template

import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import tornadofx.*

class TLWR1043NDTable : View("My View") {
    private val store: TLWR1043NDStore by inject()

    override val root = tableview(store.getLogs()) {
        column("Дата события", TLWR1043NDLogFile::time)
        column("Время события", TLWR1043NDLogFile::date)
        column("Тип события", TLWR1043NDLogFile::type)
        column("Уровень значимости", TLWR1043NDLogFile::level)
        column("Содержание лога", TLWR1043NDLogFile::logContent)
        smartResize()
    }
}
