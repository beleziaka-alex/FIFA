package com.example.routing.SerieA

import com.example.dao.DAOTeamsImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllSerieAClubs(){
    get("/leagues/seriea") {
        val teams = DAOTeamsImpl().allTeams().filter { it.league == "Serie A" }.map { it.name }
        call.respond(teams)
    }
}