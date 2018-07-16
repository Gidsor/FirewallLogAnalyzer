package com.gidsor.firewalllog.utils.parsers

import com.gidsor.firewalllog.models.logfiles.template.KasperskyLogFile
import java.time.LocalDate
import java.time.LocalTime

class KasperskyParser {
    companion object {
        fun parseTextToLogFiles(text: String, nameOfLogFile: String): List<KasperskyLogFile> {
            val logs = mutableListOf<KasperskyLogFile>()

            val textsplit = text.split(",")
            for (t in textsplit) {

                val s = t.split("\t")

                val timeText = s[0].split(" ").toMutableList()
                if (timeText.size == 3) {
                    timeText.removeAt(0)
                } else {
                    timeText[0] = timeText[0].replace("[", "")
                }
                val dmy = timeText[0].split(".")
                val hms = timeText[1].split(":")

                val date: LocalDate = LocalDate.of(dmy[2].toInt(), dmy[1].toInt(), dmy[0].toInt())
                val time: LocalTime = LocalTime.of(hms[0].toInt(), hms[1].toInt(), hms[2].toInt())
                val name: String = s[1]
                val protect: String = s[2]
                val application: String = s[3]
                val result: String = s[4]
                val objectAttack: String = s[5]

                logs.add(KasperskyLogFile(date, time, name, protect, application, result, objectAttack, nameOfLogFile))
            }

            return logs
        }
    }
}