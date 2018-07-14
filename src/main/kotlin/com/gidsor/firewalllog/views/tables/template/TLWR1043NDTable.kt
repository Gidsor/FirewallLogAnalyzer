package com.gidsor.firewalllog.views.tables.template

import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import tornadofx.*

class TLWR1043NDTable : View("My View") {
    private val store: TLWR1043NDStore by inject()

    override val root = tableview(store.getLogs()) {
        column("time", TLWR1043NDLogFile::time)
        column("date", TLWR1043NDLogFile::date)
        column("text", TLWR1043NDLogFile::name)
        smartResize()
    }
}
