package com.example.routing.SerieA

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.intHistory() {
    get("/leagues/seriea/int") {
        call.respondText(
            "Football Club Internazionale Milano, commonly referred to as Internazionale (pronounced [ˌinternattsjoˈnaːle]) or simply Inter, and colloquially known as Inter Milan in English-speaking countries,[8][9] is an Italian professional football club based in Milan, Lombardy. Inter is the only Italian side to have always competed in the top flight of Italian football since its debut in 1909.\n" +
                    "\n" +
                    "Founded in 1908 following a schism within the Milan Cricket and Football Club (now AC Milan), Inter won its first championship in 1910. Since its formation, the club has won 34 domestic trophies, including 19 league titles, 8 Coppa Italia and 7 Supercoppa Italiana. From 2006 to 2010, the club won five successive league titles, equalling the all-time record at that time.[10] They have won the Champions League three times: two back-to-back in 1964 and 1965 and then another in 2010. Their latest win completed an unprecedented Italian seasonal treble, with Inter winning the Coppa Italia and the Scudetto the same year.[11] The club has also won three UEFA Cups, two Intercontinental Cups and one FIFA Club World Cup.\n" +
                    "\n" +
                    "Inter's home games are played at the San Siro stadium, which they share with city rivals Milan. The stadium is the largest in Italian football with a capacity of 75,923.[12] They have long-standing rivalries with Milan, with whom they contest the Derby della Madonnina, and Juventus, with whom they contest the Derby d'Italia; their rivalry with the former is one of the most followed derbies in football.[13] As of 2019, Inter has the highest home game attendance in Italy and the sixth highest attendance in Europe.[14] The club is one of the most valuable in Italian and world football.[15] "
        )
    }
}

fun Route.getAllIntPlayers() {
    get("/leagues/seriea/int/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Inter" }
        call.respond(players)
    }
}

fun Route.getDefendersInt() {
    get("/leagues/seriea/int/players/defenders") {
        val defenders = DAOPlayersImpl().allPlayers().filter { it.team == "Inter" }.filter { it.position == "defender" }
            .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersInt() {
    get("/leagues/seriea/int/players/midfielders") {
        val midfielders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Inter" }.filter { it.position == "midfielder" }
                .map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsInt() {
    get("/leagues/seriea/int/players/forwards") {
        val forwards = DAOPlayersImpl().allPlayers().filter { it.team == "Inter" }.filter { it.position == "forward" }
            .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersInt() {
    get("/leagues/seriea/int/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Inter" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}
