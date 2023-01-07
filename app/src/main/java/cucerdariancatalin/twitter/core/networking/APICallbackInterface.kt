package cucerdariancatalin.twitter.core.networking

import org.json.JSONObject

interface APICallbackInterface {
    fun onSuccess(jsonObject: JSONObject)
    fun onError(error: String)
}