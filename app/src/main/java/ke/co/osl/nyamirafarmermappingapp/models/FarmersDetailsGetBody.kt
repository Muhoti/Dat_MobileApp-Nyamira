package ke.co.osl.nyamirafarmermappingapp.models

data class FarmersDetailsGetBody(
    val ID: String,
    val NationalID: String,
    val Name: String,
    val Phone: String,
    val Gender: String,
    val AgeGroup: String,
    val FarmingType: String
)