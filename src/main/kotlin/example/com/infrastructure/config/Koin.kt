package example.com.infrastructure.config

import example.com.di.appModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.koin() {
    install(Koin) {
        modules(
            appModule
        )
    }
}