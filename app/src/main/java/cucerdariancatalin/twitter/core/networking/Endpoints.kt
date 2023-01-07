package cucerdariancatalin.twitter.core.networking

object Endpoints {

    const val BASE_URL = "https://api.twitter.com/2/"

    //User lookup API reference https://developer.twitter.com/en/docs/twitter-api/users/lookup/api-reference
    const val USERS = "users/"
    const val BY_USERNAMES = "by?usernames="
    const val WITH_PROFILE_PICTURES = "&user.fields=profile_image_url"

    //Tweets lookup API reference https://developer.twitter.com/en/docs/twitter-api/tweets/timelines/api-reference
    const val TWEETS = "/tweets"
}