package com.chiriacd.lastfmexampleapp.screens.album.injection;

import com.chiriacd.lastfmexampleapp.screens.album.AlbumFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AlbumFragmentProvider {

    @ContributesAndroidInjector(modules = AlbumFragmentModule.class)
    abstract AlbumFragment provideAlbumFragment();
}
