package com.chiriacd.lastfmexampleapp.screens.album;


import com.chiriacd.lastfmexampleapp.data.DataManager;
import com.chiriacd.lastfmexampleapp.screens.BaseViewModel;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import javax.inject.Inject;

public class AlbumViewModel extends BaseViewModel {

    @Inject
    public AlbumViewModel(DataManager dataManager, SchedulersProvider schedulersProvider) {
        super(dataManager, schedulersProvider);
    }


}
