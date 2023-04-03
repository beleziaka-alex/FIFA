package com.example.routing.EPL

import com.example.dao.DAOTeamsImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllEPLClubs(){
    get("/leagues/epl") {
        val teams = DAOTeamsImpl().allTeams().filter { it.league == "EPL" }.map { it.name }
        call.respond(teams)

    }
}