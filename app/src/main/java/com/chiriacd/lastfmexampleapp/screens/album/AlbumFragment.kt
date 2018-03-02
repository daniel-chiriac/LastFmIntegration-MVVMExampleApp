package com.chiriacd.lastfmexampleapp.screens.album

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chiriacd.lastfmexampleapp.BR
import com.chiriacd.lastfmexampleapp.R
import com.chiriacd.lastfmexampleapp.databinding.AlbumFragmentBinding
import com.chiriacd.lastfmexampleapp.screens.BaseFragment
import javax.inject.Inject

class AlbumFragment : BaseFragment<AlbumFragmentBinding, AlbumViewModel>() {

    @Inject lateinit var vm: AlbumViewModel

    companion object {
        fun newInstance(): AlbumFragment {
            return AlbumFragment()
        }
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): AlbumViewModel {
        return vm
    }

    override fun getLayoutId(): Int {
        return R.layout.album_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.recyclerView.layoutManager = LinearLayoutManager(context)
    }
}