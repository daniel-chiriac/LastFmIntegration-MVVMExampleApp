package com.chiriacd.lastfmexampleapp.injection.builder;

import com.chiriacd.lastfmexampleapp.screens.MasterActivityModule;
import com.chiriacd.lastfmexampleapp.screens.pager.album.injection.AlbumFragmentProvider;
import com.chiriacd.lastfmexampleapp.screens.MasterActivity;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.injection.ArtistFragmentProvider;
import com.chiriacd.lastfmexampleapp.screens.pager.track.injection.TrackFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MasterActivityModule.class,
            AlbumFragmentProvider.class,
            ArtistFragmentProvider.class,
            TrackFragmentProvider.class})
    abstract MasterActivity bindMasterActivity();
}
