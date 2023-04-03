package com.example.routing.LaLiga

import com.example.dao.DAOTeamsImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllLaLigaClubs(){
    get("/leagues/laliga") {
        val teams = DAOTeamsImpl().allTeams().filter { it.league == "La Liga" }.map { it.name }
        call.respond(teams)
    }
}