package cucerdariancatalin.twitter.screens.search.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cucerdariancatalin.twitter.R
import cucerdariancatalin.twitter.core.repository.models.TwitterUser
import kotlinx.android.synthetic.main.twitter_user_item.view.*

class TwitterUsersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(user: TwitterUser, listener: TwitterUsersAdapter.SelectItem, clickListener: View.OnClickListener) {
        itemView.username.text = itemView.context.resources.getString(R.string.twitter_user, user.name, user.id, user.username)
        itemView.setOnClickListener {
            listener.select(user)
            clickListener.onClick(it)
        }
    }
}
