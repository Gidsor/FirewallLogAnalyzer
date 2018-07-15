package com.gidsor.firewalllog.models.logfiles

import com.gidsor.firewalllog.utils.FirewallType
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

open class LogFile(firewallType: FirewallType, nameOfLogFile: String) {
    val nameOfLogFileProperty = SimpleStringProperty()
    var nameOfLogFile by nameOfLogFileProperty

    val firewallTypeProperty = SimpleObjectProperty<FirewallType>()
    var firewallType by firewallTypeProperty
}
