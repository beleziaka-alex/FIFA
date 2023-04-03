package com.example.routing.SerieA

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.napHistory() {
    get("/leagues/seriea/nap") {
        call.respondText(
            "Società Sportiva Calcio Napoli, commonly referred to as Napoli (pronounced [ˈnaːpoli]), is an Italian professional football club based in the city of Naples, Campania that plays in Serie A, the top flight of Italian football. Napoli has won two Serie A titles, six Coppa Italia titles, two Supercoppa Italiana titles, and one UEFA Cup.[1][2]\n" +
                    "The performance of Napoli in the Italian football league system since the first season of a unified Serie A (1929–30)\n" +
                    "\n" +
                    "The club was formed in 1926 as Associazione Calcio Napoli following the merger of U.S. Internazionale Napoli and Naples Foot-Ball Club. Napoli saw relatively little success in its early years, winning their first major trophy in the 1962 Coppa Italia. Napoli then saw increased success in the late 1970s (including their second Coppa Italia in 1976) and especially in the 1980s, after the club acquired Diego Maradona in 1984. During his time in Naples, Maradona helped the team win several trophies, which led to the club retiring his number 10 jersey. During this period, Napoli won both of their league titles, in 1987 and 1990, the 1987 Coppa Italia, the 1990 Supercoppa Italiana, and their only European trophy with the 1989 UEFA Cup. Following his departure, however, Napoli struggled financially, and endured several relegations and a bankruptcy, prior to being re-founded in 2004 by film producer Aurelio De Laurentiis. Under his leadership, the club has stabilized, which has led to renewed on-field success, winning 2005-06 Serie C1, the 2012, 2014, and 2020 Coppa Italia titles, and the 2014 Supercoppa Italiana.\n" +
                    "\n" +
                    "By attendance, Napoli have the fourth-largest fan base in Italy,[3] and were ranked as the fifth highest-earning football club in Serie A, with \$182 million in revenue during the 2017–18 season.[4] In 2018, Forbes estimated the club is the fifth most valuable club in Italy, worth \$379 million. Napoli are also one of the associate members of the European Club Association.\n" +
                    "\n" +
                    "Since 1959, the club has played their home games at the Stadio San Paolo, which was renamed Stadio Diego Armando Maradona after the Argentine's death in 2020. Napoli traditionally wear sky blue shirts, white shorts, and sky blue socks at home and white shirts, white or sky blue shorts, and white or sky blue socks away; this is derived from the shirts of Naples FBC and the shorts of Internazionale Napoli after the clubs merged to form Napoli in 1922. Napoli have rivalries with Roma, Juventus and Palermo. The club's anthem is \"'O surdato 'nnammurato\", one of the most famous songs in the Neapolitan language.[5]\n"
        )
    }
}

fun Route.getAllNapPlayers() {
    get("/leagues/seriea/nap/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Napoli" }
        call.respond(players)
    }
}

fun Route.getDefendersNap() {
    get("/leagues/seriea/nap/players/defenders") {
        val defenders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Napoli" }.filter { it.position == "defender" }
                .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersNap() {
    get("/leagues/seriea/nap/players/midfielders") {
        val midfielders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Napoli" }.filter { it.position == "midfielder" }
                .map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsNap() {
    get("/leagues/seriea/nap/players/forwards") {
        val forwards = DAOPlayersImpl().allPlayers().filter { it.team == "Napoli" }.filter { it.position == "forward" }
            .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersNap() {
    get("/leagues/seriea/nap/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Napoli" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}
