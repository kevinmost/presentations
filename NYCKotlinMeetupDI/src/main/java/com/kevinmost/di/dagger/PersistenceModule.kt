package com.kevinmost.di.dagger

import com.kevinmost.di.shared.logger.Logger
import com.kevinmost.di.shared.persistence.FlatFileStringRepository
import com.kevinmost.di.shared.persistence.StringRepository
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Named("stringRepoFile") @Provides @Singleton fun provideStringRepoFile() = File("/Users/kmost/stringrepo")

    @Provides @Singleton fun provideRepository(
            logger: Logger,
            @Named("stringRepoFile") stringRepoFile: File
    ): StringRepository = FlatFileStringRepository(
            logger,
            stringRepoFile
    )
}