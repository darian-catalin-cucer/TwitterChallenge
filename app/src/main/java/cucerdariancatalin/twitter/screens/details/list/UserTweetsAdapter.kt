package cucerdariancatalin.twitter.screens.details.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cucerdariancatalin.twitter.R
import cucerdariancatalin.twitter.core.repository.models.Tweet

class UserTweetsAdapter: RecyclerView.Adapter<UserTweetsViewHolder>(), UserTweetsCallback {

    private val items = mutableListOf<Tweet>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserTweetsViewHolder =
        UserTweetsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.simple_item, parent, false))

    override fun onBindViewHolder(holder: UserTweetsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = items.size

    override fun setItems(list: MutableList<Tweet>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): Tweet = items[position]
}