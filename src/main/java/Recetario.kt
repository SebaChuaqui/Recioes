
import com.google.gson.annotations.SerializedName

data class Recetario(
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("Ingredientes")
    val ingredientes: String,
    @SerializedName("Nombre Receta")
    val nombreReceta: String,
    @SerializedName("Preparacion")
    val preparacion: String,
    @SerializedName("Recomendacion")
    val recomendacion: String
)