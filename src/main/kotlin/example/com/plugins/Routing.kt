package example.com.plugins

import example.com.presentation.route.authenticationRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        route("/api") {
            authenticationRouting()
        }
    }
}
