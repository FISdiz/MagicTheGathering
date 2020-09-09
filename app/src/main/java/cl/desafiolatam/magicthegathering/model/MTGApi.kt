package cl.desafiolatam.magicthegathering.model

import cl.desafiolatam.magicthegathering.model.pojo.Cards
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MTGApi {

    @GET("cards?page=1")
    fun allCards() : Call<Cards>

}
