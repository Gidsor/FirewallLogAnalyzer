package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.Store
import javafx.stage.FileChooser
import tornadofx.*

class MainMenu : View("My View") {
    val store: Store by inject()

    override val root = hbox {
        button("Добавить") {
            action {
                val logFile = chooseFile("Выберите лог файл", arrayOf(FileChooser.ExtensionFilter("*.txt", "*.txt")), FileChooserMode.Single)
                if (logFile.isNotEmpty()) {
                    store.addLogString(logFile.first().readLines().toString())
                }
            }
        }
    }
}
