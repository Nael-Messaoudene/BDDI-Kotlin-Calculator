package adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.nmessaoudene.newsapp.R
import model.Article


class ArticleAdapter(private val dataset: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val txtTitle = root.findViewById<TextView>(R.id.art_title)
            val txtDesc = root.findViewById<TextView>(R.id.art_desc)
            val Image = root.findViewById<ImageView>(R.id.art_img)
            txtTitle.text = item.title
            txtDesc.text = item.description

            Log.d("itemUrl", item.url)
            Glide.with(root)  //2
                .load(item.url)
                .centerCrop()
                .into(Image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_list, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size
}