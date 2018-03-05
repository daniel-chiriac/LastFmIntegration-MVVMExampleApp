package com.chiriacd.lastfmexampleapp.screens.pager.artist;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.api.results.ArtistResult;
import com.chiriacd.lastfmexampleapp.api.results.matches.ArtistMatches;
import com.chiriacd.lastfmexampleapp.api.results.matches.details.ArtistDetail;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter.ArtistItemViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.base.BaseFragmentViewModel;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import java.util.List;

import javax.inject.Inject;

public class ArtistFragmentViewModel extends BaseFragmentViewModel {

    private final MutableLiveData<List<ArtistItemViewModel>> artistsLiveData;

    private final ObservableList<ArtistItemViewModel> artists;

    @Inject public ArtistFragmentViewModel(LastFmService dataManager, SchedulersProvider schedulersProvider) {
        super(dataManager, schedulersProvider);
        artistsLiveData = new MutableLiveData<>();
        artists = new ObservableArrayList<>();
    }

    public void updateArtists(String searchTerm) {
        getCompositeDisposable().add(getLastFmService()
                .searchByArtist(searchTerm)
                .subscribeOn(getSchedulers().io())
                .observeOn(getSchedulers().mainThread())
                .map(ArtistResult::getResult)
                .map(ArtistResult.Result::getArtistMatches)
                .map(ArtistMatches::getArtists)
                .flatMapIterable(albumDetails -> albumDetails)
                .map((ArtistDetail albumDetail) -> new ArtistItemViewModel(albumDetail, this::onTrackClick))
                .toList()
                .subscribe(artistsLiveData::setValue, throwable -> Log.e("4Dan", throwable.getMessage())));
    }

    public ObservableList<ArtistItemViewModel> getArtists() {
        return artists;
    }

    public MutableLiveData<List<ArtistItemViewModel>> getArtistsLiveData() {
        return artistsLiveData;
    }

    public void setArtists(List<ArtistItemViewModel> artists) {
        this.artists.clear();
        this.artists.addAll(artists);
    }

    @Override
    public void search(String s) {
        updateArtists(s);
    }
}
