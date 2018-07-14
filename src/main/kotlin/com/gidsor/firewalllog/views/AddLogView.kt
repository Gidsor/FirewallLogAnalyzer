package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.store.StoreKaspersky
import com.gidsor.firewalllog.utils.FirewallType
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.stage.FileChooser
import tornadofx.*

class AddLogView : View("My View") {
    val firewalls = FXCollections.observableArrayList<FirewallType>()
    val firstFirewall: SimpleObjectProperty<FirewallType>

    val storeKaspersky: StoreKaspersky by inject()

    init {
        firewalls.addAll(FirewallType.values())
        firstFirewall = SimpleObjectProperty<FirewallType>(firewalls.first())
    }

    override val root = vbox {
        label("Выберите межсетевой экран")

        combobox(firstFirewall, firewalls) {

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
