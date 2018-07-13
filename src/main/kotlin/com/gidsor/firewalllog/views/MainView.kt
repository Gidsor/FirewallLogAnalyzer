package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.views.TemplateTables.KasperskyTable
import tornadofx.*

class MainView : View("Firewall Log Analyzer") {
    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 600.0

        top(MainMenu::class)

        left {

        }

        bottom {

        }

        center(KasperskyTable::class)
    }
}
