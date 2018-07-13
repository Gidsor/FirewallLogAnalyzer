package com.gidsor.firewalllog.app

import com.gidsor.firewalllog.views.MainView
import javafx.application.Application
import tornadofx.*

class FirewallLogApp : App(MainView::class, Styles::class)

fun main(args: Array<String>) {
    Application.launch(FirewallLogApp::class.java, *args)
}
