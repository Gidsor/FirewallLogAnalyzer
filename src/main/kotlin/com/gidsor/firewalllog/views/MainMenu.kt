package com.gidsor.firewalllog.views

import tornadofx.*

class MainMenu : View("My View") {
    override val root = hbox {
        button("Добавить лог-файл") {
            action {
                AddLogFileView().openModal()
            }
        }

        button("Добавить хранилище логов") {
            action {
                AddLogStoreView().openModal()
            }
        }

        button("Получить информацию по IP") {
            action {
                GetInformationByIPView().openModal()
            }
        }
    }
}
