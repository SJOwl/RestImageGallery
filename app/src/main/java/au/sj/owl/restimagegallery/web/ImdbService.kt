package au.sj.owl.restimagegallery.web

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ImdbService {

    @GET("chart/top")
    fun getPage(): Call<String>
}