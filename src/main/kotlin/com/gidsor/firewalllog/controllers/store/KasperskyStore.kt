package com.gidsor.firewalllog.controllers.store

import com.gidsor.firewalllog.controllers.parsers.KasperskyParser
import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import javafx.collections.ObservableList
import tornadofx.*

class KasperskyStore : Controller() {
    private val logs = mutableListOf<KasperskyLogFile>().observable()
    private val commonStore: CommonStore by inject()

//    fun addLogFile(log: KasperskyLogFile) {
//        logs.add(log)
//        commonStore.addLogFile(log)
//    }

    fun addLogFiles(log: String, nameOfLogFile: String) {
        addLogFiles(KasperskyParser.parseTextToLogFiles(log, nameOfLogFile))
    }

    fun addLogFiles(log: List<KasperskyLogFile>) {
        logs.addAll(log)
        commonStore.addLogFiles(log)
    }

    fun getLogs(): ObservableList<KasperskyLogFile> {
        return logs
    }
}