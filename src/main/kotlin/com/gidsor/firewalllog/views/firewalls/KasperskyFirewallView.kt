package com.gidsor.firewalllog.views.firewalls

import com.gidsor.firewalllog.controllers.store.KasperskyStore
import com.gidsor.firewalllog.utils.ParserLog
import javafx.scene.chart.PieChart
import tornadofx.*

class KasperskyFirewallView : View("My View") {
    private val store: KasperskyStore by inject()

    override val root = vbox {
        hbox {
            vbox {
                label("Общая информация")
                label {
                    val count = store.getLogs().distinctBy { it.nameOfLogFile }.size
                    text = "Количество лог файлов: $count"
                }
                label {
                    val count = store.getLogs().size
                    text = "Количество логов: $count"
                }
            }

            vbox {
                paddingLeft = 20
                label("Суммарная информация об угрозах")
            }
        }

        scrollpane {
            vbox {
                piechart("Наименования") {
                    store.getLogs().distinctBy { it.name }.forEach { item ->
                        data.add(PieChart.Data(item.name, store.getLogs().count {
                            it.name == item.name
                        }.toDouble()))
                    }
                }

                piechart("Атаки с IP") {
                    store.getLogs().distinctBy { ParserLog.getFirstIpAddress(it.objectAttack) }.forEach { item ->
                        data.add(PieChart.Data(ParserLog.getFirstIpAddress(item.objectAttack), store.getLogs().count {
                            ParserLog.getFirstIpAddress(it.objectAttack) == ParserLog.getFirstIpAddress(item.objectAttack)
                        }.toDouble()))
                    }
                }
            }
        }
    }
}
