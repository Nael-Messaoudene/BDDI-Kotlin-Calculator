package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import model.Category
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.annotation.GlideModule
import com.gmail.nmessaoudene.finalapptp.R
@GlideModule

class CategoryAdapter(private val dataset: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Category) {
            val txtTitle = root.findViewById<TextView>(R.id.article_title)
            val txtDesc = root.findViewById<TextView>(R.id.article_description)
            val Image = root.findViewById<ImageView>(R.id.article_image)
            txtTitle.text = item.title
            txtDesc.text = item.description

            Glide.with(root).load(item.image).into(Image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(dataset[position])


    override fun getItemCount(): Int = dataset.size
}