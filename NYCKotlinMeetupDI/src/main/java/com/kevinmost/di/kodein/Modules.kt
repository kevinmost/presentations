package com.kevinmost.di.kodein

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.kevinmost.di.shared.logger.Logger
import com.kevinmost.di.shared.logger.NoOpLogger
import com.kevinmost.di.shared.logger.StdErrLogger
import com.kevinmost.di.shared.persistence.FlatFileStringRepository
import com.kevinmost.di.shared.persistence.StringRepository
import java.io.File

val loggingModule = Kodein.Module {
    bind<Boolean>(tag = "debug") with singleton { false }

    bind<Logger>() with singleton { if (instance<Boolean>(tag = "debug")) StdErrLogger() else NoOpLogger() }
}

val persistenceModule = Kodein.Module {
    bind<File>("stringRepoFile") with singleton { File("/Users/kmost/stringrepo") }

    bind<StringRepository>() with singleton {
        FlatFileStringRepository(
                logger = instance<Logger>(),
                file = instance<File>("stringRepoFile")
        )
    }
}
