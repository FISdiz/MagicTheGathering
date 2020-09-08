package cl.desafiolatam.magicthegathering.model.pojo


import com.google.gson.annotations.SerializedName

data class Legality(
    @SerializedName("format")
    val format: String,
    @SerializedName("legality")
    val legality: String
)