package com.gidsor.firewalllog.controllers

import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import javafx.collections.ObservableList
import tornadofx.*

abstract class StoreController : Controller() {
    private val logs = mutableListOf<KasperskyLogFile>().observable()

    fun addLogFile(log: KasperskyLogFile) {
        logs.add(log)
    }

    fun addLogString(log: String) {
        println(log)
        val logFile = KasperskyLogFile(name = log)
        addLogFile(logFile)
    }

    fun getLogs(): ObservableList<KasperskyLogFile> {
        return logs
    }
}