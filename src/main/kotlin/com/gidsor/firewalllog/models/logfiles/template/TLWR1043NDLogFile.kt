package com.gidsor.firewalllog.models.logfiles.template

import com.gidsor.firewalllog.models.logfiles.LogFile
import com.gidsor.firewalllog.utils.FirewallType
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class TLWR1043NDLogFile(date: LocalDate = LocalDate.now(), time: LocalTime = LocalTime.now(),
                        type: String = "", level: String = "", logContent: String = "", nameOfLogFile: String = "") : LogFile(FirewallType.TLWR1043ND, nameOfLogFile) {

    val id = UUID.randomUUID()

    val dateProperty = SimpleObjectProperty<LocalDate>(date)
    var date by dateProperty

    val timeProperty = SimpleObjectProperty<LocalTime>(time)
    var time by timeProperty

    val typeProperty = SimpleStringProperty(type)
    var type by typeProperty


    val levelProperty = SimpleStringProperty(level)
    var level by levelProperty

    val logContentProperty = SimpleStringProperty(logContent)
    var logContent by logContentProperty
}

class TLWR1043NDLogFileMode(property: ObjectProperty<TLWR1043NDLogFile>) : ItemViewModel<TLWR1043NDLogFile>(itemProperty = property) {

}