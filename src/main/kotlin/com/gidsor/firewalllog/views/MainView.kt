package com.gidsor.firewalllog.views

import tornadofx.*

class MainView : View("Firewall Log Analyzer") {
    private val addLogFileButton = button("добавить")
    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 600.0

        top(MainMenu::class)

        left {

        }

        bottom {

        }

        center(MainTable::class)
    }
}
