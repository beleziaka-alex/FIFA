package com.example.routing

import com.example.dao.DAOLeagues
import com.example.dao.DAOLeaguesImpl
import com.example.models.League
import com.example.models.Leagues
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val leagues: DAOLeagues = DAOLeaguesImpl()

fun Route.getAllLeagues() {
    get("/leagues") {
        val allLeagues = DAOLeaguesImpl().allLeagues()
        val leagueName = allLeagues.map { it.name }
        if (leagueName.isNotEmpty()) {
            call.respond(leagueName)
        } else {
            call.respondText("Leagues are not found", status = HttpStatusCode.NotFound)
        }
    }
}

fun Route.getLeague() {
    get("/leagues/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val league = DAOLeaguesImpl().league(id) ?: return@get call.respondText(
            "League with id $id not found",
            status = HttpStatusCode.NotFound
        )
        call.respond(league)
    }
}

fun Route.addNewLeague() {
    post("/leagues") {
        val league = call.receive<League>()
        leagues.addNewLeague(league.country, league.name)
        call.respondText("A new league was stored correctly", status = HttpStatusCode.OK)
    }
}

fun Route.deleteLeague() {
    delete("/leagues/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        DAOLeaguesImpl().league(id) ?: return@delete call.respondText(
            "League with id $id not found",
            status = HttpStatusCode.NotFound
        )
        DAOLeaguesImpl().deleteLeague(id)
        call.respondText("League with id $id was deleted correctly")
    }
}