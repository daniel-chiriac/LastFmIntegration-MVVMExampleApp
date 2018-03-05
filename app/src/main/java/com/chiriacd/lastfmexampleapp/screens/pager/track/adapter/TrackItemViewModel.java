package com.chiriacd.lastfmexampleapp.screens.pager.track.adapter;

import android.databinding.ObservableField;

import com.chiriacd.lastfmexampleapp.api.results.matches.details.TrackDetail;

public class TrackItemViewModel {

    private final ObservableField<String> name;
    private final ObservableField<String> artist;
    private final ObservableField<String> url;

    private final OnClickListener listener;

    public TrackItemViewModel(TrackDetail trackDetail, OnClickListener listener) {
        name = new ObservableField<>(trackDetail.getName());
        artist = new ObservableField<>(trackDetail.getArtist());
        url = new ObservableField<>(trackDetail.getUrl());
        this.listener = listener;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getArtist() {
        return artist;
    }

    public void itemClicked() {
        if (listener != null) {
            listener.onItemWithUrl(url.get());
        }
    }

    public interface OnClickListener {
        void onItemWithUrl(String url);
    }
}
