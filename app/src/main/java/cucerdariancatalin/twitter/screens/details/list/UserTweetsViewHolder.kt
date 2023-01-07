package cucerdariancatalin.twitter.screens.details.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cucerdariancatalin.twitter.core.repository.models.Tweet
import kotlinx.android.synthetic.main.simple_item.view.*

class UserTweetsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(item: Tweet) {
        itemView.text.text = item.text
    }
}
