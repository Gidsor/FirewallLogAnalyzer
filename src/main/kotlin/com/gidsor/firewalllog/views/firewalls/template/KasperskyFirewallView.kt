package com.gidsor.firewalllog.views.firewalls.template

import com.gidsor.firewalllog.controllers.store.KasperskyStore
import tornadofx.*

class KasperskyFirewallView : View("My View") {
    private val store: KasperskyStore by inject()

    override val root = hbox {
        vbox {
            label("Общая информация")
        }

        vbox {
            paddingLeft = 20
            label("Суммарная информация об угрозах")
        }
    }
}
