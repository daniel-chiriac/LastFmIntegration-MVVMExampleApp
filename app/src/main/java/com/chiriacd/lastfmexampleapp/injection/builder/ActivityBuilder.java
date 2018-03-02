package com.chiriacd.lastfmexampleapp.injection.builder;

import com.chiriacd.lastfmexampleapp.screens.MasterActivityModule;
import com.chiriacd.lastfmexampleapp.screens.album.injection.AlbumFragmentProvider;
import com.chiriacd.lastfmexampleapp.screens.MasterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MasterActivityModule.class, AlbumFragmentProvider.class})
    abstract MasterActivity bindMasterActivity();
}
