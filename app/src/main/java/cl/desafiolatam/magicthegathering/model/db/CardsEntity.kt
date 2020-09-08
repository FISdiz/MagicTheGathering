package cl.desafiolatam.magicthegathering.model.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.desafiolatam.magicthegathering.model.pojo.ForeignName
import cl.desafiolatam.magicthegathering.model.pojo.Legality
import cl.desafiolatam.magicthegathering.model.pojo.Ruling

@Entity (tableName = "cards_table")
data class CardsEntity (
    val artist: String,
    val cmc: Double,
    val colorIdentity: List<String>,
    val colors: List<String>,
    @Embedded(prefix = "fname_") val foreignNames: List<ForeignName>,
    @PrimaryKey val id: String,
    val imageUrl: String,
    val layout: String,
    @Embedded(prefix = "legal_") val legalities: List<Legality>,
    val manaCost: String,
    val multiverseid: Int,
    val name: String,
    val number: String,
    val originalText: String,
    val originalType: String,
    val printings: List<String>,
    val rarity: String,
    @Embedded(prefix = "ruling_") val rulings: List<Ruling>,
    val `set`: String,
    val setName: String,
    val subtypes: List<Any>,
    val supertypes: List<Any>,
    val text: String,
    val type: String,
    val types: List<String>
)