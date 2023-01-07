package cucerdariancatalin.twitter.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import cucerdariancatalin.twitter.BR
import org.koin.core.KoinComponent

abstract class BaseFragment<VM: ViewModel, VDB: ViewDataBinding>: Fragment(), KoinComponent {

    protected abstract val viewModel: VM
    protected lateinit var dataBinding: VDB
    protected abstract fun whichLayout(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<VDB>(inflater, whichLayout(), container, false).also {
            dataBinding = it
            it.lifecycleOwner = this
            it.executePendingBindings()
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindVariable(BR.viewModel, viewModel)
    }

    protected fun bindVariable(key: Int, value: Any) {
        dataBinding.setVariable(key, value)
    }
}