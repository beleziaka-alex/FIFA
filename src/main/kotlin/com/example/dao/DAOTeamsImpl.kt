package com.example.dao

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.Team
import com.example.models.Teams
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOTeamsImpl : DAOTeams {
    private fun resultToTeam(row: ResultRow) = Team(
        id = row[Teams.id],
        name = row[Teams.name],
        league = row[Teams.league]
    )

    override suspend fun allTeams(): List<Team> = dbQuery {
        Teams.selectAll().map(::resultToTeam)
    }

    override suspend fun team(id: Int): Team? = dbQuery {
        Teams
            .select(Teams.id eq id)
            .map(::resultToTeam)
            .singleOrNull()
    }

    override suspend fun deleteTeam(id: Int): Boolean = dbQuery {
        Teams.deleteWhere { Teams.id eq id } > 0
    }

    override suspend fun addNewTeam(name: String, league: String): Team? = dbQuery {
        val team = Teams.insert {
            it[Teams.name] = name
            it[Teams.league] = league
        }
        team.resultedValues?.singleOrNull()?.let(::resultToTeam)
    }
}