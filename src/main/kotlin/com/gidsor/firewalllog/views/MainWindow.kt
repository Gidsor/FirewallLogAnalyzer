package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.views.firewalls.DefaultFirewallView
import tornadofx.*

class MainWindow : View("Firewall Log Analyzer") {


    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 600.0

        top(MainMenu::class)

        left(FirewallTreeView::class)

        bottom {

        }

        center(DefaultFirewallView::class)
    }
}
