package kg.krnasykhov.cleanarchitecture.domain.usecase

import kg.krnasykhov.cleanarchitecture.domain.models.UserName
import kg.krnasykhov.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}