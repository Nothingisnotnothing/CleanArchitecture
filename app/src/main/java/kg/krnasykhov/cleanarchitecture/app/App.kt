package kg.krnasykhov.cleanarchitecture.app

import android.app.Application
import kg.krnasykhov.cleanarchitecture.di.appModule
import kg.krnasykhov.cleanarchitecture.di.dataModule
import kg.krnasykhov.cleanarchitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

//androidLogger() - определяет насколько подробно будут выводиться ошибки

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}