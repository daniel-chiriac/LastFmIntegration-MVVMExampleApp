package com.chiriacd.lastfmexampleapp.screens.pager.album.injection;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;

import com.chiriacd.lastfmexampleapp.ViewModelProviderFactory;
import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.screens.pager.album.AlbumFragmentViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumItemViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumsAdapter;
import com.chiriacd.lastfmexampleapp.utils.qualifier.AlbumVM;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class AlbumFragmentModule {

    @Provides AlbumFragmentViewModel providesAlbumViewModel(LastFmService lastFmService, SchedulersProvider scheduler,
                                                  MutableLiveData<List<AlbumItemViewModel>> liveData) {
        return new AlbumFragmentViewModel(lastFmService, scheduler, liveData);
    }

    @Provides
    MutableLiveData<List<AlbumItemViewModel>> provideAlbumsLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    public AlbumsAdapter providesAlbumsAdapter() {
        return new AlbumsAdapter();
    }


    //todo Should use a single Factory of view models instead of factory for each
    @Provides @AlbumVM ViewModelProvider.Factory provideAlbumFragmentViewModelProviderFactory(AlbumFragmentViewModel afvm) {
        return new ViewModelProviderFactory(afvm);
    }

}
