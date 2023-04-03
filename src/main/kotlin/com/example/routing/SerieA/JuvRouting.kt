package com.example.routing.SerieA

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.juvHistory() {
    get("/leagues/seriea/juv") {
        call.respondText(
            "Juventus Football Club (from Latin: iuventūs, Italian pronunciation: [juˈvɛntus], 'youth'), colloquially known as Juve (pronounced [ˈjuːve]),[5] is a professional football club based in Turin, Piedmont, Italy, that competes in the Serie A, the top tier of the Italian football league system. Founded in 1897 by a group of Torinese students, the club has worn a black and white striped home kit since 1903 and has played home matches in different grounds around its city, the latest being the 41,507-capacity Juventus Stadium. Nicknamed la Vecchia Signora (\"the Old Lady\"), the club has won 36 official league titles, 14 Coppa Italia titles and nine Supercoppa Italiana titles, being the record holder for all these competitions; two Intercontinental Cups, two European Cups / UEFA Champions Leagues, one European Cup Winners' Cup, a joint national record of three UEFA Cups, two UEFA Super Cups and a joint national record of one UEFA Intertoto Cup.[6][7] Consequently, the side leads the historical Federazione Italiana Giuoco Calcio (FIGC) classification,[c] whilst on the international stage the club occupies the sixth position in Europe and the twelfth in the world for most confederation titles won with eleven trophies,[9] as well as the fourth in the all-time Union of European Football Associations (UEFA) competitions ranking,[d] having obtained the highest coefficient score during seven seasons since its introduction in 1979, the most for an Italian team in both cases and joint second overall in the last cited.\n" +
                    "\n" +
                    "Founded with the name of Sport-Club Juventus, initially as an athletics club,[11] it is the second oldest of its kind still active in the country after Genoa's football section (1893) and has competed every season of the premier club division (reformulated in different formats until the Serie A inception in 1929) since its debut in 1900 with the exception of the 2006–07 season, being managed by the industrial Agnelli family almost continuously since 1923.[e] The relationship between the club and that dynasty is the oldest and longest in national sports, making Juventus one of the first professional sporting clubs ante litteram in the country,[13] having established itself as a major force in the national stage since the 1930s and at confederation level since the mid-1970s,[14] and becoming, in a nearly stable basis, one of the top-ten wealthiest in world football in terms of value, revenue and profit since the mid-1990s,[15] being listed on the Borsa Italiana since 2001.[16] "
        )
    }
}

fun Route.getAllJuvPlayers() {
    get("/leagues/seriea/juv/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Juventus" }
        call.respond(players)
    }
}

fun Route.getDefendersJuv() {
    get("/leagues/seriea/juv/players/defenders") {
        val defenders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Juventus" }.filter { it.position == "defender" }
                .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersJuv() {
    get("/leagues/seriea/juv/players/midfielders") {
        val midfielders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Juventus" }.filter { it.position == "midfielder" }
                .map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsJuv() {
    get("/leagues/seriea/juv/players/forwards") {
        val forwards =
            DAOPlayersImpl().allPlayers().filter { it.team == "Juventus" }.filter { it.position == "forward" }
                .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersJuv() {
    get("/leagues/seriea/juv/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Juventus" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}
