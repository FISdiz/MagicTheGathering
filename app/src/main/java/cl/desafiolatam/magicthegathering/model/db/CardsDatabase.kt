package cl.desafiolatam.magicthegathering.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CardsEntity::class], version = 1)
abstract class CardsDatabase : RoomDatabase() {

    abstract fun getCardsDao() : CardsDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CardsDatabase? = null

        fun getDatabase(context:Context): CardsDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CardsDatabase::class.java,
                    "hero_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}