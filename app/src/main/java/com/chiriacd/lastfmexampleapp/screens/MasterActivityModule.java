package com.chiriacd.lastfmexampleapp.screens;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.FragmentManager;

import com.chiriacd.lastfmexampleapp.VMKey;
import com.chiriacd.lastfmexampleapp.ViewModelProviderFactory;
import com.chiriacd.lastfmexampleapp.screens.pager.MyFragmentPagerAdapter;
import com.chiriacd.lastfmexampleapp.screens.qualifier.MasterVM;

import java.util.Map;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;

@Module
public class MasterActivityModule {

    @Provides
    @IntoMap
    @MasterVM
    @VMKey(MasterViewModel.class)
    MasterViewModel providesAlbumViewModel () {
        return new MasterViewModel();
    }

    @Provides FragmentManager providesSupportFragmentManager(MasterActivity masterActivity) {
        return masterActivity.getSupportFragmentManager();
    }

    @Provides MyFragmentPagerAdapter providesMyFragmentPagerAdapter (FragmentManager fragmentManager) {
        return new MyFragmentPagerAdapter(fragmentManager);
    }

}
