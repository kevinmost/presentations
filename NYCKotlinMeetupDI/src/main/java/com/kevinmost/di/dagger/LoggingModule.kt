package com.kevinmost.di.dagger

import com.kevinmost.di.shared.logger.Logger
import com.kevinmost.di.shared.logger.NoOpLogger
import com.kevinmost.di.shared.logger.StdErrLogger
import dagger.Module
import dagger.Provides
import java.io.PrintStream
import javax.inject.Named
import javax.inject.Singleton

@Module
class LoggingModule {
    @Provides @Singleton fun provideLogStream(): PrintStream = System.err

    // Set to false via your build tools to disable logging in production
    @Provides @Singleton @Named("DEBUG") fun provideDebug(): Boolean = true

    @Provides @Singleton fun provideLogger(@Named("DEBUG") debug: Boolean): Logger {
        return if (debug) StdErrLogger() else NoOpLogger()
    }
}

