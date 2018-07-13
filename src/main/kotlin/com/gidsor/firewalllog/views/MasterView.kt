package com.gidsor.firewalllog.views

import javafx.application.Platform
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*
import kotlin.concurrent.thread


class MyView1 : View() {

    override val root = VBox()
    private val controller = MyController()



    init {
        with(root) {
            this += button("add new layout") {
                action {
                    controller.addNewLayout(root)
                }
            }
            this += progressindicator {
                thread {
                    for (i in 1 .. 100) {
                        Platform.runLater { progress = i.toDouble() / 100 }
                        Thread.sleep(100)
                    }
                }
            }
            this += progressbar {
                thread {
                    for (i in 1 .. 100) {
                        Platform.runLater { progress = i.toDouble() / 100 }
                        Thread.sleep(100)
                    }
                }
            }
        }
    }
}

class MyView2 : View() {
    override val root = button("2") {
        action {
            replaceWith(MyView1::class)
        }
    }
}

class MyController : Controller() {
    fun addNewLayout(root: VBox) {
        with(root) {
            this += button("qwew") {
                textFill = Color.RED
                action {
                    textFill = Color.GREEN
                }
            }
        }
    }
}