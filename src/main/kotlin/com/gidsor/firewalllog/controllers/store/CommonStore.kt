package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.models.logfiles.LogFile
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import com.gidsor.firewalllog.utils.FirewallType
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

    fun getLogs(): ObservableList<LogFile> {
        return logs
    }
}