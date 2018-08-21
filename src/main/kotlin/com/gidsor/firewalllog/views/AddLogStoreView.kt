package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import com.gidsor.firewalllog.utils.FirewallType
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.scene.Parent
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.stage.FileChooser
import tornadofx.*

class AddLogStoreView : View("My View") {
    val firewalls = FXCollections.observableArrayList<FirewallType>()
    val firstFirewall: SimpleObjectProperty<FirewallType>

    private val kasperskyStore: KasperskyStore by inject()
    private val tlwr1043ndStore: TLWR1043NDStore by inject()

    private lateinit var firewallComboBox: ComboBox<FirewallType>
    private lateinit var pathStore: TextField

    init {
        firewalls.addAll(FirewallType.values())
        firstFirewall = SimpleObjectProperty(firewalls.first())
    }

    override val root = vbox {
        label("Выберите межсетевой экран")

        firewallComboBox = combobox(firstFirewall, firewalls)

        label("Путь до сетевой папки")

        pathStore = textfield {  }

        button("Открыть") {
            action {
//                val logFile = chooseFile("Выберите лог файл", arrayOf(FileChooser.ExtensionFilter("*.txt", "*.txt")), FileChooserMode.Single)
//                if (logFile.isNotEmpty()) {
//                    val text = logFile.first().readLines().toString()
//                    val name = logFile.first().nameWithoutExtension
//
//                    when (firewallComboBox.selectedItem) {
//                        FirewallType.Kaspersky -> {
//                            kasperskyStore.addLogFiles(text, name)
//
//                        }
//
//                        FirewallType.TLWR1043ND -> {
//                            tlwr1043ndStore.addLogFiles(text, name)
//                        }
//                    }
//                }
                close()
            }
        }
    }
}