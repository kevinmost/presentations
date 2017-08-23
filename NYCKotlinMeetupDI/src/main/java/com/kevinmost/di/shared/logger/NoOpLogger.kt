package com.kevinmost.di.shared.logger

class NoOpLogger : Logger {
    override fun log(level: LogLevel, msg: String) {}
}