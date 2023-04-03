package com.example.routing


import com.example.dao.DAOTeams
import com.example.dao.DAOTeamsImpl
import com.example.models.Team
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val teams: DAOTeams = DAOTeamsImpl()

fun Route.getAllTeams() {
    get("/leagues/teams") {
        val allTeams = DAOTeamsImpl().allTeams()
        if (allTeams.isNotEmpty()) {
            call.respond(allTeams)
        } else {
            call.respondText("Teams are not found", status = HttpStatusCode.NotFound)
        }
    }
}

fun Route.getTeam() {
    get("/leagues/teams/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val team = DAOTeamsImpl().team(id) ?: return@get call.respondText(
            "Not found team with id $id",
            status = HttpStatusCode.NotFound
        )
        call.respond(team)
    }
}

fun Route.deleteTeam() {
    delete("/leagues/teams/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val team = DAOTeamsImpl().team(id) ?: return@delete call.respondText(
            "Not found team with id $id",
            status = HttpStatusCode.NotFound
        )
        DAOTeamsImpl().deleteTeam(id)
        call.respondText("Team $team was deleted correctly")
    }
}

fun Route.addNewTeam() {
    post("/leagues/teams") {
        val team = call.receive<Team>()
        teams.addNewTeam(team.name, team.league)
        call.respondText("New team was stored correctly", status = HttpStatusCode.OK)
    }
}