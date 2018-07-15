package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.views.tables.DefaultTable
import com.gidsor.firewalllog.views.tables.template.KasperskyTable
import com.gidsor.firewalllog.views.tables.template.TLWR1043NDTable
import tornadofx.*

class MainMenu : View("My View") {
    override val root = hbox {
        button("Добавить") {
            action {
                AddLogView().openModal()
            }
        }
    }
}
