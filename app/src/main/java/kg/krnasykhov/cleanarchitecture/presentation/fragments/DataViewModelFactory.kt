package kg.krnasykhov.cleanarchitecture.presentation.fragments

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kg.krnasykhov.cleanarchitecture.data.repository.UserRepositoryImpl
import kg.krnasykhov.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import kg.krnasykhov.cleanarchitecture.domain.usecase.GetUserNameUseCase
import kg.krnasykhov.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class DataViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepositoryImpl by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(
                context = context
            )
        )
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepositoryImpl)
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepositoryImpl)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}