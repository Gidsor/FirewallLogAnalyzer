package com.gidsor.firewalllog.controllers.parsers

import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import java.time.LocalDate
import java.time.LocalTime

class TLWR1043NDParser {
    companion object {
        fun parseTextToLogFiles(text: String, nameOfLogFile: String): List<TLWR1043NDLogFile> {
            val logs = mutableListOf<TLWR1043NDLogFile>()

            println(text)
            val textsplit = text
            for (t in textsplit) {

                logs.add(TLWR1043NDLogFile())
            }

            return logs
        }
    }
}