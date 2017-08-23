package com.kevinmost.di.shared.persistence

class InMemoryStringRepository : StringRepository {

    private val repo = mutableListOf<String>()

    override fun save(str: String) {
        repo += str
    }

    override fun loadAll(): Iterable<String> {
        return repo
    }
}