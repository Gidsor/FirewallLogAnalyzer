package com.gidsor.firewalllog.views.tables

import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.models.logfiles.KasperskyLogFile
import tornadofx.*

class KasperskyStoreTable : View("My View") {
    private val store: KasperskyStore by inject()

    override val root = tableview(store.getLogs()) {
        column("Дата события", KasperskyLogFile::date)
        column("Время события", KasperskyLogFile::time)
        column("Наименование", KasperskyLogFile::name)
        column("Вид защиты", KasperskyLogFile::protect)
        column("Программа", KasperskyLogFile::application)
        column("Результат", KasperskyLogFile::result)
        column("Объект", KasperskyLogFile::objectAttack)

        smartResize()
    }
}
