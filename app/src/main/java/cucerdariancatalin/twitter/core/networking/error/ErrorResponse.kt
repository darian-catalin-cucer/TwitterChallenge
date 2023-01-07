package cucerdariancatalin.twitter.core.networking.error

import com.google.gson.annotations.SerializedName
import cucerdariancatalin.twitter.utils.Constants

data class ErrorResponse(@SerializedName(Constants.TITLE) val title: String = "",
                         @SerializedName(Constants.DETAIL) val detail: String = "",
                         @SerializedName(Constants.TYPE) val type: String = "") {

    constructor(errorResponse: ErrorResponse): this(errorResponse.title, errorResponse.detail, errorResponse.type)

    override fun toString(): String {
        return title + '\n' + detail
    }
}
