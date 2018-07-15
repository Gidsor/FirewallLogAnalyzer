package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.models.logfiles.LogFile
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import com.gidsor.firewalllog.utils.FirewallType
import javafx.collections.ObservableList
import tornadofx.*

class CommonStore : Controller() {
    private val logs = mutableListOf<LogFile>().observable()

    fun addLogFile(log: LogFile) {
        logs.add(log)
    }

    fun addLogFile(firewallType: FirewallType, nameOfLogFile: String) {
        val logFile = LogFile(firewallType, nameOfLogFile)
        addLogFile(logFile)
    }

    fun getLogs(): ObservableList<LogFile> {
        return logs
    }
}