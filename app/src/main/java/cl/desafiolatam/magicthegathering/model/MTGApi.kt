package cl.desafiolatam.magicthegathering.model

import cl.desafiolatam.magicthegathering.model.pojo.Cards
import retrofit2.Call
import retrofit2.http.GET

interface MTGApi {

    @GET("/cards")
    fun allCards() : Call<Cards>

}
