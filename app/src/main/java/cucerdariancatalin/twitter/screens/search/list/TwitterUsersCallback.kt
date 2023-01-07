package cucerdariancatalin.twitter.screens.search.list

import cucerdariancatalin.twitter.core.repository.models.TwitterUser

interface TwitterUsersCallback {
    fun setItems(list: MutableList<TwitterUser>)
}
