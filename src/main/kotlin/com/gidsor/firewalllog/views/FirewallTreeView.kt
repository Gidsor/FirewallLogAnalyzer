package com.gidsor.firewalllog.views

import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import com.gidsor.firewalllog.models.logfiles.LogFile
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import javafx.scene.control.TreeItem
import tornadofx.*

class FirewallTreeView : View("My View") {

    private val kaspersStore: KasperskyStore by inject()
    private val tlwR1043ndStore: TLWR1043NDStore by inject()



    override val root = treeview<String> {
        root = TreeItem("Firewalls")

        cellFormat { text = it }


    }
}
