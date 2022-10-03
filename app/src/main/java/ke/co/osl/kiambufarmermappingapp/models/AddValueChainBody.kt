package ke.co.osl.kiambufarmermappingapp.models

data class AddValueChainBody(
    val FarmerID: String,
    val Name: String,
    val Variety: String,
    val Unit: String,
    val ApproxAcreage: String,
    val AvgYearlyProduction: String,
    val AvgHarvestProduction: String
    )