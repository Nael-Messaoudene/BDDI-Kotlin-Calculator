package repositories

import android.util.Log
import model.Article
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import services.ArticleService
import java.lang.Exception

class ArticleRepository  {
    private val service: ArticleService

    init {

        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org")
        }.addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(): List<Article> {
        try {
            val response = service.list().execute()
            return response.body()?.articles ?: emptyList()
        }
        catch (e:Exception){
            e.printStackTrace()
            Log.e("ERREUR", e.toString())
            return emptyList()
        }
    }
}