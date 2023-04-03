package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Team(val id: Int = 0, val name: String, val league: String)


object Teams : org.jetbrains.exposed.sql.Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 25)
    val league = varchar("league", 25)
    override val primaryKey = PrimaryKey(id)
}