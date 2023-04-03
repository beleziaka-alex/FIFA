package com.example.routing.SerieA

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.milHistory() {
    get("/leagues/seriea/mil") {
        call.respondText(
            "Associazione Calcio Milan (Italian pronunciation: [assotʃatˈtsjoːne ˈkaltʃo ˈmiːlan]), commonly referred to as AC Milan (Italian pronunciation: [a ˈtʃi ˈmiːlan]) or simply Milan (Italian pronunciation: [miːlan]), is a professional football club in Milan, Italy, founded in 1899.[5][6] The club has spent its entire history, with the exception of the 1980–81 and 1982–83 seasons, in the top flight of Italian football, known as Serie A since 1929–30.[5]\n" +
                    "\n" +
                    "AC Milan's 18 FIFA and UEFA trophies is the fourth highest out of any club (joint with Boca Juniors[nb 1]), and the most out of any Italian club.[7][8][9][10] Milan has won a joint record three Intercontinental Cups and one FIFA Club World Cup,[10] seven European Cup/Champions League titles (Italian record),[10] the UEFA Super Cup a joint record five times and the Cup Winners' Cup twice.[10] With 19 league titles, Milan is tied as the second most successful club in Serie A with local rivals Inter Milan (also with 19 league titles), behind Juventus (36 league titles).[11] They have also won the Coppa Italia five times, and the Supercoppa Italiana seven.[10]\n" +
                    "\n" +
                    "Milan's home games are played at San Siro, also known as the Stadio Giuseppe Meazza. The stadium, which was built by Milan's second chairman Piero Pirelli in 1926 and is shared since 1947 with city rivals Internazionale,[12] is the largest in Italian football, with a total capacity of 75,923.[13] They have a long-standing rivalry with Inter, with whom they contest the Derby della Madonnina which is one of the most followed derbies in football.[14]\n" +
                    "\n" +
                    "The club is one of the wealthiest in Italian and world football.[15] It was a founding member of the now-defunct G-14 group of Europe's leading football clubs as well as its replacement, the European Club Association.[16] "
        )
    }
}

fun Route.getAllMilPlayers() {
    get("/leagues/seriea/mil/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Milan" }
        call.respond(players)
    }
}

fun Route.getDefendersMil() {
    get("/leagues/seriea/mil/players/defenders") {
        val defenders = DAOPlayersImpl().allPlayers().filter { it.team == "Milan" }.filter { it.position == "defender" }
            .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersMil() {
    get("/leagues/seriea/mil/players/midfielders") {
        val midfielders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Milan" }.filter { it.position == "midfielder" }
                .map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsMil() {
    get("/leagues/seriea/mil/players/forwards") {
        val forwards = DAOPlayersImpl().allPlayers().filter { it.team == "Milan" }.filter { it.position == "forward" }
            .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersMil() {
    get("/leagues/seriea/mil/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Milan" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}
