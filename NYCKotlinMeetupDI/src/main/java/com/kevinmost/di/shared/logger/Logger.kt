package com.kevinmost.di.shared.logger

enum class LogLevel {
    DEBUG,
    INFO,
    WARN,
    ERROR
}

interface Logger {
    fun log(level: LogLevel, msg: String)
}