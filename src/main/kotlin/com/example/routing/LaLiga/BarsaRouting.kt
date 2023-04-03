package com.example.routing.LaLiga

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.barHistory() {
    get("/leagues/laliga/bar") {
        call.respondText(
            "Futbol Club Barcelona (Catalan pronunciation: [fubˈbɔl ˈklub bəɾsəˈlonə] (listen)), commonly referred to as Barcelona and colloquially known as Barça ([ˈbaɾsə]), is a professional football club based in Barcelona, Catalonia, Spain, that competes in La Liga, the top flight of Spanish football.\n" +
                    "\n" +
                    "Founded in 1899 by a group of Swiss, Catalan, German, and English footballers led by Joan Gamper, the club has become a symbol of Catalan culture and Catalanism, hence the motto \"Més que un club\" (\"More than a club\"). Unlike many other football clubs, the supporters own and operate Barcelona. It is the fourth-most valuable sports team in the world, worth \$4.76 billion, and the world's fourth richest football club in terms of revenue, with an annual turnover of €582.1 million.[2][3] The official Barcelona anthem is the \"Cant del Barça\", written by Jaume Picas and Josep Maria Espinàs.[4] Barcelona traditionally play in dark shades of blue and garnet stripes, hence nicknamed Blaugrana.\n" +
                    "\n" +
                    "Domestically, Barcelona has won a record 76 trophies: 26 La Liga, 31 Copa del Rey, fourteen Supercopa de España, three Copa Eva Duarte, and two Copa de la Liga titles, as well as being the record holder for the latter four competitions. In international club football, the club has won 22 European and worldwide titles: five UEFA Champions League titles, a record four UEFA Cup Winners' Cups, a joint record five UEFA Super Cups, a record three Inter-Cities Fairs Cups, a joint record two Latin Cups and three FIFA Club World Cups.[5] Barcelona was ranked first in the International Federation of Football History & Statistics Club World Ranking for 1997, 2009, 2011, 2012 and 2015, and occupies the seventh position on the UEFA club rankings as of February 2023.[6][7][8] The club has a long-standing rivalry with Real Madrid, and matches between the two teams are referred to as El Clásico.\n" +
                    "\n" +
                    "Barcelona is one of the most widely supported teams in the world, and the club has one of the largest social media following in the world among sports teams.[9][10] Barcelona players have won a record twelve Ballon d'Or awards, with recipients including Johan Cruyff, as well as a record seven FIFA World Player of the Year awards, with winners including Romário, Ronaldo, Rivaldo and Ronaldinho. In 2010, three players who came through the club's youth academy (Lionel Messi, Andrés Iniesta and Xavi) were chosen as the three best players in the world in the FIFA Ballon d'Or awards, an unprecedented feat for players from the same football academy. Additionally, players representing the club have won a record eight European Golden Shoe awards. "
        )
    }
}

fun Route.getAllBarPlayers() {
    get("/leagues/laliga/bar/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Barcelona" }
        call.respond(players)
    }
}

fun Route.getDefendersBar() {
    get("/leagues/laliga/bar/players/defenders") {
        val defenders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Barcelona" }.filter { it.position == "defender" }
                .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersBar() {
    get("/leagues/laliga/bar/players/midfielders") {
        val midfielders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Barcelona" }.filter { it.position == "midfielder" }
                .map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsBar() {
    get("/leagues/laliga/bar/players/forwards") {
        val forwards =
            DAOPlayersImpl().allPlayers().filter { it.team == "Barcelona" }.filter { it.position == "forward" }
                .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersBar() {
    get("/leagues/laliga/bar/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Barcelona" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}
