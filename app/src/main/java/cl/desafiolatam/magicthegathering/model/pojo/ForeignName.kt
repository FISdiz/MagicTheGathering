package cl.desafiolatam.magicthegathering.model.pojo


import com.google.gson.annotations.SerializedName

data class ForeignName(
    @SerializedName("flavor")
    val flavor: Any,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("multiverseid")
    val multiverseid: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("text")
    val text: String
)