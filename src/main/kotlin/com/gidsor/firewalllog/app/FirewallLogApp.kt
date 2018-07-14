package com.gidsor.firewalllog.app

import com.gidsor.firewalllog.views.MainWindow
import javafx.application.Application
import tornadofx.*

class FirewallLogApp : App(MainWindow::class, Styles::class)

fun main(args: Array<String>) {
    Application.launch(FirewallLogApp::class.java, *args)
}
