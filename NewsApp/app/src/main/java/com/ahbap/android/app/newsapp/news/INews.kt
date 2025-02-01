package com.ahbap.android.app.newsapp.news

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HEAD
import retrofit2.http.Header
import retrofit2.http.Query
// apikey c03ecf4f7c134843b451242858c83bbd
// apikey 652f7a9cea6e4975baadd200bf9799ee
// apikey 471170f739d24111a4139c71b9698fba
// apikey 2a1a84ec2d044cc19f085b7beb410e3e
// apikey bff53fed113b400eba876ec416dbcd5e

// apikey eb904157363b481c95aa48121c7414ea
// apikey 901f543bdc0346979e49d5fe8efb7fd1
interface INews {
    @GET("/v2/everything")
    fun create(@Query("q") city: String,@Query("from") date : String,
               @Query("sortBy") sort : String = "popularity",
               @Query("apiKey") apikey : String = "bff53fed113b400eba876ec416dbcd5e") : Call<NewsSearch>
}