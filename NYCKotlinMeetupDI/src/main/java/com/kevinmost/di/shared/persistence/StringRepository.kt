package com.kevinmost.di.shared.persistence

interface StringRepository {
    fun save(str: String)
    fun loadAll(): Iterable<String>
}
