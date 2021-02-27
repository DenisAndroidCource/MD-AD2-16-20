package by.it.academy.diexample.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.it.academy.diexample.databinding.ItemNewsBinding
import com.bumptech.glide.Glide

class NewsListItemsAdapter(
    private val onNewsClickEvent: (String) -> Unit
) : RecyclerView.Adapter<NewsListItemsAdapter.NewsListItemViewHolder>() {

    var items: List<NewsItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsListItemViewHolder(
            itemNewsBinding = ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onNewsClickEvent = onNewsClickEvent
        )

    override fun onBindViewHolder(holder: NewsListItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class NewsListItemViewHolder(
        private val itemNewsBinding: ItemNewsBinding,
        private val onNewsClickEvent: (String) -> Unit
    ) : RecyclerView.ViewHolder(itemNewsBinding.root) {
        fun bind(item: NewsItem) {
            with(itemNewsBinding) {
                textTitle.text = item.title
                textDescription.text = item.description
                root.setOnClickListener { onNewsClickEvent(item.url) }

                Glide.with(itemNewsBinding.root.context)
                    .load(item.urlToImage)
                    .placeholder(item.errorImageId)
                    .centerCrop()
                    .into(itemNewsBinding.newsPreview)
            }
        }
    }
}