package com.chiriacd.lastfmexampleapp.screens.pager.album;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.chiriacd.lastfmexampleapp.BR;
import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.databinding.AlbumFragmentBinding;
import com.chiriacd.lastfmexampleapp.screens.BaseFragment;
import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumsAdapter;
import com.chiriacd.lastfmexampleapp.screens.qualifier.AlbumVM;

import java.util.List;

import javax.inject.Inject;


public class AlbumFragment extends BaseFragment<AlbumFragmentBinding, AlbumFragmentViewModel> {

    @Inject @AlbumVM ViewModelProvider.Factory vmFactory;
    @Inject AlbumsAdapter albumsAdapter;

    public static AlbumFragment newInstance() {
        return new AlbumFragment();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.album_fragment;
    }

    @Override
    public AlbumFragmentViewModel getViewModel() {
        return ViewModelProviders.of(this, vmFactory).get(AlbumFragmentViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeToLiveData();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getViewDataBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getViewDataBinding().recyclerView.setAdapter(albumsAdapter);
        Log.i("hashCheck", "AlbumFragment: " + hashCode());
    }

    private void subscribeToLiveData() {
        getViewModel().getAlbumsLiveData()
                .observe(this, this::onAlbumsChanged);
    }

    private void onAlbumsChanged(List<AlbumItemViewModel> albums) {
        getViewModel().setAlbums(albums);
    }
}
