package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.StoreKaspersky
import com.gidsor.firewalllog.utils.FirewallType
import javafx.collections.FXCollections
import javafx.stage.FileChooser
import tornadofx.*

class AddLogView : View("My View") {
    val firewalls = FXCollections.observableArrayList<FirewallType>()

    val storeKaspersky: StoreKaspersky by inject()

    init {
        firewalls.addAll(FirewallType.values())
    }

    override val root = vbox {
        label("Выберите межсетевой экран")

        combobox(values = firewalls) {
        }

        label("Выберите лог-файл")

        button("Открыть") {
            action {
                val logFile = chooseFile("Выберите лог файл", arrayOf(FileChooser.ExtensionFilter("*.txt", "*.txt")), FileChooserMode.Single)
                if (logFile.isNotEmpty()) {
                    storeKaspersky.addLogString(logFile.first().readLines().toString())
                }
                close()
            }
        }
    }
}
