package kg.krnasykhov.cleanarchitecture.domain.usecase

import kg.krnasykhov.cleanarchitecture.domain.models.SavedUserNameParam
import kg.krnasykhov.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(savedUserNameParam: SavedUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == savedUserNameParam.name) {
            return true
        }

        return userRepository.saveName(saveParam = savedUserNameParam)
    }
}