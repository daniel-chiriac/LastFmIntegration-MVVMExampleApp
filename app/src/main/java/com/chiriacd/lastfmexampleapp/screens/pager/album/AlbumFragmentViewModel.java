package com.chiriacd.lastfmexampleapp.screens.pager.album;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.api.results.AlbumResult;
import com.chiriacd.lastfmexampleapp.api.results.matches.AlbumMatches;
import com.chiriacd.lastfmexampleapp.screens.BaseFragmentViewModel;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import java.util.List;

import javax.inject.Inject;

public class AlbumFragmentViewModel extends BaseFragmentViewModel {

    private final MutableLiveData<List<AlbumItemViewModel>> albumsLiveData;

    private final ObservableList<AlbumItemViewModel> albums;

    @Inject
    public AlbumFragmentViewModel(LastFmService lastFmService,
                                  SchedulersProvider schedulersProvider,
                                  MutableLiveData<List<AlbumItemViewModel>> liveData) {
        super(lastFmService, schedulersProvider);
        albumsLiveData = liveData;
        albums = new ObservableArrayList<>();
    }

    public ObservableList<AlbumItemViewModel> getAlbums() {
        return albums;
    }

    public void updateAlbums(String searchTerm) {
        getCompositeDisposable().add(getLastFmService()
                .searchByAlbum(searchTerm)
                .subscribeOn(getSchedulers().io())
                .observeOn(getSchedulers().mainThread())
                .map(AlbumResult::getResult)
                .map(AlbumResult.Result::getAlbumMatches)
                .map(AlbumMatches::getAlbums)
                .flatMapIterable(albumDetails -> albumDetails)
                .map(AlbumItemViewModel::new)
                .toList()
                .subscribe(albumsLiveData::setValue, throwable -> Log.e("4Dan", throwable.getMessage())));
    }

    public MutableLiveData<List<AlbumItemViewModel>> getAlbumsLiveData() {
        return albumsLiveData;
    }

    public void setAlbums(List<AlbumItemViewModel> albums) {
        this.albums.clear();
        this.albums.addAll(albums);
    }

    @Override
    public void search(String term) {
        Log.i("4Dan - master search", term + "");
        Log.i("hashCheck", "AlbumViewModel" + hashCode());
        updateAlbums(term);
    }
}
