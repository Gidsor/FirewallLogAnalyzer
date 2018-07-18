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

        minWidth = 700.0
        minHeight = 500.0

        vbox {

            label("IP-адрес")

            ip = textfield {
                minWidth = 200.0
                maxWidth = 200.0
            }


            button("Обнаружить") {
                action {
                    information.text = informationController.getInformation(ip.text)
                }
            }

        }

        vbox {
            scrollpane {
                minHeight = 500.0
                maxHeight = 500.0

                minWidth = 500.0

                information = text("") {
                }
            }
        }
    }

}
