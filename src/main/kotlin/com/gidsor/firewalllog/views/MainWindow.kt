package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.views.firewalls.DefaultFirewallView
import tornadofx.*

class MainWindow : View("Firewall Log Analyzer") {


    override val root = borderpane {
        prefWidth = 1280.0
        prefHeight = 720.0

        top(MainMenu::class)

        left(FirewallTreeView::class)

        bottom {

        }

        center(DefaultFirewallView::class)
    }
}
