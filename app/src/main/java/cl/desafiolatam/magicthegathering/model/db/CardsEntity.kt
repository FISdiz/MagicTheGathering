package cl.desafiolatam.magicthegathering.model.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.desafiolatam.magicthegathering.model.pojo.ForeignName
import cl.desafiolatam.magicthegathering.model.pojo.Legality
import cl.desafiolatam.magicthegathering.model.pojo.Ruling
import com.google.gson.annotations.SerializedName

@Entity (tableName = "cards_table")
data class CardsEntity (
    val artist: String,
    val cmc: Double,
    @PrimaryKey
        val id: String,
    val imageUrl: String?,
    val layout: String,
    val manaCost: String,
    val multiverseid: Int,
    val name: String,
    val number: String,
    val originalText: String?,
    val originalType: String?,
    val rarity: String,
    val set: String,
    val setName: String,
    val text: String?,
    val type: String,
    val power: Int,
    val toughness: Int
)

    /*
    @Embedded(prefix = "fname_")
    val foreignNames: List<ForeignName>,
    @Embedded(prefix = "legal_")
    val legalities: List<Legality>,
    @Embedded(prefix = "ruling_")
    val rulings: List<Ruling>,
    val printings: List<String>,
    val subtypes: List<Any>,
    val supertypes: List<Any>,
    val types: List<String>,
    val colorIdentity: List<String>,
    val colors: List<String>
     */