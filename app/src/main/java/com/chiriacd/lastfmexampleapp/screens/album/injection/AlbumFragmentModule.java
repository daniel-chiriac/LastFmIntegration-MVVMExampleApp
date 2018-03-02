package com.chiriacd.lastfmexampleapp.screens.album.injection;

import com.chiriacd.lastfmexampleapp.screens.album.AlbumViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class AlbumFragmentModule {

    @Provides AlbumViewModel providesAlbumViewModel () {
        return new AlbumViewModel();
    }
}
