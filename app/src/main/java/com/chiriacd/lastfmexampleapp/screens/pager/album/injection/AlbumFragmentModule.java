package com.chiriacd.lastfmexampleapp.screens.pager.album.injection;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;

import com.chiriacd.lastfmexampleapp.VMKey;
import com.chiriacd.lastfmexampleapp.ViewModelProviderFactory;
import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.screens.MasterViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.album.AlbumFragmentViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.album.AlbumItemViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumsAdapter;
import com.chiriacd.lastfmexampleapp.screens.qualifier.AlbumVM;
import com.chiriacd.lastfmexampleapp.screens.qualifier.MasterVM;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class AlbumFragmentModule {

    @Provides
    @IntoMap
    @MasterVM
    @VMKey(AlbumFragmentViewModel.class)
    AlbumFragmentViewModel providesAlbumViewModel(LastFmService lastFmService, SchedulersProvider scheduler,
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

}
