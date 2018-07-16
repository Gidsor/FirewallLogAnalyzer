package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.views.tables.DefaultTable
import com.gidsor.firewalllog.views.tables.template.KasperskyTable
import com.gidsor.firewalllog.views.tables.template.TLWR1043NDTable
import tornadofx.*

class MainWindow : View("Firewall Log Analyzer") {


    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 600.0

        top(MainMenu::class)

        left(FirewallTreeView::class)

        bottom {

        }

        center(DefaultTable::class)
    }
}
