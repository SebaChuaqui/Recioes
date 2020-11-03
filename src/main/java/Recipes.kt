
import com.google.gson.annotations.SerializedName

data class Recipes(
    @SerializedName("recetario")
    val recetario: List<Recetario>
)