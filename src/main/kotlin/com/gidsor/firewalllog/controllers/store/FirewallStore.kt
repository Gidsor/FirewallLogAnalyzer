package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.models.logfiles.LogFile
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import com.gidsor.firewalllog.utils.FirewallType
import javafx.collections.ObservableList
import tornadofx.*

class FirewallStore : Controller() {
    private val firewalls = mutableListOf<FirewallType>().observable()

    fun addFirewall(firewall: FirewallType) {
        firewalls.add(firewall)
    }

    fun getFirewalls(): ObservableList<FirewallType> {
        return firewalls
    }
}