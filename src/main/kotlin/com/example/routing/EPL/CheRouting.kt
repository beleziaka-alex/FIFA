package com.example.routing.EPL

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.cheHistory() {
    get("/leagues/epl/che") {
        call.respond(
            "Chelsea Football Club is an English professional football club based in Fulham, West London. Founded in 1905, they play their home games at Stamford Bridge.[6] The club competes in the Premier League, the top division of English football. They won their first major honour, the League championship, in 1955. The club won the FA Cup for the first time in 1970, their first European honour, the Cup Winners' Cup, in 1971, and became the third English club to win the Club World Cup in 2022.\n" +
                    "\n" +
                    "Chelsea are one of five clubs to have won all three pre-1999 main European club competitions, and the only club to have won all three major European competitions twice. They are also the only London club to have won the Champions League and the Club World Cup.[7] Domestically, the club has won six league titles, eight FA Cups, five League Cups, and four FA Community Shields. Internationally, they have won the UEFA Champions League, the UEFA Europa League, the UEFA Cup Winners' Cup and the UEFA Super Cup twice each, and the FIFA Club World Cup once since their inception. In terms of overall trophies won, it is the fourth-most successful club in English football.\n" +
                    "\n" +
                    "The club has rivalries with neighbouring teams Arsenal and Tottenham Hotspur, and a historic rivalry with Leeds United. In terms of club value, Chelsea are the seventh most valuable football club in the world (as of 2021), worth £2.39 billion (\$3.2 billion), and are the eighth highest-earning football club in the world, with earnings of over €493.1 million (as of May 2022)."
        )
    }
}

fun Route.getAllChePlayers() {
    get("/leagues/epl/che/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Chelsea" }
        call.respond(players)
    }
}

fun Route.getDefendersChe() {
    get("/leagues/epl/che/players/defenders") {
        val defenders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Chelsea" }.filter { it.position == "defender" }
                .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersChe() {
    get("/leagues/epl/che/players/midfielders") {
        val midfielders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Chelsea" }.filter { it.position == "midfielder" }
                .map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsChe() {
    get("/leagues/epl/che/players/forwards") {
        val forwards = DAOPlayersImpl().allPlayers().filter { it.team == "Chelsea" }.filter { it.position == "forward" }
            .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersChe() {
    get("/leagues/epl/che/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Chelsea" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}
