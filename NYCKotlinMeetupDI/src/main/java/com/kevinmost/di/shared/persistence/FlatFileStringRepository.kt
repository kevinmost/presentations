package com.kevinmost.di.shared.persistence

import com.kevinmost.di.shared.logger.LogLevel
import com.kevinmost.di.shared.logger.Logger
import java.io.File
import java.io.IOException

class FlatFileStringRepository(
        private val logger: Logger,
        private val file: File
) : StringRepository {

    init {
        file.createNewFile()
    }

    override fun save(str: String) {
        try {
            file.appendText(str + "\n")
            logger.log(LogLevel.DEBUG, "wrote string to file successfully: $str")
        } catch(e: IOException) {
            logger.log(LogLevel.ERROR, "error while trying to write string to file: $e")
        }
    }

    override fun loadAll(): Iterable<String> {
        return file.bufferedReader().lineSequence().asIterable()
    }
}