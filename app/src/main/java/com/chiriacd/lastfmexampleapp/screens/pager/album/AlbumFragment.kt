package com.chiriacd.lastfmexampleapp.screens.pager.album

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chiriacd.lastfmexampleapp.BR
import com.chiriacd.lastfmexampleapp.R
import com.chiriacd.lastfmexampleapp.databinding.AlbumFragmentBinding
import com.chiriacd.lastfmexampleapp.screens.BaseFragment
import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumsAdapter
import javax.inject.Inject
@JvmSuppressWildcards
class AlbumFragment : BaseFragment<AlbumFragmentBinding, AlbumFragmentViewModel>() {

    @Inject lateinit var vmFactory:  ViewModelProvider.Factory
    @Inject lateinit var albumsAdapter: AlbumsAdapter

    lateinit var albumFragmentViewModel: AlbumFragmentViewModel

    companion object {
        fun newInstance(): AlbumFragment {
            return AlbumFragment()
        }
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): AlbumFragmentViewModel {
        albumFragmentViewModel = ViewModelProviders.of(activity, vmFactory).get(AlbumFragmentViewModel::class.java)
        return albumFragmentViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.album_fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        albumFragmentViewModel.albumsLiveData.observe(this, Observer { a -> albumFragmentViewModel.setAlbums(a) })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        viewDataBinding.recyclerView.adapter = albumsAdapter
    }
}