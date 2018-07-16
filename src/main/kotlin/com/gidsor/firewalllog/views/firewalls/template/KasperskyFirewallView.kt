package com.gidsor.firewalllog.views.firewalls.template

import com.gidsor.firewalllog.controllers.store.KasperskyStore
import tornadofx.*

class KasperskyFirewallView : View("My View") {
    private val store: KasperskyStore by inject()

    override val root = hbox {
        vbox {
            label("Общая информация")
            label {
                val count = store.getLogs().distinctBy { it.nameOfLogFile }.size
                text = "Количество лог файлов: $count"
            }
            label {
                val count = store.getLogs().size
                text = "Количество логов: $count"
            }
        }

        vbox {
            paddingLeft = 20
            label("Суммарная информация об угрозах")
        }
    }
}
