package cucerdariancatalin.twitter.screens.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import cucerdariancatalin.twitter.R
import cucerdariancatalin.twitter.core.base.BaseFragment
import cucerdariancatalin.twitter.databinding.FragmentUserSearchBinding
import kotlinx.android.synthetic.main.fragment_user_search.*
import org.koin.core.inject

class UserSearchFragment: BaseFragment<UserSearchViewModel, FragmentUserSearchBinding>() {

    override val viewModel: UserSearchViewModel by inject()

    override fun whichLayout(): Int = R.layout.fragment_user_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username_input_edit_text.doOnTextChanged { text, start, before, count ->
            viewModel.onTextChanged(text.toString())
        }
    }
}