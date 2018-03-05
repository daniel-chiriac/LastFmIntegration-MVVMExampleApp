package com.chiriacd.lastfmexampleapp.screens.pager.track;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.chiriacd.lastfmexampleapp.BR;
import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.databinding.TrackFragmentBinding;
import com.chiriacd.lastfmexampleapp.screens.pager.base.BaseFragment;
import com.chiriacd.lastfmexampleapp.screens.pager.track.adapter.TrackAdapter;
import com.chiriacd.lastfmexampleapp.screens.pager.track.adapter.TrackItemViewModel;
import com.chiriacd.lastfmexampleapp.utils.NavigationUtils;
import com.chiriacd.lastfmexampleapp.utils.qualifier.TrackVM;

import java.util.List;

import javax.inject.Inject;


public class TrackFragment extends BaseFragment<TrackFragmentBinding, TrackFragmentViewModel> {
    @Inject @TrackVM ViewModelProvider.Factory vmFactory;
    @Inject TrackAdapter trackAdapter;


    @Override
    public int getBindingVariable() {
        return BR.tracksVM;
    }

    @Override
    public int getLayoutId() {
        return R.layout.track_fragment;
    }

    @Override
    public TrackFragmentViewModel getViewModel() {
        return ViewModelProviders.of(this, vmFactory).get(TrackFragmentViewModel.class);
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
        getViewDataBinding().recyclerView.setAdapter(trackAdapter);
    }

    private void subscribeToLiveData() {
        TrackFragmentViewModel viewModel = getViewModel();
        viewModel.getTracksLiveData().observe(this, this::onTracksChanged);
        viewModel.getClickedUrl().observe(this, this::onTrackClicked);

    }

    private void onTrackClicked(String url) {
        NavigationUtils.openWebBrowser(getContext(), url);
    }

    private void onTracksChanged(List<TrackItemViewModel> tracks) {
        getViewModel().setTracks(tracks);
    }
}
