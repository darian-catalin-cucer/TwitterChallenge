package cucerdariancatalin.twitter.core.repository

import cucerdariancatalin.twitter.core.networking.error.ErrorCallback
import cucerdariancatalin.twitter.core.repository.models.TwitterUser
import cucerdariancatalin.twitter.screens.details.list.UserTweetsCallback
import cucerdariancatalin.twitter.screens.search.list.TwitterUsersCallback

interface Repository {

    //API calls functions
    suspend fun getUsers(query: String, callback: TwitterUsersCallback, errorCallback: ErrorCallback)
    suspend fun getUserTweets(callback: UserTweetsCallback, errorCallback: ErrorCallback)

    //select user function
    fun setSelectedUser(user: TwitterUser)
    fun getSelectedUser(): TwitterUser
}