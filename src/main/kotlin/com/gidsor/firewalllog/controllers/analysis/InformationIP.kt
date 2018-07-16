package com.gidsor.firewalllog.controllers.analysis

import tornadofx.*
import java.util.regex.Pattern

class InformationIP : Controller() {

    private val ipRegex = Pattern.compile(
    "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
    + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
    + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
    + "|[1-9][0-9]|[0-9]))")

    fun getInformation(ip: String): String {
        if (ipRegex.matcher(ip).matches()) {
            
            return "Не удалось выполнить запрос"
        }
        return "Некорректный IP-адрес"
    }
}