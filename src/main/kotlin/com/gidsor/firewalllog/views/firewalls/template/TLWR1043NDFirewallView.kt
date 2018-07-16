package com.gidsor.firewalllog.views.firewalls.template

import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import tornadofx.*

class TLWR1043NDFirewallView : View("My View") {
    private val store: TLWR1043NDStore by inject()
    
    override val root = hbox {
        vbox {
            label("Общая информация")
            label {
                val count = store.getLogs().distinctBy { it.nameOfLogFile }.size
                text = "Количество лог файлов: $count"
            }
        }

        vbox {
            paddingLeft = 20
            label("Суммарная информация об угрозах")
        }
    }
}
