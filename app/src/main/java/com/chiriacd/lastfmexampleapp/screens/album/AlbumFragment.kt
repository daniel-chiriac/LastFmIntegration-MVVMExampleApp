package com.chiriacd.lastfmexampleapp.screens.album

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chiriacd.lastfmexampleapp.BR
import com.chiriacd.lastfmexampleapp.R
import com.chiriacd.lastfmexampleapp.databinding.AlbumFragmentBinding
import com.chiriacd.lastfmexampleapp.screens.BaseFragment
import com.chiriacd.lastfmexampleapp.screens.album.adapter.AlbumsAdapter
import javax.inject.Inject

class AlbumFragment : BaseFragment<AlbumFragmentBinding, AlbumFragmentViewModel>() {

    @Inject lateinit var vm: AlbumFragmentViewModel

    companion object {
        fun newInstance(): AlbumFragment {
            return AlbumFragment()
        }
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): AlbumFragmentViewModel {
        return vm
    }

    override fun getLayoutId(): Int {
        return R.layout.album_fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.albumsLiveData.observe(this, Observer { a -> viewModel.setAlbums(a) })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        viewDataBinding.recyclerView.adapter = AlbumsAdapter()
        viewModel.updateAlbums("Metallica")
    }
}