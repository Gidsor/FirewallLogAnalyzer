package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.store.CommonStore
import com.gidsor.firewalllog.controllers.store.FirewallStore
import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import com.gidsor.firewalllog.models.logfiles.LogFile
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import com.gidsor.firewalllog.utils.FirewallType
import javafx.scene.control.TreeItem
import tornadofx.*

class FirewallTreeView : View("My View") {

    private val commonStore: CommonStore by inject()
    private val firewallStore: FirewallStore by inject()

    override val root = treeview<Any> {
        root = TreeItem("Firewalls")

        cellFormat {
            text = when (it) {
                is String -> it
                is FirewallType -> it.name
                is LogFile -> it.nameOfLogFile
                else -> kotlin.error("Invalid value type")
            }
        }

        populate { parent ->
            val value = parent.value
            println(value)
            when {
                parent == root -> firewallStore.getFirewalls()
                value is FirewallType -> commonStore.getLogs().filter { it.firewallType == value }
                else -> null
            }
        }
    }
}
