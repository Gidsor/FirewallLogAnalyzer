package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.controllers.parsers.TLWR1043NDParser
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import com.gidsor.firewalllog.views.MainWindow
import com.gidsor.firewalllog.views.tables.template.TLWR1043NDTable
import javafx.collections.ObservableList
import tornadofx.*

class TLWR1043NDStore : Controller() {
    private val logs = mutableListOf<TLWR1043NDLogFile>().observable()
    private val commonStore: CommonStore by inject()

//    fun addLogFile(log: TLWR1043NDLogFile) {
//        logs.add(log)
//        commonStore.addLogFile(log)
//    }

    fun addLogFiles(log: String, nameOfLogFile: String) {
        addLogFiles(TLWR1043NDParser.parseTextToLogFiles(log, nameOfLogFile))
    }

    fun addLogFiles(log: List<TLWR1043NDLogFile>) {
        logs.addAll(log)
        commonStore.addLogFiles(log)
    }

    fun getLogs(): ObservableList<TLWR1043NDLogFile> {
        return logs
    }
}