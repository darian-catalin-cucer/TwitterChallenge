package cucerdariancatalin.twitter.screens.search.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cucerdariancatalin.twitter.R
import cucerdariancatalin.twitter.core.repository.models.TwitterUser

class TwitterUsersAdapter: RecyclerView.Adapter<TwitterUsersViewHolder>(), TwitterUsersCallback {

    private lateinit var clickListener: View.OnClickListener
    private lateinit var listener: SelectItem

    private val items = mutableListOf<TwitterUser>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwitterUsersViewHolder =
        TwitterUsersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.twitter_user_item, parent, false))

    override fun onBindViewHolder(holder: TwitterUsersViewHolder, position: Int) {
        holder.bind(getItem(position), listener, clickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun setItems(list: MutableList<TwitterUser>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): TwitterUser = items[position]

    fun addSelectItemListener(listener: SelectItem) {
        this.listener = listener
    }

    fun addSelectItemClickListener(listener: View.OnClickListener) {
        this.clickListener = listener
    }

    interface SelectItem{
        fun select(item: TwitterUser)
    }
}