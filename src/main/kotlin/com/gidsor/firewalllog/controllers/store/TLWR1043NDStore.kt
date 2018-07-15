package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.controllers.StoreController
import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import javafx.collections.ObservableList
import tornadofx.*

class TLWR1043NDStore : StoreController() {
    private val logs = mutableListOf<TLWR1043NDLogFile>().observable()

    fun addLogFile(log: TLWR1043NDLogFile) {
        logs.add(log)
    }

    fun addLogFile(log: String, nameOfLogFile: String) {
        val logFile = TLWR1043NDLogFile(name = log, nameOfLogFile = nameOfLogFile)
        addLogFile(logFile)
    }

    fun getLogs(): ObservableList<TLWR1043NDLogFile> {
        return logs
    }
}