package com.example.models


import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val id: Int = 0,
    val team: String,
    val number: Int,
    val name: String,
    val position: String,
    val skill: Int,
    val country: String
)

object Players : org.jetbrains.exposed.sql.Table() {
    val id = integer("id").autoIncrement()
    val team = varchar("team", 30)
    val number = integer("number")
    val name = varchar("name", 30)
    val position = varchar("position", 20)
    val skill = integer("skill")
    val country = varchar("country", 40)

    override val primaryKey = PrimaryKey(id)

}