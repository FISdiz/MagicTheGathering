package cl.desafiolatam.magicthegathering.model.db

import android.nfc.cardemulation.CardEmulation
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import cl.desafiolatam.magicthegathering.model.pojo.Card
import cl.desafiolatam.magicthegathering.model.pojo.CardsMinimal

@Dao
interface CardsDao {

    @Query ("SELECT * FROM cards_table")
    fun getAllCards() : LiveData<List<CardsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCards(cardList : List<CardsEntity>)

    @Query ("SELECT name, id, favorite, setName FROM cards_table")
    fun getMinimalCards() : LiveData<List<CardsMinimal>>

    @Query ("SELECT * FROM cards_table WHERE id=:id")
    fun getAllDetails(id : String) : LiveData<CardsEntity>

   // @Query ("UPDATE cards_table SET favorite = 1 WHERE id=:id")
   // fun updateFav(id:String)

}