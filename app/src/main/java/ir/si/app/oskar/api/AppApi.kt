package ir.si.app.oskar.api


import ir.si.app.oskar.data.OryModel
import retrofit2.Call
import retrofit2.http.*

interface AppApi {

    @GET("self-service/login/api")
    fun getLoginApiForFlowId(): Call<OryModel>


}