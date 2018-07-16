package com.gidsor.firewalllog.views.tables.template

import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import tornadofx.*

class KasperskyTable : View("My View") {
    private val store: KasperskyStore by inject()

    override val root = tableview(store.getLogs()) {
        column("Дата события", KasperskyLogFile::date)
        column("Время события", KasperskyLogFile::time)
        column("Наименование", KasperskyLogFile::name)
        column("Вид защиты", KasperskyLogFile::protect)
        column("Программа", KasperskyLogFile::application)
        column("Результат", KasperskyLogFile::result)
        column("Объект", KasperskyLogFile::objectAttack)
        /*
        date: LocalDate = LocalDate.now(), time: LocalTime = LocalTime.now(),
                       name: String = "", protect: String = "", application: String = "",
                       result: String = "", objectAttack: String = "", nameOfLogFile: String = ""
         */
        smartResize()
    }
}
