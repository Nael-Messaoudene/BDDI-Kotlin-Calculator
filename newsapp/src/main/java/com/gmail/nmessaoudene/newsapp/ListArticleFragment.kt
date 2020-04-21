package com.gmail.nmessaoudene.newsapp
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import model.Article
import repositories.ArticleRepository

class ListArticleFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var articleAdapter: ArrayAdapter<String>
    private lateinit var spinner: Spinner

    private val repository = ArticleRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_list, container, false)
    }

 /*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {

        }
        recyclerView = view.findViewById(R.id.recyclerView)
        bindRecyclerView()

    }*/


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycleScope.launch {
            getData()
        }
    }
    //S'execute dans un thread secondaire
    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list()
            bindData(result)
        }
    }
    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main) {
            //afficher les données dans le recycler

            Log.d("Articles", result.toString())
        }
    }


/*
     private fun bindRecyclerView() {
        //créer une liste d'articles
        val articles = listOf<Article>(
            Article(
                title = "Politique",
                description = "C'est notre projet !",
                urlToImage = "https://geo.img.pmdstatic.net/fit/https.3A.2F.2Fwww.2Eneonmag.2Efr.2Fcontent.2Fuploads.2F2017.2F02.2Fmacron-2.2Ejpg/1162x554/quality/80/background-color/ffffff/background-alpha/100/macron.jpg",
                author = "zebi",
                source = Source("1","okokook"),
                url = "okokokokokkokokokok"
            ),
            Article(
                title = "Economie",
                description = "Business is Business",
                urlToImage = "https://www.forbes.fr/wp-content/uploads/2019/10/adobestock_188260148-740x370.jpeg",
                author = "zebi",
                source = Source("1","okokook"),
                url = "okokokokokkokokokok"
            ),
            Article(
                title = "Education",
                description = "Ecole",
                urlToImage = "https://resize-europe1.lanmedia.fr/r/622,311,forcex,center-middle/img/var/europe1/storage/images/europe1/sante/le-retour-des-enfants-a-lecole-des-le-11-mai-les-parents-ne-doivent-pas-sinquieter-3962408/54723591-1-fre-FR/Le-retour-des-enfants-a-l-ecole-des-le-11-mai-Les-parents-ne-doivent-pas-s-inquieter.jpg",
                author = "zebi",
                source = Source("1","okokook"),
                url = "okokokokokkokokokok"
            ),
            Article(
                title = "Pandémie",
                description = "On va tous mourir",
                urlToImage = "https://trustmyscience.com/wp-content/uploads/2020/03/coronavirus-pandemie-750x400.jpeg",
                author = "zebi",
                source = Source("1","okokook"),
                url = "okokokokokkokokokok"

            ),
            Article(
                title = "Sciences",
                description = "scientifique",
                urlToImage = "https://img.aws.la-croix.com/2016/07/11/1200775227/Comment-assurer-integrite-scientifique-dans-monde-recherche_0_1400_933.jpg",
                author = "zebi",
                source = Source("1","okokook"),
                url = "okokokokokkokokokok"
            ),
            Article(
                title = "Ecologies",
                description = "Vive la planète !",
                urlToImage = "https://www.biocologie.com/wp-content/uploads/2019/07/Ecologie-les-principes-fondamentaux.jpeg",
                author = "zebi",
                source = Source("1","okokook"),
                url = "okokokokokkokokokok"
            )
        )
        //créer une instance de l'adapteur
        val adapterRecycler = ArticleAdapter(articles)
        //définir l'orientation des élements (vertical)
        recyclerView.layoutManager =
            LinearLayoutManager(context)
        //associer l'adapter à la recyclerview
        recyclerView.adapter = adapterRecycler
    }
*/

}