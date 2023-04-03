package com.example.routing.LaLiga

import com.example.dao.DAOPlayersImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.rmaHistory() {
    get("/leagues/laliga/rma") {
        call.respondText(
            "Real Madrid Club de Fútbol , meaning Royal Madrid Football Club), commonly referred to as Real Madrid, is a Spanish professional football club based in Madrid.\n" +
                    "\n" +
                    "Founded in 1902 as Madrid Football Club, the club has traditionally worn a white home kit since its inception. The honorific title real is Spanish for \"royal\" and was bestowed to the club by King Alfonso XIII in 1920 together with the royal crown in the emblem. Real Madrid have played their home matches in the 81,044-capacity Santiago Bernabéu Stadium in downtown Madrid since 1947. Unlike most European sporting entities, Real Madrid's members (socios) have owned and operated the club throughout its history.\n" +
                    "\n" +
                    "Real Madrid is one of the most widely supported teams internationally.[6] The club was estimated to be worth \$5.1 billion in 2022, making it the world's most valuable football team.[7] In 2021, it was the second highest-earning football club in the world, with an annual revenue of €640.7 million.[8]\n" +
                    "\n" +
                    "Being one of the three founding members of La Liga that have never been relegated from the top division since its inception in 1929 (along with Athletic Bilbao and Barcelona), Real Madrid holds many long-standing rivalries, most notably El Clásico with Barcelona and El Derbi Madrileño with Atlético Madrid. The club established itself as a major force in both Spanish and European football during the 1950s and 60s, winning five consecutive and six overall European Cups and reaching a further two finals. This success was replicated on the domestic front, with Madrid winning twelve league titles in the span of 16 years. This team, which included Alfredo Di Stéfano, Ferenc Puskás, Francisco Gento, and Raymond Kopa, is considered by some in the sport to be the greatest of all time.[9][10][11] Real Madrid was later known for its \"Galácticos\" policy, which involved signing the world's best players, such as Ronaldo, Zidane, and David Beckham.[12] On 26 June 2009, Madrid signed Cristiano Ronaldo for a record breaking £80 million (€94 million),[13] who went onto become the club's all-time top goalscorer.[14]\n" +
                    "\n" +
                    "In domestic football, the club has won 68 trophies; a record 35 La Liga titles, 19 Copa del Rey, 12 Supercopa de España, a Copa Eva Duarte, and a Copa de la Liga.[15] In European football, Real Madrid have won a record 21 trophies;[note 1] a record 14 European Cup/UEFA Champions League titles, two UEFA Cups, and a record[note 2] five UEFA Super Cups. In worldwide competitions, they have achieved a record eight club world championships.[note 3] "
        )
    }
}

fun Route.getAllRmaPlayers() {
    get("/leagues/laliga/rma/players") {
        val players = DAOPlayersImpl().allPlayers().filter { it.team == "Real Madrid" }
        call.respond(players)
    }
}

fun Route.getDefendersRma() {
    get("/leagues/laliga/rma/players/defenders") {
        val defenders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Real Madrid" }.filter { it.position == "defender" }
                .map { it.name }
        call.respond(defenders)
    }
}

fun Route.getMidfieldersRma() {
    get("/leagues/laliga/rma/players/midfielders") {
        val midfielders =
            DAOPlayersImpl().allPlayers().filter { it.team == "Real Madrid" }.filter { it.position == "midfielder" }
                .map { it.name }
        call.respond(midfielders)
    }
}

fun Route.getForwardsRma() {
    get("/leagues/laliga/rma/players/forwards") {
        val forwards =
            DAOPlayersImpl().allPlayers().filter { it.team == "Real Madrid" }.filter { it.position == "forward" }
                .map { it.name }
        call.respond(forwards)
    }
}

fun Route.getGoalkeepersRma() {
    get("/leagues/laliga/rma/players/goalkeepers") {
        val goalkeepers =
            DAOPlayersImpl().allPlayers().filter { it.team == "Real Madrid" }.filter { it.position == "goalkeeper" }
                .map { it.name }
        call.respond(goalkeepers)
    }
}
