package com.chiriacd.lastfmexampleapp.screens.pager.artist;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chiriacd.lastfmexampleapp.BR;
import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.databinding.ArtistFragmentBinding;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter.ArtistItemViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter.ArtistsAdapter;
import com.chiriacd.lastfmexampleapp.screens.pager.base.BaseFragment;
import com.chiriacd.lastfmexampleapp.utils.qualifier.ArtistVM;

import java.util.List;

import javax.inject.Inject;

public class ArtistFragment extends BaseFragment<ArtistFragmentBinding, ArtistFragmentViewModel> {

    @Inject @ArtistVM ViewModelProvider.Factory vmFactory;
    @Inject ArtistsAdapter artistsAdapter;

    @Override
    public int getBindingVariable() {
        return BR.artistVM;
    }

    @Override
    public int getLayoutId() {
        return R.layout.artist_fragment;
    }

    @Override
    public ArtistFragmentViewModel getViewModel() {
        return ViewModelProviders.of(this, vmFactory).get(ArtistFragmentViewModel.class);
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
        getViewDataBinding().recyclerView.setAdapter(artistsAdapter);
    }

    private void subscribeToLiveData() {
        getViewModel().getArtistsLiveData()
                .observe(this, this::onArtistsChanged);
    }

    private void onArtistsChanged(List<ArtistItemViewModel> artists) {
        getViewModel().setArtists(artists);
    }
}
