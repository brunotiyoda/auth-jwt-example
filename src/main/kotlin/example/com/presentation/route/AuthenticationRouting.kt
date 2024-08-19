package example.com.presentation.route

import example.com.application.service.AuthenticationService
import example.com.infrastructure.security.JwtConfig
import example.com.presentation.route.requests.LoginRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.ratelimit.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.authenticationRouting() {

    val service by inject<AuthenticationService>()

    rateLimit(RateLimitName("auth")) {
        post("/login") {
            val loginRequest = call.receive<LoginRequest>()
            val result = service.authenticate(loginRequest.username, loginRequest.password)

            when (result) {
                is AuthenticationService.Result.Success -> {
                    val token = JwtConfig.generateToken(result.user)
                    call.respond(HttpStatusCode.OK, mapOf("token" to token))
                }

                is AuthenticationService.Result.Failure -> {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid username or password")
                }
            }
        }
    }

}