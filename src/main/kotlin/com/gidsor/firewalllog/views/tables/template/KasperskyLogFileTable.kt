package com.gidsor.firewalllog.views.tables.template

import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import javafx.scene.control.TableView
import tornadofx.*

class KasperskyLogFileTable(nameOfLogFile: String) : View("My View") {
    private val store: KasperskyStore by inject()
    public var table: TableView<KasperskyLogFile>
    init {
        table = tableview(store.getLogs().filtered { it.nameOfLogFile == nameOfLogFile }) {
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
    override val root = hbox {  }
}
