package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.store.CommonStore
import com.gidsor.firewalllog.controllers.store.FirewallStore
import com.gidsor.firewalllog.models.logfiles.LogFile
import com.gidsor.firewalllog.utils.FirewallType
import com.gidsor.firewalllog.views.firewalls.DefaultFirewallView
import com.gidsor.firewalllog.views.firewalls.template.KasperskyFirewallView
import com.gidsor.firewalllog.views.firewalls.template.TLWR1043NDFirewallView
import com.gidsor.firewalllog.views.tables.template.KasperskyLogFileTable
import com.gidsor.firewalllog.views.tables.template.TLWR1043NDLogFileTable
import javafx.scene.control.TreeItem
import javafx.scene.layout.BorderPane
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

        onUserSelect {
            when (it) {
                is String -> (parent as BorderPane).center = BorderPane().center(DefaultFirewallView::class)

                is FirewallType -> {
                    when (it) {
                        FirewallType.Kaspersky -> (parent as BorderPane).center = BorderPane().center(KasperskyFirewallView::class)
                        FirewallType.TLWR1043ND -> (parent as BorderPane).center = BorderPane().center(TLWR1043NDFirewallView::class)
                    }
                }

                is LogFile -> {
                    when (it.firewallType) {
                        FirewallType.Kaspersky -> (parent as BorderPane).center = KasperskyLogFileTable(it.nameOfLogFile).table
                        FirewallType.TLWR1043ND -> (parent as BorderPane).center = TLWR1043NDLogFileTable(it.nameOfLogFile).table
                    }
                }
            }
        }

        populate { parent ->
            val value = parent.value
            when {
                parent == root -> firewallStore.getFirewalls()
                value is FirewallType -> commonStore.getLogs().distinctBy { it.nameOfLogFile }.filter { it.firewallType == value }
                else -> null
            }
        }
    }
}
