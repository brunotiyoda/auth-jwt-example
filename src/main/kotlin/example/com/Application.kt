package example.com

import example.com.infrastructure.config.DatabaseFactory
import example.com.infrastructure.config.koin
import example.com.infrastructure.config.serialization
import example.com.infrastructure.security.authenticationConfig
import example.com.infrastructure.security.configureRateLimiting
import example.com.infrastructure.security.corsConfig
import example.com.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init()

    koin()
    serialization()

    corsConfig()
    configureRateLimiting()
    authenticationConfig()

    configureRouting()
}
