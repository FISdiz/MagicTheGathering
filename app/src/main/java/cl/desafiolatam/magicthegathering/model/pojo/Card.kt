package cl.desafiolatam.magicthegathering.model.pojo


import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("artist")
    val artist: String,
    @SerializedName("cmc")
    val cmc: Double,
    //val colorIdentity: List<String>,
    //val colors: List<String>,
    @SerializedName("foreignNames")
    val foreignNames: List<ForeignName>,
    @SerializedName("id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("layout")
    val layout: String,
    @SerializedName("legalities")
    val legalities: List<Legality>,
    @SerializedName("manaCost")
    val manaCost: String?,
    @SerializedName("multiverseid")
    val multiverseid: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("originalText")
    val originalText: String,
    @SerializedName("originalType")
    val originalType: String,
    //val printings: List<String>,
    @SerializedName("rarity")
    val rarity: String,
    @SerializedName("rulings")
    val rulings: List<Ruling>,
    @SerializedName("set")
    val `set`: String,
    @SerializedName("setName")
    val setName: String,
    // val subtypes: List<Any>,
    // val supertypes: List<Any>,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("power")
    val power: String,
    @SerializedName("toughness")
    val toughness: String
    // val types: List<String>
)