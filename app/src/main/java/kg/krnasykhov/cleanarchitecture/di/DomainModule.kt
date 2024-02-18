package kg.krnasykhov.cleanarchitecture.di

import kg.krnasykhov.cleanarchitecture.domain.usecase.GetUserNameUseCase
import kg.krnasykhov.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }
    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}