package com.example.routing

import com.example.dao.DAOPlayers
import com.example.dao.DAOPlayersImpl
import com.example.models.Player
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


val players: DAOPlayers = DAOPlayersImpl()

fun Route.getAllPlayers() {
    get("/players") {
        val players = DAOPlayersImpl().allPlayers()
        if (players.isNotEmpty()) {
            call.respond(players)
        } else {
            call.respondText("Players were not found", status = HttpStatusCode.NotFound)
        }
    }
}

fun Route.getPlayer() {
    get("/players/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val player = DAOPlayersImpl().player(id) ?: return@get call.respondText(
            "Player with id $id not found",
            status = HttpStatusCode.NotFound
        )
        call.respond(player)

    }
}

fun Route.addNewPlayer() {
    post("/players") {
        val player = call.receive<Player>()
        players.addNewPlayer(player.team, player.number, player.name, player.position, player.skill, player.country)
        call.respondText("A new players was stored correctly", status = HttpStatusCode.OK)
    }
}

fun Route.deletePlayer() {
    delete("/players/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val player = DAOPlayersImpl().player(id) ?: return@delete call.respondText(
            "Player with id $id not found",
            status = HttpStatusCode.NotFound
        )
        DAOPlayersImpl().deletePlayer(id)
        call.respondText("Player $player was deleted correctly", status = HttpStatusCode.OK)
    }
}

fun Route.homePage() {
    get {
        call.respondText(
            "Welcome to homepage." +
                    " Federation Internationale de Football Association – в форме аббревиатуры формирует FIFA, а в русскоязычной транскрипции получается искомая ФИФА. Официально наименование организации звучит примерно так – международный руководящий и контролирующий орган ассоциации футбола, пляжного футбола и мини-футбола (он же футзал). На самом деле, это не единственная подобная организация в своем роде, есть «местечковые» комитеты и контролирующие органы, которые занимаются устроением футбольных соревнований между странами ограниченных регионов, например, в Африке, обеих Америках и пр., однако, они не в состоянии организовывать турниры и чемпионаты планетарного масштаба, так что в этом смысле у ФИФА конкурентов нет, да и быть не может, так как они просто не нужны, FIFA и так отлично справляется со своими функциями.Организация эта некоммерческая, ныне базируется в Швейцарии по ряду причин, в том числе, символическим – эта страна уже несколько столетий придерживается политики международного нейтралитета, а в футболе важна не столько защита национальных интересов, сколько равенство всех и вся, непредвзятость как экономическая, так и политическая при принятии разного рода решений и пр. "
        )
    }
}