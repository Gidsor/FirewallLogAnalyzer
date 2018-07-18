package com.gidsor.firewalllog.views.firewalls.template

import com.gidsor.firewalllog.controllers.store.TLWR1043NDStore
import javafx.scene.chart.PieChart
import tornadofx.*

class TLWR1043NDFirewallView : View("My View") {
    private val store: TLWR1043NDStore by inject()

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
            hbox {
                piechart("Тип события") {
                    store.getLogs().distinctBy { it.type }.forEach { item ->
                        data.add(PieChart.Data(item.type, store.getLogs().count {
                            it.type == item.type
                        }.toDouble()))
                    }
                }

                piechart("Уровень значимости") {
                    store.getLogs().distinctBy { it.level }.forEach { item ->
                        data.add(PieChart.Data(item.level, store.getLogs().count {
                            it.level == item.level
                        }.toDouble()))
                    }
                }
            }
        }
    }
}
