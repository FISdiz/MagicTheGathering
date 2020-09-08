package cl.desafiolatam.magicthegathering.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.desafiolatam.magicthegathering.model.db.CardsEntity

@Dao
interface CardsDao {

    @Query ("SELECT * FROM cards_table")
    fun getAllCards() : LiveData<List<CardsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCards(cardList : List<CardsEntity>)

}