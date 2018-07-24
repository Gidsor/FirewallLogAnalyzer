package com.gidsor.firewalllog.utils.parsers

import com.gidsor.firewalllog.models.logfiles.TLWR1043NDLogFile
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.util.*

class TLWR1043NDParser {
    companion object {
        fun parseTextToLogFiles(text: String, nameOfLogFile: String): List<TLWR1043NDLogFile> {
            val logs = mutableListOf<TLWR1043NDLogFile>()

            val textsplit = text.split(",")
            val year = textsplit[3].substring(10, 14)

            for (t in textsplit.subList(10, textsplit.size)) {
                val s = t.split("\t")

                // MMM dd
                val md = s[0].substring(1, s[0].length - 8).split(" ")
                val month = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(md[0]).get(ChronoField.MONTH_OF_YEAR)
                val hms = s[0].substring(s[0].length - 8 ,s[0].length).split(":")

                val date: LocalDate = LocalDate.of(year.toInt(), month, md[1].toInt())
                val time: LocalTime = LocalTime.of(hms[0].toInt(), hms[1].toInt(), hms[2].toInt())
                val type: String = s[1]
                val level: String = s[2]
                val logContent: String = s[3]

                logs.add(TLWR1043NDLogFile(date, time, type, level, logContent, nameOfLogFile))
            }

            return logs
        }
    }
}