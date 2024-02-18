package kg.krnasykhov.cleanarchitecture.presentation.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.krnasykhov.cleanarchitecture.domain.models.SavedUserNameParam
import kg.krnasykhov.cleanarchitecture.domain.models.UserName
import kg.krnasykhov.cleanarchitecture.domain.usecase.GetUserNameUseCase
import kg.krnasykhov.cleanarchitecture.domain.usecase.SaveUserNameUseCase

//Класс который живет в течении жизни приложения + context тут быть не должно

class DataViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive:LiveData<String> = resultLiveMutable

    fun save(text: String) {
        val savedUserNameParam = SavedUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(savedUserNameParam = savedUserNameParam)
        resultLiveMutable.value = ("Save result =  $resultData")
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
         resultLiveMutable.value = ("${userName.firstName} ${userName.lastName}")
    }

}