package com.gidsor.firewalllog.controllers.parsers

import com.gidsor.firewalllog.models.logfiles.template.TLWR1043NDLogFile
import java.time.LocalDate
import java.time.LocalTime

class TLWR1043NDParser {
    companion object {
        fun parseTextToLogFiles(text: String, nameOfLogFile: String): List<TLWR1043NDLogFile> {
            val logs = mutableListOf<TLWR1043NDLogFile>()

            val textsplit = text.split(",")
            for (t in textsplit.subList(10, textsplit.size)) {
                val s = t.split("\t")

                val date: LocalDate = LocalDate.now()
                val time: LocalTime = LocalTime.now()
                val type: String = s[1]
                val level: String = s[2]
                val logContent: String = s[3]

                logs.add(TLWR1043NDLogFile(date, time, type, level, logContent, nameOfLogFile))
            }

            return logs
        }
    }
}