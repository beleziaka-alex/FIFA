package com.example.routing.LaLiga

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.atlMHistory() {
    get("/leagues/laliga/atlm") {
        call.respondText(
            "Club Atlético de Madrid, S.A.D. (Spanish pronunciation: [ˈkluβ aˈtletiko ðe maˈðɾið]; meaning \"Athletic Club of Madrid\"), known simply as Atleti in the Spanish-speaking world and commonly referred to at international level as Atlético Madrid, is a Spanish professional football club based in Madrid that plays in La Liga. The club play their home games at the Metropolitano, which has a capacity of 68,456.[3]\n" +
                    "\n" +
                    "In terms of league titles won, Atlético Madrid are the third most successful club in Spanish football—behind Real Madrid and Barcelona. Atlético have won La Liga on eleven occasions, including a league and cup double in 1996; the Copa del Rey on ten occasions; two Supercopas de España, one Copa Presidente FEF [es] and one Copa Eva Duarte; in Europe, they won the European Cup Winners' Cup in 1962, were runners-up in 1963 and 1986, were UEFA Champions League runners-up in 1974, 2014 and 2016,[8] won the Europa League in 2010, 2012 and 2018, and won the UEFA Super Cup in 2010, 2012 and 2018 as well as the 1974 Intercontinental Cup.\n" +
                    "\n" +
                    "Atlético's home kit is red and white vertical striped shirts, blue shorts, and blue and red socks. This combination has been used since 1911. Throughout their history the club has been known by a number of nicknames, including Los Colchoneros (\"The Mattress Makers\"), due to their first team stripes being the same colours as traditional mattresses. During the 1970s, they became known as Los Indios, which some attribute to the club's signing several South American players after the restrictions on signing foreign players were lifted. However, there are a number of alternative theories which claim they were named so because their stadium was \"camped\" on the river bank, or because Los Indios (The Indians) were the traditional enemy of Los Blancos (The Whites), which is the nickname of the club's city rivals, Real Madrid.[9] Felipe VI, the king of Spain, has been the honorary president of the club since 2003. "
        )
    }
}

fun Route.getAllAtlMPlayers() {
    get("/leagues/laliga/atlm/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Atl. Madrid" }
        call.respond(players)
    }
}

fun Route.getDefendersAtlM() {
    get("/leagues/laliga/atlm/players/defenders") {
        val defenders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Atl. Madrid" }.filter { it.position == "defender" }
                .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersAtlM() {
    get("/leagues/laliga/atlm/players/midfielders") {
        val midfielders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Atl. Madrid" }.filter { it.position == "midfielder" }
                .map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsAtlM() {
    get("/leagues/laliga/atlm/players/forwards") {
        val forwards =
            DAOPlayersImpl().allPlayers().filter { it.team == "Atl. Madrid" }.filter { it.position == "forward" }
                .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersAtlM() {
    get("/leagues/laliga/atlm/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Atl. Madrid" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}