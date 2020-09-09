package cl.desafiolatam.magicthegathering.model

import android.content.Context
import android.util.Log
import cl.desafiolatam.magicthegathering.model.db.CardsDatabase
import cl.desafiolatam.magicthegathering.model.db.CardsEntity
import cl.desafiolatam.magicthegathering.model.pojo.Card
import cl.desafiolatam.magicthegathering.model.pojo.Cards
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(context: Context) {

    var cardDatabase = CardsDatabase.getDatabase(context)
    var cardList = cardDatabase.getCardsDao().getMinimalCards()

    fun loadApiData() {
        val call = RetrofitClient.retrofitInstance().allCards()

        call.enqueue(object : Callback<Cards> {
            override fun onFailure(call: Call<Cards>, t: Throwable) {
                Log.d("CALL", "LOAD ERROR")

            }

            override fun onResponse(call: Call<Cards>, response: Response<Cards>) {
                Log.d("REPO", "${response.code()}")
                Log.d("REPO", "${response.body()}")
                if (response.isSuccessful) {
                    saveDatabase(cardConverter(response.body()!!))
                } else {
                    Log.d("REPO", "${call.request().url()}")
                }

            }
        })
    }

    fun cardConverter (cardList : Cards) : List<CardsEntity> {
        return cardList.cards.map {card -> CardsEntity(card.artist,
            card.cmc,
            card.id,
            //elvis operator (puede ser nulo)
            card.imageUrl ?:"",
            card.layout,
            card.manaCost ?:"",
            card.multiverseid,
            card.name,
            card.number,
            card.originalText ?:"",
            card.originalType ?:"",
            card.rarity,
            card.set,
            card.setName,
            card.text ?:"",
            card.type
        )}
            /*
            card.foreignNames,
            card.legalities,
            card.rulings,
            card.types,
            card.colors,
            card.supertypes,
            card.colorIdentity,
            card.subtypes,
            card.printings
            */
    }

    fun saveDatabase (listCardsEntity: List<CardsEntity>) {
        CoroutineScope(Dispatchers.IO).launch {
            cardDatabase.getCardsDao().insertCards(listCardsEntity)
        }
    }
}