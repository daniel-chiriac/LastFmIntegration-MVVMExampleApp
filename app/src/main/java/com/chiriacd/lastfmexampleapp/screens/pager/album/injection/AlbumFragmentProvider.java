package com.chiriacd.lastfmexampleapp.screens.pager.album.injection;

import com.chiriacd.lastfmexampleapp.screens.pager.album.AlbumFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AlbumFragmentProvider {

    @ContributesAndroidInjector(modules = AlbumFragmentModule.class)
    abstract AlbumFragment provideAlbumFragment();
}
