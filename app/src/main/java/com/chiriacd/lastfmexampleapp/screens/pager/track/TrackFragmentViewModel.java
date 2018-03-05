package com.chiriacd.lastfmexampleapp.screens.pager.track;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.net.Uri;
import android.util.Log;

import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.api.results.TrackResult;
import com.chiriacd.lastfmexampleapp.api.results.matches.TrackMatches;
import com.chiriacd.lastfmexampleapp.api.results.matches.details.TrackDetail;
import com.chiriacd.lastfmexampleapp.screens.pager.base.BaseFragmentViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.track.adapter.TrackItemViewModel;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import java.util.List;

import javax.inject.Inject;

public class TrackFragmentViewModel extends BaseFragmentViewModel {

    private final MutableLiveData<List<TrackItemViewModel>> tracksLiveData;
    private final MutableLiveData<String> clickedUrl;

    private final ObservableList<TrackItemViewModel> tracks;

    @Inject public TrackFragmentViewModel(LastFmService dataManager, SchedulersProvider schedulersProvider) {
        super(dataManager, schedulersProvider);
        tracksLiveData = new MutableLiveData<>();
        clickedUrl = new MutableLiveData<>();
        tracks = new ObservableArrayList<>();
    }

    public void updateTracks(String searchTerm) {
        getCompositeDisposable().add(getLastFmService()
                .searchByTrack(searchTerm)
                .subscribeOn(getSchedulers().io())
                .observeOn(getSchedulers().mainThread())
                .map(TrackResult::getResult)
                .map(TrackResult.Result::getTrackMatches)
                .map(TrackMatches::getTracks)
                .flatMapIterable(albumDetails -> albumDetails)
                .map((TrackDetail trackDetail) -> new TrackItemViewModel(trackDetail, this::onTrackClick))
                .toList()
                .subscribe(tracksLiveData::setValue, throwable -> Log.e("4Dan", throwable.getMessage())));
    }

    public ObservableList<TrackItemViewModel> getTracks() {
        return tracks;
    }

    private void onTrackClick(String url) {
        clickedUrl.setValue(url);
    }

    public MutableLiveData<String> getClickedUrl() {
        return clickedUrl;
    }

    public MutableLiveData<List<TrackItemViewModel>> getTracksLiveData() {
        return tracksLiveData;
    }

    public void setTracks(List<TrackItemViewModel> tracks) {
        this.tracks.clear();
        this.tracks.addAll(tracks);
    }

    @Override
    public void search(String s) {
        updateTracks(s);
    }
}
