package com.gidsor.firewalllog.views.tables.template

import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import tornadofx.*

class KasperskyTable : View("My View") {
    private val store: KasperskyStore by inject()

    override val root = tableview(store.getLogs()) {
        column("time", KasperskyLogFile::time)
        column("date", KasperskyLogFile::date)
        column("text", KasperskyLogFile::name)
        smartResize()
    }
}
