package com.gidsor.firewalllog.views.firewalls.template

import com.gidsor.firewalllog.controllers.store.KasperskyStore
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

        hbox {
            piechart("Наименования") {
                store.getLogs().distinctBy { it.name }.forEach { item ->
                    data.add(PieChart.Data(item.name, store.getLogs().count {
                        it.name == item.name
                    }.toDouble()))
                }
            }

            // TODO fix pie chart. Need use parser for ip
            piechart("Атаки с IP") {
                store.getLogs().distinctBy { it.objectAttack }.forEach { item ->
                    data.add(PieChart.Data(item.objectAttack, store.getLogs().count {
                        it.objectAttack == item.objectAttack
                    }.toDouble()))
                }
            }
        }
    }
}
