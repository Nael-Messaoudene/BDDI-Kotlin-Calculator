package services

import model.Article
import model.ArticleResult
import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {
    @GET("/v2/top-headlines?country=us&category=business&apiKey=e42d4fccee0b46b8a027aa25a4502eb5")
    fun list(): Call<ArticleResult>
}