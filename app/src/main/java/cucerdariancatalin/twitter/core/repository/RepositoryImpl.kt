package cucerdariancatalin.twitter.core.repository

import android.util.Log
import cucerdariancatalin.twitter.core.networking.API
import cucerdariancatalin.twitter.core.networking.APICallbackInterface
import cucerdariancatalin.twitter.core.networking.error.ErrorCallback
import cucerdariancatalin.twitter.core.repository.models.Tweet
import cucerdariancatalin.twitter.core.repository.models.TwitterUser
import cucerdariancatalin.twitter.screens.details.list.UserTweetsCallback
import cucerdariancatalin.twitter.screens.search.list.TwitterUsersCallback
import cucerdariancatalin.twitter.utils.Constants
import org.json.JSONObject

class RepositoryImpl(val api: API): Repository {

    private lateinit var selectedUser: TwitterUser
    private val users = arrayListOf<TwitterUser>()
    private val userTweets = arrayListOf<Tweet>()

    override suspend fun getUsers(
        query: String,
        callback: TwitterUsersCallback,
        errorCallback: ErrorCallback
    ) {
        api.getUser(query, object : APICallbackInterface{
            override fun onSuccess(jsonObject: JSONObject) {
                parseUsersResponse(jsonObject)
                callback.setItems(users)
                if (users.size == 0) {
                    errorCallback.onError("No users found!")
                } else {
                    errorCallback.onError("")
                }
            }

            override fun onError(error: String) {
                errorCallback.onError(error)
            }

        })
    }

    private fun parseUsersResponse(jsonObject: JSONObject) {
        users.clear()
        Log.e(javaClass.simpleName, jsonObject.toString())
        val jsonArray = jsonObject.optJSONArray(Constants.DATA)
        jsonArray?.let {
            (0 until it.length()).forEach { i ->
                users.add(TwitterUser(it.optJSONObject(i)))
            }
        }
    }

    override suspend fun getUserTweets(callback: UserTweetsCallback, errorCallback: ErrorCallback) {
        api.getUserTweets(selectedUser.id, object : APICallbackInterface{
            override fun onSuccess(jsonObject: JSONObject) {
                parseUserTweets(jsonObject)
                callback.setItems(userTweets)
                if (userTweets.size == 0) {
                    errorCallback.onError("User didn't tweet.")
                }
            }

            override fun onError(error: String) {
                errorCallback.onError(error)
            }

        })
    }

    private fun parseUserTweets(jsonObject: JSONObject) {
        userTweets.clear()
        Log.e(javaClass.simpleName, jsonObject.toString())
        val jsonArray = jsonObject.optJSONArray(Constants.DATA)
        jsonArray?.let {
            (0 until it.length()).forEach { i ->
                userTweets.add(Tweet(it.optJSONObject(i)))
            }
        }
    }

    override fun setSelectedUser(user: TwitterUser) {
        selectedUser = user
    }

    override fun getSelectedUser(): TwitterUser  = selectedUser
}