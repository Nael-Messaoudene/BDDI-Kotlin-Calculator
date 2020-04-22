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
            val Title = root.findViewById<TextView>(R.id.article_title)
            val Author = root.findViewById<TextView>(R.id.article_author)
            val articleImage = root.findViewById<ImageView>(R.id.article_image)
            Title.text = "${item.title}"
            Author.text = item.author

            Log.d("itemUrl", item.url)
            Glide.with(root)  //2
                .load(item.urlToImage)
                .placeholder(R.drawable.ok)
                .centerCrop()
                .into(articleImage)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.article, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }
    override fun getItemCount(): Int = dataset.size
}