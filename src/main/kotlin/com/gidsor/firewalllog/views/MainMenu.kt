package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.analysis.LocationIP
import javafx.geometry.Insets
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
                GetLocationIPView().openModal()
            }
        }
    }
}
