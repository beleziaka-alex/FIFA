package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class League(val id: Int = 0, val country: String, val name: String)


object Leagues : org.jetbrains.exposed.sql.Table() {
    val id = integer("id").autoIncrement()
    val country = varchar("country", 25)
    val name = varchar("name", 35)

    override val primaryKey = PrimaryKey(id)

}