package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.controllers.StoreController
import com.gidsor.firewalllog.models.logfiles.LogFile
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import com.gidsor.firewalllog.utils.FirewallType
import javafx.collections.ObservableList
import tornadofx.*

class KasperskyStore : StoreController() {
    private val logs = mutableListOf<KasperskyLogFile>().observable()

    fun addLogFile(log: KasperskyLogFile) {
        logs.add(log)
    }

    fun addLogString(log: String) {
        val logFile = KasperskyLogFile(name = log)
        addLogFile(logFile)
    }

    fun getLogs(): ObservableList<KasperskyLogFile> {
        return logs
    }
}