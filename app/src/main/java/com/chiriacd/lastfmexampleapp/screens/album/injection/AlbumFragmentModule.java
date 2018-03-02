package com.chiriacd.lastfmexampleapp.screens.album.injection;

import android.arch.lifecycle.MutableLiveData;

import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.screens.album.AlbumFragmentViewModel;
import com.chiriacd.lastfmexampleapp.screens.album.AlbumItemViewModel;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class AlbumFragmentModule {

    @Provides
    AlbumFragmentViewModel providesAlbumViewModel(LastFmService lastFmService, SchedulersProvider scheduler,
                                                  MutableLiveData<List<AlbumItemViewModel>> liveData) {
        return new AlbumFragmentViewModel(lastFmService, scheduler, liveData);
    }

    @Provides
    MutableLiveData<List<AlbumItemViewModel>> provideAlbumsLiveData() {
        return new MutableLiveData<>();
    }
}
