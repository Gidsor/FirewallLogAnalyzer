package com.gidsor.firewalllog.views.TemplateTables

import com.gidsor.firewalllog.controllers.StoreKaspersky
import com.gidsor.firewalllog.models.KasperskyLogFile
import tornadofx.*

class KasperskyTable : View("My View") {
    private val store: StoreKaspersky by inject()

    override val root = tableview(store.getLogs()) {
        column("time", KasperskyLogFile::time)
        column("date", KasperskyLogFile::date)
        column("text", KasperskyLogFile::name)
        smartResize()
    }
}
