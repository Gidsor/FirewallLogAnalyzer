package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.analysis.InformationIP
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.text.Text
import tornadofx.*

class GetInformationByIPView : View("My View") {
    private val informationController: InformationIP by inject()

    private lateinit var result: Label
    private lateinit var ip: TextField

    private lateinit var information: Text

    override val root = hbox {
        vbox {
            prefWidth = 200.0

            label("IP-адрес")

            ip = textfield {
            }

            result = label("")

            button("Обнаружить") {
                action {
                    result.text = informationController.getLocation(ip.text)
                }
            }

        }

        vbox {
            information = text("")
        }
    }

}
