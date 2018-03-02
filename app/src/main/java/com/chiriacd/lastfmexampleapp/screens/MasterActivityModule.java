package com.chiriacd.lastfmexampleapp.screens;


import dagger.Module;
import dagger.Provides;

@Module
public class MasterActivityModule {
    @Provides
    MasterViewModel providesAlbumViewModel () {
        return new MasterViewModel();
    }
}
