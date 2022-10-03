package ke.co.osl.kiambufarmermappingapp.models

data class FarmersLocationBody(
    val FarmerID: String,
    val County: String,
    val SubCounty: String,
    val Ward: String,
    val Latitude: String,
    val Longitude: String,
    val Village: String
)
