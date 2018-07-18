package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.models.logfiles.LogFile
import javafx.collections.ObservableList
import tornadofx.*

class CommonStore : Controller() {
    private val logs = mutableListOf<LogFile>().observable()

    private val firewallStore: FirewallStore by inject()

    fun addLogFile(log: LogFile) {
        logs.add(log)
        firewallStore.getFirewalls().remove(log.firewallType)
        firewallStore.addFirewall(log.firewallType)
    }

    fun addLogFiles(log: List<LogFile>) {
        logs.addAll(log)
        firewallStore.getFirewalls().remove(log[0].firewallType)
        firewallStore.addFirewall(log[0].firewallType)
    }

    fun getLogs(): ObservableList<LogFile> {
        return logs
    }
}