package ir.si.app.oskar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.si.app.oskar.api.AppApi
import ir.si.app.oskar.data.OryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject internal constructor(
     private val appApi: AppApi) : ViewModel() {

    val url = MutableLiveData<String>()


    init {
             appApi.getLoginApiForFlowId().enqueue(object :  Callback<OryModel> {
                 override fun onResponse(call: Call<OryModel>, response: Response<OryModel>) {
                     val data = response.body()
                     url.value = data?.ui?.action?.replace("self-service", "ui")

                 }

                 override fun onFailure(call: Call<OryModel>, t: Throwable) {
                     t.printStackTrace()
                 }

             })
         }

}