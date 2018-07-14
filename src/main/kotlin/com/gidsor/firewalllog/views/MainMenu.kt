package com.gidsor.firewalllog.views

import tornadofx.*

class MainMenu : View("My View") {
    override val root = hbox {
        button("Добавить") {
            action {
                AddLogView().openModal()
            }
        }
    }
}
