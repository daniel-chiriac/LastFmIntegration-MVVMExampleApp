package com.chiriacd.lastfmexampleapp.screens.pager.artist.injection;

import android.arch.lifecycle.ViewModelProvider;

import com.chiriacd.lastfmexampleapp.ViewModelProviderFactory;
import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.ArtistFragmentViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter.ArtistsAdapter;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;
import com.chiriacd.lastfmexampleapp.utils.qualifier.ArtistVM;

import dagger.Module;
import dagger.Provides;

@Module
public class ArtistFragmentModule {

    @Provides
    public ArtistFragmentViewModel providesArtistFragmentViewModel(LastFmService lastFmService,
                                                            SchedulersProvider scheduler) {
        return new ArtistFragmentViewModel(lastFmService, scheduler);
    }

    @Provides
    public ArtistsAdapter providesArtistsAdapter() {
        return new ArtistsAdapter();
    }

    //todo Should use a single Factory of view models instead of factory for each
    @Provides @ArtistVM
    ViewModelProvider.Factory provideArtistFragmentViewModelProviderFactory(ArtistFragmentViewModel afvm) {
        return new ViewModelProviderFactory(afvm);
    }
}
