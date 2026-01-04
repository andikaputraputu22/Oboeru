package com.anankacreativestudio.oboeru.injection

import android.content.Context
import com.anankacreativestudio.oboeru.notification.NotificationUtil
import com.anankacreativestudio.oboeru.repository.KanaRepository
import com.anankacreativestudio.oboeru.repository.MainRepository
import com.anankacreativestudio.oboeru.utils.SettingsPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideKanaRepository(): KanaRepository {
        return KanaRepository()
    }

    @Singleton
    @Provides
    fun provideMainRepository(): MainRepository {
        return MainRepository()
    }

    @Singleton
    @Provides
    fun provideNotificationUtil(
        @ApplicationContext context: Context
    ): NotificationUtil {
        return NotificationUtil(context)
    }

    @Singleton
    @Provides
    fun provideSettingsPreferences(
        @ApplicationContext context: Context
    ): SettingsPreferences {
        return SettingsPreferences(context)
    }
}