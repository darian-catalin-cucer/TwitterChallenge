package cucerdariancatalin.twitter.core.repository.models

import com.google.gson.annotations.SerializedName
import cucerdariancatalin.twitter.utils.Constants
import org.json.JSONObject

data class Tweet(@SerializedName(Constants.ID) val id: String,
                 @SerializedName(Constants.TEXT) val text: String) {
    constructor(jsonObject: JSONObject): this(
        jsonObject.optString(Constants.ID),
        jsonObject.optString(Constants.TEXT)
    )
}
