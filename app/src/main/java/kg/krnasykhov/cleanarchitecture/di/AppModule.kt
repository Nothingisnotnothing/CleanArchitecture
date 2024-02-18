package kg.krnasykhov.cleanarchitecture.di

import kg.krnasykhov.cleanarchitecture.presentation.fragments.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<DataViewModel> {
        DataViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get()
        )
    }
}