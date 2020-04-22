package adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import model.Article
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.gmail.nmessaoudene.newsapp.R
import model.Category

@GlideModule

class CategoryAdapter(private val dataset: List<Category>, val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Category, clickListener: OnItemClickListener) {
            val Title = root.findViewById<TextView>(R.id.category_name)
            val Description = root.findViewById<TextView>(R.id.category_description)
            val viewImage = root.findViewById<ImageView>(R.id.category_image)
            Title.text = item.name
            Description.text = item.description

            root.setOnClickListener {
                clickListener.onItemClicked(item)
            }

            Log.d("itemUrl", item.url)
            Glide.with(root)  //2
                .load(item.url)
                .centerCrop()
                .into(viewImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position], itemClickListener)
    }


    override fun getItemCount(): Int = dataset.size
}

interface OnItemClickListener{
    fun onItemClicked(category: Category)
}