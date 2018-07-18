package com.gidsor.firewalllog.utils

import java.util.regex.Pattern

object ParserLog {

    private val ipRegex = Pattern.compile(
            "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
                    + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
                    + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
                    + "|[1-9][0-9]|[0-9]))")

    fun getFirstIpAddress(text: String): String {
        val matcher = ipRegex.matcher(text)
        if (matcher.find()) {
            return matcher.group()
        } else {
            return ""
        }
    }
}