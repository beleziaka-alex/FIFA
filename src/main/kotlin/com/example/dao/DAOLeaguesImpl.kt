package com.example.dao

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.Leagues
import com.example.models.League
import com.example.models.Players
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOLeaguesImpl : DAOLeagues {
    private fun resultToLeague(row: ResultRow) = League(
        id = row[Leagues.id],
        country = row[Leagues.country],
        name = row[Leagues.name]
    )

    override suspend fun allLeagues(): List<League> = dbQuery {
        Leagues.selectAll().map(::resultToLeague)
    }

    override suspend fun league(id: Int): League? = dbQuery {
        Leagues
            .select(Leagues.id eq id)
            .map(::resultToLeague)
            .singleOrNull()
    }

    override suspend fun deleteLeague(id: Int): Boolean = dbQuery {
        Leagues.deleteWhere { Leagues.id eq id } > 0
    }

    override suspend fun addNewLeague(country: String, name: String): League? = dbQuery {
        val leagueToAdd = Leagues.insert {
            it[Leagues.country] = country
            it[Leagues.name] = name
        }
        leagueToAdd.resultedValues?.singleOrNull()?.let(::resultToLeague)

    }
}