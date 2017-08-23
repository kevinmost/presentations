package com.kevinmost.di.dagger

import com.kevinmost.di.shared.persistence.StringRepository
import javax.inject.Inject

val component: SampleComponent = DaggerSampleComponent.builder()
        .loggingModule(LoggingModule())
        .persistenceModule(PersistenceModule())
        .build()

fun main(args: Array<String>) {
    Main()
}

class Main {
    @Inject internal lateinit var repo: StringRepository

    init {
        component.inject(this)

        println("Currently-saved text:")
        repo.loadAll().forEach(::println)

        println()
        println("=====================")
        println()

        println("Enter some text to save; enter an empty line to quit")
        generateSequence {
            readLine()?.takeIf { it.isNotEmpty() }
        }.forEach { line ->
            repo.save(line)
        }
    }
}
