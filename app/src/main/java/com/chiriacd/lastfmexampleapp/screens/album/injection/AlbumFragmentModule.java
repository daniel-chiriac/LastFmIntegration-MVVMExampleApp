package com.chiriacd.lastfmexampleapp.screens.album.injection;

import com.chiriacd.lastfmexampleapp.data.DataManager;
import com.chiriacd.lastfmexampleapp.screens.album.AlbumViewModel;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class AlbumFragmentModule {

    @Provides AlbumViewModel providesAlbumViewModel (DataManager dataManager, SchedulersProvider scheduler) {
        return new AlbumViewModel(dataManager, scheduler);
    }
}
