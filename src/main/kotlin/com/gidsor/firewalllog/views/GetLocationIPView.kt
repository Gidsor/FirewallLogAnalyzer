package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.analysis.LocationIP
import com.gidsor.firewalllog.controllers.store.CommonStore
import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import com.gidsor.firewalllog.utils.FirewallType
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.FileChooser
import tornadofx.*

class GetLocationIPView : View("My View") {
    private val locationController: LocationIP by inject()

    private lateinit var result: Label
    private lateinit var ip: TextField

    override val root = vbox {
        prefWidth = 200.0
        label("IP-адрес")
        ip = textfield {
        }

        result = label("")

        button("Обнаружить") {
            action {
                result.text = locationController.getLocation(ip.text)
            }
        }

    }
}
