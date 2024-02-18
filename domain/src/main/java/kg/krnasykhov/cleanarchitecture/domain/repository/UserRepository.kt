package kg.krnasykhov.cleanarchitecture.domain.repository

import kg.krnasykhov.cleanarchitecture.domain.models.SavedUserNameParam
import kg.krnasykhov.cleanarchitecture.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SavedUserNameParam): Boolean

    fun getName(): UserName
}