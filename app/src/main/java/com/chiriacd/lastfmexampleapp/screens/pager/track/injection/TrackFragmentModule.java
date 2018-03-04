package com.chiriacd.lastfmexampleapp.screens.pager.track.injection;

import android.arch.lifecycle.ViewModelProvider;

import com.chiriacd.lastfmexampleapp.ViewModelProviderFactory;
import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.ArtistFragmentViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter.ArtistsAdapter;
import com.chiriacd.lastfmexampleapp.screens.pager.track.TrackFragmentViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.track.adapter.TrackAdapter;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;
import com.chiriacd.lastfmexampleapp.utils.qualifier.ArtistVM;
import com.chiriacd.lastfmexampleapp.utils.qualifier.TrackVM;

import dagger.Module;
import dagger.Provides;

@Module
public class TrackFragmentModule {

    @Provides
    public TrackFragmentViewModel providesTrackFragmentViewModel(LastFmService lastFmService,
                                                                  SchedulersProvider scheduler) {
        return new TrackFragmentViewModel(lastFmService, scheduler);
    }

    @Provides
    public TrackAdapter providesTracksAdapter() {
        return new TrackAdapter();
    }

    //todo Should use a single Factory of view models instead of factory for each
    @Provides @TrackVM
    ViewModelProvider.Factory provideArtistFragmentViewModelProviderFactory(TrackFragmentViewModel tfvm) {
        return new ViewModelProviderFactory(tfvm);
    }
}
