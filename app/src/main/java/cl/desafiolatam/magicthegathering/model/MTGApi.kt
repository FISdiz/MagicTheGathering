package cl.desafiolatam.magicthegathering.model

import cl.desafiolatam.magicthegathering.model.pojo.Cards
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MTGApi {

    @GET("cards")
    fun allCards(@Query("page") page : String) : Call<Cards>


}
