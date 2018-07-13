package com.gidsor.firewalllog.models

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate
import java.time.LocalTime
import java.util.*


class KasperskyLogFile(date: LocalDate, time: LocalTime, name: String, protect: String, application: String, result: String, objectAttack: String) : LogFile() {
    val id = UUID.randomUUID()

    val dateProperty = SimpleObjectProperty<LocalDate>(date)
    var date by dateProperty

    val timeProperty = SimpleObjectProperty<LocalTime>(time)
    var time by timeProperty

    val nameProperty = SimpleStringProperty(name)
    var name by nameProperty

    val protectProperty = SimpleStringProperty(protect)
    var protect by protectProperty

    val applicationProperty = SimpleStringProperty(application)
    var application by applicationProperty


    val resultProperty = SimpleStringProperty(result)
    var result by resultProperty


    val objectAttackProperty = SimpleStringProperty(objectAttack)
    var objectAttack by objectAttackProperty

}

class KasperskyLogFileMode(property: ObjectProperty<KasperskyLogFile>) : ItemViewModel<KasperskyLogFile>(itemProperty = property) {

}

