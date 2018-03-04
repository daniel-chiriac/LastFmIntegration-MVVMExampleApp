package com.chiriacd.lastfmexampleapp.screens;


import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.FragmentManager;

import com.chiriacd.lastfmexampleapp.ViewModelProviderFactory;
import com.chiriacd.lastfmexampleapp.screens.pager.MyFragmentPagerAdapter;
import com.chiriacd.lastfmexampleapp.screens.qualifier.MasterVM;

import dagger.Module;
import dagger.Provides;
@Module
public class MasterActivityModule {

    @Provides MasterViewModel providesAlbumViewModel () {
        return new MasterViewModel();
    }

    @Provides FragmentManager providesSupportFragmentManager(MasterActivity masterActivity) {
        return masterActivity.getSupportFragmentManager();
    }

    @Provides MyFragmentPagerAdapter providesMyFragmentPagerAdapter (FragmentManager fragmentManager) {
        return new MyFragmentPagerAdapter(fragmentManager);
    }

    @Provides @MasterVM
    ViewModelProvider.Factory provideAlbumFragmentViewModelProviderFactory(MasterViewModel masterViewModel) {
        return new ViewModelProviderFactory(masterViewModel);
    }
}
