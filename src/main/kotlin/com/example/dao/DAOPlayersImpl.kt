package com.example.dao

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.Player
import com.example.models.Players
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOPlayersImpl : DAOPlayers {

    private fun resultToPlayer(row: ResultRow) = Player(
        id = row[Players.id],
        team = row[Players.team],
        number = row[Players.number],
        name = row[Players.name],
        skill = row[Players.skill],
        position = row[Players.position],
        country = row[Players.country]

    )

    override suspend fun allPlayers(): List<Player> = dbQuery {
        Players
            .selectAll()
            .map(::resultToPlayer)
    }

    override suspend fun player(id: Int): Player? = dbQuery {
        Players
            .select(Players.id eq id)
            .map(::resultToPlayer)
            .singleOrNull()
    }

    override suspend fun deletePlayer(id: Int): Boolean = dbQuery {
        Players.deleteWhere { Players.id eq id } > 0
    }

    override suspend fun addNewPlayer(
        team: String,
        number: Int,
        name: String,
        position: String,
        skill: Int,
        country: String
    ): Player? = dbQuery {
        val playerToAdd = Players.insert {
            it[Players.team] = team
            it[Players.number] = number
            it[Players.name] = name
            it[Players.position] = position
            it[Players.skill] = skill
            it[Players.country] = country
        }
        playerToAdd.resultedValues?.singleOrNull()?.let(::resultToPlayer)

    }
}