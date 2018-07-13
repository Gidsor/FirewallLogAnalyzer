package com.gidsor.firewalllog.controllers

import com.gidsor.firewalllog.models.KasperskyLogFile
import com.gidsor.firewalllog.models.LogFile
import javafx.collections.ObservableList
import tornadofx.*

class Store : Controller() {
    private val logs = mutableListOf<KasperskyLogFile>().observable()

    fun addLogFile(log: KasperskyLogFile) {
        logs.add(log)
    }

    fun addLogString(log: String) {
        val logFile = KasperskyLogFile(name = log)
        addLogFile(logFile)
    }

    fun getLogs(): ObservableList<KasperskyLogFile> {
        return logs
    }
}