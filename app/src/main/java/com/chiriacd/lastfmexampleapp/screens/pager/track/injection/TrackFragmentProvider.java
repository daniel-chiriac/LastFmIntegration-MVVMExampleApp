package com.chiriacd.lastfmexampleapp.screens.pager.track.injection;

import com.chiriacd.lastfmexampleapp.screens.pager.track.TrackFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TrackFragmentProvider {

    @ContributesAndroidInjector(modules = TrackFragmentModule.class)
    abstract TrackFragment provideAlbumFragment();
}
