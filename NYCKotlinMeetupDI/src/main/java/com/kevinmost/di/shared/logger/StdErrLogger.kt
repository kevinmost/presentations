package com.kevinmost.di.shared.logger

class StdErrLogger : Logger {
    override fun log(level: LogLevel, msg: String) {
        System.err.println("[$level] $msg")
    }
}