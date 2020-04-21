package com.gmail.nmessaoudene.newsapp
import adapters.CategoryAdapter
import adapters.OnItemClickListener
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.Category

class CategoryList: Fragment(), OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var articleAdapter: ArrayAdapter<String>
    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        bindRecyclerView()
    }

    override fun onItemClicked(category: Category){
        Toast.makeText(context,"User name ${category.title}\n description: ${category.description}", Toast.LENGTH_LONG)
            .show()
        Log.i("Category", category.title)
    }

    private fun bindRecyclerView() {
        //créer une liste d'articles
        var categories = listOf<Category>(
            Category(
                title = "Politique",
                description = "C'est notre projet !",
                image = "https://geo.img.pmdstatic.net/fit/https.3A.2F.2Fwww.2Eneonmag.2Efr.2Fcontent.2Fuploads.2F2017.2F02.2Fmacron-2.2Ejpg/1162x554/quality/80/background-color/ffffff/background-alpha/100/macron.jpg"
            ),
            Category(
                title = "Economie",
                description = "Business is Business",
                image = "https://www.forbes.fr/wp-content/uploads/2019/10/adobestock_188260148-740x370.jpeg"
            ),
            Category(
                title = "Education",
                description = "Ecole",
                image = "https://resize-europe1.lanmedia.fr/r/622,311,forcex,center-middle/img/var/europe1/storage/images/europe1/sante/le-retour-des-enfants-a-lecole-des-le-11-mai-les-parents-ne-doivent-pas-sinquieter-3962408/54723591-1-fre-FR/Le-retour-des-enfants-a-l-ecole-des-le-11-mai-Les-parents-ne-doivent-pas-s-inquieter.jpg"
            ),
            Category(
                title = "Pandémie",
                description = "On va tous mourir",
                image = "https://trustmyscience.com/wp-content/uploads/2020/03/coronavirus-pandemie-750x400.jpeg"
            ),
            Category(
                title = "Sciences",
                description = "scientifique",
                image = "https://img.aws.la-croix.com/2016/07/11/1200775227/Comment-assurer-integrite-scientifique-dans-monde-recherche_0_1400_933.jpg"
            ),
            Category(
                title = "Ecologies",
                description = "Vive la planète !",
                image = "https://www.biocologie.com/wp-content/uploads/2019/07/Ecologie-les-principes-fondamentaux.jpeg"
            )
        )
        //créer une instance de l'adapteur
        val adapterRecycler = CategoryAdapter(categories, this)
        //définir l'orientation des élements (vertical)
        recyclerView.layoutManager =
            LinearLayoutManager(context)
        //associer l'adapter à la recyclerview
        recyclerView.adapter = adapterRecycler
    }


}