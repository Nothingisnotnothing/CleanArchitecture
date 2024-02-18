package kg.krnasykhov.cleanarchitecture.data.storage.sharedprefs

import android.content.Context
import kg.krnasykhov.cleanarchitecture.data.storage.UserStorage
import kg.krnasykhov.cleanarchitecture.data.storage.models.User
import kg.krnasykhov.cleanarchitecture.domain.Constants

class SharedPrefUserStorage(private val context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(Constants.SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(Constants.KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(Constants.KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName =
            sharedPreferences.getString(Constants.KEY_FIRST_NAME, Constants.DEFAULT_FIRST_NAME)
                ?: Constants.DEFAULT_FIRST_NAME
        val lastName =
            sharedPreferences.getString(Constants.KEY_LAST_NAME, Constants.DEFAULT_LAST_NAME)
                ?: Constants.DEFAULT_LAST_NAME

        return User(firstName = firstName, lastName = lastName)
    }
}