package com.gidsor.firewalllog

import tornadofx.*

class FirewallLogApp : App(MyView::class) {

}

fun main(args: Array<String>) {
    launch<FirewallLogApp>(args)
}