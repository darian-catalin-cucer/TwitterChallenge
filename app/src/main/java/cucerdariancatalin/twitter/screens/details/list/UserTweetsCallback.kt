package cucerdariancatalin.twitter.screens.details.list

import cucerdariancatalin.twitter.core.repository.models.Tweet
import cucerdariancatalin.twitter.core.repository.models.TwitterUser

interface UserTweetsCallback {
    fun setItems(list: MutableList<Tweet>)
}
