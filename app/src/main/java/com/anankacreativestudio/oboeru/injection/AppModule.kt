package com.anankacreativestudio.oboeru.injection

import com.anankacreativestudio.oboeru.repository.KanaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
}