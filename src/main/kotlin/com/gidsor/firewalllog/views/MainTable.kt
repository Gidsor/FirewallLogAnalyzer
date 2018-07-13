package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.Store
import com.gidsor.firewalllog.models.KasperskyLogFile
import tornadofx.*

class MainTable : View("My View") {
    val store: Store by inject()

    override val root = tableview(store.getLogs()) {
        readonlyColumn("LOG", KasperskyLogFile::name)
        readonlyColumn("time", KasperskyLogFile::time)
        readonlyColumn("date", KasperskyLogFile::date)
    }
}
