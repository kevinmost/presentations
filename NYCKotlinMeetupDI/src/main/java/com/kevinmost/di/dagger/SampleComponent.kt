package com.kevinmost.di.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        LoggingModule::class,
        PersistenceModule::class
))
interface SampleComponent {
    fun inject(target: Main)
}