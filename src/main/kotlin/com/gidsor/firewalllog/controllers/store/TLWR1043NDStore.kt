package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import com.gidsor.firewalllog.views.MainWindow
import com.gidsor.firewalllog.views.tables.template.TLWR1043NDTable
import javafx.collections.ObservableList
import tornadofx.*

class TLWR1043NDStore : Controller() {
    private val logs = mutableListOf<TLWR1043NDLogFile>().observable()
    private val commonStore: CommonStore by inject()

    fun addLogFile(log: TLWR1043NDLogFile) {
        logs.add(log)
        commonStore.addLogFile(log)
    }

    fun addLogFile(log: String, nameOfLogFile: String) {
        val logFile = TLWR1043NDLogFile(nameOfLogFile = nameOfLogFile)
        addLogFile(logFile)
    }

    fun getLogs(): ObservableList<TLWR1043NDLogFile> {
        return logs
    }
}