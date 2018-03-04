package com.chiriacd.lastfmexampleapp.screens.pager.track;

import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.screens.pager.base.BaseFragmentViewModel;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import javax.inject.Inject;

public class TrackFragmentViewModel extends BaseFragmentViewModel {

    @Inject
    public TrackFragmentViewModel(LastFmService dataManager, SchedulersProvider schedulersProvider) {
        super(dataManager, schedulersProvider);
    }

    @Override
    public void search(String s) {

    }
}
