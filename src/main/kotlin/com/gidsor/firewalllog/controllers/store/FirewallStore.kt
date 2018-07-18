package com.gidsor.firewalllog.controllers.store

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