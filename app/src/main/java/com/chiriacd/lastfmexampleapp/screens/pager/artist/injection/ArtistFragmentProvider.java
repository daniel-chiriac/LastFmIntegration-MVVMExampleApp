package com.chiriacd.lastfmexampleapp.screens.pager.artist.injection;


import com.chiriacd.lastfmexampleapp.screens.pager.artist.ArtistFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ArtistFragmentProvider {

    @ContributesAndroidInjector(modules = ArtistFragmentModule.class)
    abstract ArtistFragment provideAlbumFragment();
}
