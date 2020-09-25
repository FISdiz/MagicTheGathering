package cl.desafiolatam.magicthegathering.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class TagListTypeConverter {
    @TypeConverter
    fun fromListToString(list: List<String>) = Gson().toJson(list)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}