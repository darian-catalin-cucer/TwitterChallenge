package cucerdariancatalin.twitter.core.networking

import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import cucerdariancatalin.twitter.utils.Constants
import org.json.JSONObject

class TwitterUserSearchJsonObjectRequest(
    url: String,
    jsonObject: JSONObject?,
    listener: Response.Listener<JSONObject>,
    errorListener: Response.ErrorListener
) : JsonObjectRequest(url, jsonObject, listener, errorListener) {
    override fun getHeaders(): MutableMap<String, String> = HashMap<String, String>().also {
        it["Authorization"] = "Bearer " + Constants.BEARER_TOKEN
    }
}