package example.com.di

import example.com.application.service.AuthenticationService
import example.com.domain.repository.UserRepository
import example.com.infrastructure.persistence.UserRepositoryImpl
import org.koin.dsl.module

val appModule = module {

    single<UserRepository> { UserRepositoryImpl() }

    single { AuthenticationService(get()) }


}