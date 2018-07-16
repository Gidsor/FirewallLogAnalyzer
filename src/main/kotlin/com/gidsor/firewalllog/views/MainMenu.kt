package com.gidsor.firewalllog.views

import tornadofx.*

class MainMenu : View("My View") {
    override val root = hbox {
        button("Добавить") {
            action {
                AddLogView().openModal()
            }
        }

        button("Получить местоположение по IP") {
            action {
                GetInformationByIPView().openModal()
            }
        }
    }
}
