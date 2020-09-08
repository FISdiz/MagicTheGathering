package cl.desafiolatam.magicthegathering.model.pojo


import com.google.gson.annotations.SerializedName

data class Ruling(
    @SerializedName("date")
    val date: String,
    @SerializedName("text")
    val text: String
)