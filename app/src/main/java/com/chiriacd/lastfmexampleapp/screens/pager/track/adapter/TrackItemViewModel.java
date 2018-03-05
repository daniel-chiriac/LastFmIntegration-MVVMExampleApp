package com.chiriacd.lastfmexampleapp.screens.pager.track.adapter;

import android.databinding.ObservableField;

import com.chiriacd.lastfmexampleapp.api.results.matches.details.TrackDetail;
import com.chiriacd.lastfmexampleapp.screens.pager.ItemClickListener;

public class TrackItemViewModel extends BaseItemViewModel {

    private final ObservableField<String> name;
    private final ObservableField<String> artist;
    private final ObservableField<String> url;

    public TrackItemViewModel(TrackDetail trackDetail, ItemClickListener listener) {
        super(listener);
        name = new ObservableField<>(trackDetail.getName());
        artist = new ObservableField<>(trackDetail.getArtist());
        url = new ObservableField<>(trackDetail.getUrl());
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getArtist() {
        return artist;
    }

    @Override
    public String getItemClickedUrl() {
        return url.get();
    }
}
