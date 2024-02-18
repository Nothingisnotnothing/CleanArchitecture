package kg.krnasykhov.cleanarchitecture.data.storage

import kg.krnasykhov.cleanarchitecture.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean
    fun get(): User
}