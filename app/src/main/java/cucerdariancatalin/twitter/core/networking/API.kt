package cucerdariancatalin.twitter.core.networking

interface API {

    suspend fun getUser(query: String, callback: APICallbackInterface)

    suspend fun getUserTweets(userId: String, callback: APICallbackInterface)
}