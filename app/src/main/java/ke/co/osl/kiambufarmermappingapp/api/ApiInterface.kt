package ke.co.osl.kiambufarmermappingapp.api

import ke.co.osl.kiambufarmermappingapp.models.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface {

    companion object {

//      val BASE_URL = "http://demo.osl.co.ke:444/"
        val BASE_URL = "http://185.215.180.181:7034/"

        fun create() : ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

    @POST("mobile/login")
    fun loginUser(@Body loginBody: LoginBody) : Call<Message>

    @POST("auth/forgot")
    fun recoverPassword(@Body recoverPasswordBody: RecoverPasswordBody) : Call<Message>

    @GET("/farmerresources/{id}")
    fun searchFarmerResources(@Path("id") id: String) : Call<FarmersResourcesBody>

    @GET("/farmergroups/{id}")
    fun searchFarmerAssociations(@Path("id") id: String) : Call<FarmerAssociationsBody>

    @GET("/farmervaluechains/{id}")
    fun searchValueChains(@Path("id") id: String) : Call<List<ValueChainBody>>

    @GET("/farmerdetails/farmerid/{id}")
    fun searchFarmerDetails(@Path("id") id: String) : Call<List<FarmersDetailsGetBody>>

    @GET("/farmeraddress/{id}")
    fun searchFarmerAddress(@Path("id") id: String) : Call<FarmersLocationBody>

    @POST("farmerdetails/create")
    fun postFarmerDetails(@Body farmerDetails: FarmersDetailsBody) : Call<Message>

    @POST("farmeraddress")
    fun postFarmerLocation(@Body farmerLocation: FarmersLocationBody) : Call<Message>

    @POST("farmerresources")
    fun postFarmerResources(@Body farmerResources: FarmersResourcesBody) : Call<Message>

    @POST("farmergroups")
    fun postFarmerAssociations(@Body farmerAssociations: FarmerAssociationsBody) : Call<Message>

    @PUT("farmerdetails/{id}")
    fun putFarmerDetails(@Path("id") id: String, @Body farmerDetails: FarmersDetailsBody) : Call<Message>

    @PUT("farmerresources/{id}")
    fun putFarmerResources(@Path("id") id: String, @Body farmerResources: FarmersResourcesBody) : Call<Message>

    @PUT("farmeraddress/{id}")
    fun putFarmerAddress(@Path("id") id: String, @Body farmerLocation: FarmersLocationBody) : Call<Message>

    @GET("/farmergroups/farmerid/{id}")
    fun showFarmerGroups(@Path("id") id: String) : Call<List<FarmerAssociationsBody>>

    @GET("farmervaluechains/{id}")
    fun showValueChains(@Path("id") id: String) : Call<List<GetValueChainBody>>

    @POST("farmervaluechains")
    fun farmervaluechains(@Body addValueChainBody: AddValueChainBody) : Call<Message>

    @POST("valuechainproduce")
    fun updatevaluechains(@Body updateProduceBody: UpdateProduceBody) : Call<Message>
}

