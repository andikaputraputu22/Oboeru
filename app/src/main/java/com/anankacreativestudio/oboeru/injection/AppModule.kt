package com.anankacreativestudio.oboeru.injection

import android.content.Context
import com.anankacreativestudio.oboeru.notification.NotificationUtil
import com.anankacreativestudio.oboeru.repository.KanaRepository
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
    fun provideNotificationUtil(
        @ApplicationContext context: Context
    ): NotificationUtil {
        return NotificationUtil(context)
    }
}