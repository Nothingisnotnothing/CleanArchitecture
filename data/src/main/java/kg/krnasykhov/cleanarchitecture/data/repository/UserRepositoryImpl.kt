package kg.krnasykhov.cleanarchitecture.data.repository

import kg.krnasykhov.cleanarchitecture.data.storage.models.User
import kg.krnasykhov.cleanarchitecture.data.storage.UserStorage
import kg.krnasykhov.cleanarchitecture.domain.models.SavedUserNameParam
import kg.krnasykhov.cleanarchitecture.domain.models.UserName
import kg.krnasykhov.cleanarchitecture.domain.repository.UserRepository

//Data слой имеет право ссылаться на android, логики тут не должно быть

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SavedUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }


    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SavedUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }
}