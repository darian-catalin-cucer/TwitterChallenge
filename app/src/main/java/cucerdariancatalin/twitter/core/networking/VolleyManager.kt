package cucerdariancatalin.twitter.core.networking

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import cucerdariancatalin.twitter.core.networking.error.ErrorResponse

object VolleyManager: API {

    private lateinit var queue: RequestQueue

    fun initialise(context: Context) {
        queue = Volley.newRequestQueue(context)
    }

    private fun get(url: String, callback: APICallbackInterface) {
        Log.e(javaClass.simpleName, "Volley request for $url")
        queue.add(TwitterUserSearchJsonObjectRequest(url, null,
            {
                callback.onSuccess(it)
            },
            {
                var error = ""

                try {
                    error = parseError(it)
                } catch (exception: JsonSyntaxException) {
                    error = "Error while getting information from server."
                }
                callback.onError(error)
            }
        ))
    }

    private fun parseError(it: VolleyError): String = ErrorResponse(Gson().fromJson(String(it.networkResponse.data), ErrorResponse::class.java)).toString()

    override suspend fun getUser(query: String, callback: APICallbackInterface) {
        get(Endpoints.BASE_URL + Endpoints.USERS + Endpoints.BY_USERNAMES + query + Endpoints.WITH_PROFILE_PICTURES, callback)
    }

    override suspend fun getUserTweets(userId: String, callback: APICallbackInterface) {
        get(Endpoints.BASE_URL + Endpoints.USERS + userId + Endpoints.TWEETS, callback)
    }
}