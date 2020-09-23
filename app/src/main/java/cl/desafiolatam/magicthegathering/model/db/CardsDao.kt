package cl.desafiolatam.magicthegathering.model.db

import android.nfc.cardemulation.CardEmulation
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.desafiolatam.magicthegathering.model.pojo.CardsMinimal

@Dao
interface CardsDao {

    @Query ("SELECT * FROM cards_table")
    fun getAllCards() : LiveData<List<CardsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCards(cardList : List<CardsEntity>)

    @Query ("SELECT name, id FROM cards_table")
    fun getMinimalCards() : LiveData<List<CardsMinimal>>

    @Query ("SELECT * FROM cards_table WHERE id=:id")
    fun getAllDetails(id : String) : LiveData<CardsEntity>
}