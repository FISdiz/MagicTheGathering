package cl.desafiolatam.magicthegathering.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.magicthegathering.io/v1/"

class RetrofitClient {

    companion object {

        fun retrofitInstance() : MTGApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(MTGApi::class.java)
        }
    }
}