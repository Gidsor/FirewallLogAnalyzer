package com.gidsor.firewalllog.controllers.analysis

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
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
            val doc = Jsoup.connect("https://www.nic.ru/whois/?searchWord=$ip").get()
            val divs = doc.getElementsByClass("_3U-mA _23Irb")
            return removeTextWithSharp(parseResult(divs.toString()))
        }
        return "Некорректный IP-адрес"
    }

    private fun parseResult(html: String): String {
        val document = Jsoup.parse(html)
        document.outputSettings(Document.OutputSettings().prettyPrint(false))
        document.select("br").append("\\n")
        document.select("p").prepend("\\n\\n")
        document.select("a").remove()
        val s = document.html().replace("\\\\n", "\n")
        return Jsoup.clean(s, "", Whitelist.none(), Document.OutputSettings().prettyPrint(false))
    }

    private fun removeTextWithSharp(text: String): String {
        var result = ""
        val textSplit = text.split("\n").toMutableList()
        textSplit.forEach {
            if (!(it.contains('#') || it.contains("OrgTechRef") || it.contains("OrgAbuseRef"))) {
                result += "$it\n"
            }
        }
        return result
    }
}