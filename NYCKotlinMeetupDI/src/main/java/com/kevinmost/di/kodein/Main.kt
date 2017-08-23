package com.kevinmost.di.kodein

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.instance
import com.kevinmost.di.shared.persistence.StringRepository

val kodein = Kodein {
    import(loggingModule)
    import(persistenceModule)
}

fun main(args: Array<String>) {
    Main()
}

class Main : KodeinInjected {
    override val injector = KodeinInjector()

    private val repo by instance<StringRepository>()

    init {
        injector.inject(kodein)

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
