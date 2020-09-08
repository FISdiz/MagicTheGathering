package cl.desafiolatam.magicthegathering.model.pojo

import com.google.gson.annotations.SerializedName

data class Cards(
    @SerializedName("cards")
    val cards: List<Card>
)