package cucerdariancatalin.twitter.screens.details

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.load
import coil.transform.CircleCropTransformation
import cucerdariancatalin.twitter.R
import cucerdariancatalin.twitter.core.networking.error.ErrorCallback
import cucerdariancatalin.twitter.core.repository.Repository
import cucerdariancatalin.twitter.screens.details.list.UserTweetsAdapter
import kotlinx.coroutines.launch

class UserDetailsViewModel(val repository: Repository): ViewModel() {

    val adapter = UserTweetsAdapter()
    val errorText = MutableLiveData<String>()

    fun loadProfilePicture(imageView: ImageView) {
        imageView.load(repository.getSelectedUser().profilePicture) {
            crossfade(true)
            placeholder(R.mipmap.ic_launcher)
            transformations(CircleCropTransformation())
        }
    }

    fun getUsername(): String = repository.getSelectedUser().username
    fun loadTweets() {
        viewModelScope.launch {
            repository.getUserTweets(adapter, object : ErrorCallback {
                override fun onError(error: String) {
                    errorText.postValue(error)
                }
            })
        }
    }
}