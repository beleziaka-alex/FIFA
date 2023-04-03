package com.example.routing.EPL

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.livHistory() {
    get("/leagues/epl/liv") {
        call.respond(
            "Liverpool Football Club is a professional football club based in Liverpool, England. The club competes in the Premier League, the top tier of English football. Founded in 1892, the club joined the Football League the following year and has played its home games at Anfield since its formation.\n" +
                    "\n" +
                    "Domestically, the club has won 19 League titles, eight FA Cups, a record nine League Cups and 16 FA Community Shields. In international competitions, the club has won six European Cups, three UEFA Cups, four UEFA Super Cups—all English records—and one FIFA Club World Cup. The club established itself as a major force in domestic and European football in the 1970s and 1980s, when Bill Shankly, Bob Paisley, Joe Fagan and Kenny Dalglish, led the club to a combined 11 League titles and four European Cups. Liverpool won two further European Cups in 2005 and 2019 under the management of Rafael Benítez and Jürgen Klopp, respectively; the latter led Liverpool to a 19th League title in 2020, the club's first during the Premier League era.\n" +
                    "\n" +
                    "Liverpool is one of the most valuable and widely supported clubs in the world. The club has long-standing rivalries with Manchester United and Everton. Under management by Shankly, in 1964 the team changed from red shirts and white shorts to an all-red home strip which has been used ever since. The club's anthem is \"You'll Never Walk Alone\".\n" +
                    "\n" +
                    "The club's supporters have been involved in two major tragedies. The Heysel Stadium disaster, where escaping fans were pressed against a collapsing wall at the 1985 European Cup Final in Brussels, resulted in 39 deaths. Most of these were Italians and Juventus fans. Liverpool were given a six-year ban from European competition, and all other English clubs received a five-year ban. The Hillsborough disaster in 1989, where 97 Liverpool supporters died in a crush against perimeter fencing, led to the elimination of fenced standing terraces in favour of all-seater stadiums in the top two tiers of English football. Prolonged campaigning for justice saw further coroners inquests, commissions and independent panels that ultimately exonerated the fans. "
        )
    }
}

fun Route.getAllLivPlayers() {
    get("/leagues/epl/liv/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Liverpool" }
        call.respond(players)
    }
}

fun Route.getDefendersLiv() {
    get("/leagues/epl/liv/players/defenders") {
        val defenders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Liverpool" }.filter { it.position == "defender" }
                .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersLiv() {
    get("/leagues/epl/liv/players/midfielders") {
        val midfielders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Liverpool" }.filter { it.position == "midfielder" }
                .map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsLiv() {
    get("/leagues/epl/liv/players/forwards") {
        val forwards =
            DAOPlayersImpl().allPlayers().filter { it.team == "Liverpool" }.filter { it.position == "forward" }
                .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersLiv() {
    get("/leagues/epl/liv/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Liverpool" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}
