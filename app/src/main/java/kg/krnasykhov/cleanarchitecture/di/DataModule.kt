package kg.krnasykhov.cleanarchitecture.di

import kg.krnasykhov.cleanarchitecture.data.repository.UserRepositoryImpl
import kg.krnasykhov.cleanarchitecture.data.storage.UserStorage
import kg.krnasykhov.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import kg.krnasykhov.cleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }
    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}