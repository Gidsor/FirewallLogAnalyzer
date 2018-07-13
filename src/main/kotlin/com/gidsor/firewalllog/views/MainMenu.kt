package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.StoreKaspersky
import javafx.stage.FileChooser
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
