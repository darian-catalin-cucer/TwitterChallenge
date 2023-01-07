package cucerdariancatalin.twitter.core.networking.error

import com.google.gson.annotations.SerializedName
import cucerdariancatalin.twitter.utils.Constants

data class Error(@SerializedName(Constants.PARAMETERS) val parameters: String,
                 @SerializedName(Constants.MESSAGE) val message: String)