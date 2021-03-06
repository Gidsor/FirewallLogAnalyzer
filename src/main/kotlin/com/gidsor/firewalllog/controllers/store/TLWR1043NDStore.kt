package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.utils.parsers.TLWR1043NDParser
import com.gidsor.firewalllog.models.logfiles.TLWR1043NDLogFile
import javafx.collections.ObservableList
import tornadofx.*

class TLWR1043NDStore : Controller() {
    private val logs = mutableListOf<TLWR1043NDLogFile>().observable()
    private val commonStore: CommonStore by inject()

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