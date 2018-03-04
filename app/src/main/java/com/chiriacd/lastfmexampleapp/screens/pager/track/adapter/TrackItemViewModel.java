package com.chiriacd.lastfmexampleapp.screens.pager.track.adapter;

import android.databinding.ObservableField;

import com.chiriacd.lastfmexampleapp.api.results.matches.details.TrackDetail;

public class TrackItemViewModel  {

    private final ObservableField<String> name;
    private final ObservableField<String> artist;

    public TrackItemViewModel(TrackDetail trackDetail) {

        name = new ObservableField<>(trackDetail.getName());
        artist = new ObservableField<>(trackDetail.getArtist());
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getArtist() {
        return artist;
    }
}
