package services

import model.Article
import model.ArticleResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("/v2/everything")
    fun list(@Query("q") q: String?): Call<ArticleResult>
}