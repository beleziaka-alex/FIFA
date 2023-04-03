package com.example.dao

import com.example.models.League
import com.example.models.Player
import com.example.models.Team

interface DAOPlayers{
    suspend fun allPlayers():List<Player>
    suspend fun player(id: Int):Player?
    suspend fun deletePlayer(id: Int):Boolean
    suspend fun addNewPlayer(
        team: String,
        number: Int,
        name: String,
        position: String,
        skill: Int,
        country: String
    ):Player?

}
interface DAOLeagues{
    suspend fun allLeagues():List<League>
    suspend fun league(id: Int):League?
    suspend fun deleteLeague(id: Int):Boolean
    suspend fun addNewLeague(country: String, name: String): League?
}
interface DAOTeams{
    suspend fun allTeams():List<Team>
    suspend fun team(id: Int): Team?
    suspend fun deleteTeam(id: Int): Boolean
    suspend fun addNewTeam(name: String, league: String): Team?
}