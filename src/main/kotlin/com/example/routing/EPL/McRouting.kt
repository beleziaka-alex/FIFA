package com.example.routing.EPL

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.mcHistory() {
    get("/leagues/epl/mc") {
        call.respond(
            "Manchester City Football Club, commonly referred to as Man City or simply City, is an English football club based in Manchester that competes in the Premier League, the top division in the English football league system. It founded in 1880 as St. Mark's (West Gorton), then Ardwick Association Football Club in 1887 and Manchester City in 1894. The club's home ground is the Etihad Stadium in east Manchester, to which they moved in 2003, having played at Maine Road since 1923. Manchester City adopted their sky blue home shirts in 1894, in the first season with the current name.[3] Since its inception, the club has won eight league titles, six FA Cups, eight League Cups, six FA Community Shields, and one European Cup Winners' Cup.\n" +
                    "\n" +
                    "The club joined the Football League in 1892, and won their first major honour, the FA Cup, in 1904. The club had its first major period of success in the late 1960s and early 1970s, winning the league title, FA Cup, League Cup, and European Cup Winners Cup under the management of Joe Mercer and Malcolm Allison. After losing the 1981 FA Cup Final, Manchester City went through a period of decline, culminating in relegation to the third tier of English football for the only time in their history in 1998. Following promotion to the top tier in 2001–02, they have remained in the Premier League since 2002–03.\n" +
                    "\n" +
                    "Manchester City received considerable financial investment both in playing staff and facilities following its takeover by Sheikh Mansour bin Zayed Al Nahyan through the Abu Dhabi United Group in 2008.[4] This started a new era of unprecedented success, with the club winning the FA Cup in 2011 and the Premier League in 2012, both their first since the 1960s, followed by another league title in 2014. Under the management of Pep Guardiola, Manchester City won the Premier League in the 2017-18 season, becoming the only team in the competition history to attain 100 points in a single season. In 2018–19, they won four trophies, completing an unprecedented sweep of all domestic titles in England and becoming the first English men's team to win the domestic treble.[5] This was followed by another two consecutive Premier League titles in 2020–21 and 2021–22, the third and fourth in the Guardiola era, as well as the club's first-ever Champions League final in 2021, which they lost to Chelsea. "
        )
    }
}

fun Route.getAllMcPlayers() {
    get("/leagues/epl/mc/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Manchester City" }
        call.respond(players)
    }
}

fun Route.getDefendersMc() {
    get("/leagues/epl/mc/players/defenders") {
        val defenders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Manchester City" }.filter { it.position == "defender" }
                .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersMc() {
    get("/leagues/epl/mc/players/midfielders") {
        val midfielders = DAOPlayersImpl().allPlayers()
            .filter { it.team == "Manchester City" }.filter { it.position == "midfielder" }.map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsMc() {
    get("/leagues/epl/mc/players/forwards") {
        val forwards =
            DAOPlayersImpl().allPlayers().filter { it.team == "Manchester City" }.filter { it.position == "forward" }
                .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersMc() {
    get("/leagues/epl/mc/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Manchester City" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}
