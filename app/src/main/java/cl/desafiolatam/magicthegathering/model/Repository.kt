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
    var cardList = cardDatabase.getCardsDao().getAllCards()

    fun loadApiData() {
        val call = RetrofitClient.retrofitInstance().allCards()

        call.enqueue(object : Callback<Cards> {
            override fun onFailure(call: Call<Cards>, t: Throwable) {
                Log.d("CALL", "LOAD ERROR")

            }

            override fun onResponse(call: Call<Cards>, response: Response<Cards>) {
                // REVISAR
                saveDatabase(cardConverter(response.body()!!.cards))
            }
        })
    }

    fun cardConverter (cardList : List<Card>) : List<CardsEntity> {
        return cardList.map {card -> CardsEntity(card.artist,
            card.cmc,
            card.colorIdentity,
            card.colors,
            card.foreignNames,
            card.id,
            card.imageUrl,
            card.layout,
            card.legalities,
            card.manaCost,
            card.multiverseid,
            card.name,
            card.number,
            card.originalText,
            card.originalType,
            card.printings,
            card.rarity,
            card.rulings,
            card.set,
            card.setName,
            card.subtypes,
            card.supertypes,
            card.text,
            card.type,
            card.types)}
    }

    fun saveDatabase (listCardsEntity: List<CardsEntity>) {
        CoroutineScope(Dispatchers.IO).launch {
            cardDatabase.getCardsDao().insertCards(listCardsEntity)
        }
    }
}