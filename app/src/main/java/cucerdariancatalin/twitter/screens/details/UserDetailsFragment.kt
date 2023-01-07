package cucerdariancatalin.twitter.screens.details

import android.os.Bundle
import android.view.View
import cucerdariancatalin.twitter.R
import cucerdariancatalin.twitter.core.base.BaseFragment
import cucerdariancatalin.twitter.databinding.FragmentUserDetailsBinding
import kotlinx.android.synthetic.main.fragment_user_details.*
import org.koin.core.inject

class UserDetailsFragment: BaseFragment<UserDetailsViewModel, FragmentUserDetailsBinding>() {

    override val viewModel: UserDetailsViewModel by inject()

    override fun whichLayout(): Int = R.layout.fragment_user_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadProfilePicture(profile_picture)
        viewModel.loadTweets()
    }
}