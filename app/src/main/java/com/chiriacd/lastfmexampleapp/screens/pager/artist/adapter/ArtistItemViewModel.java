package com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter;

import android.databinding.ObservableField;

import com.chiriacd.lastfmexampleapp.api.results.matches.details.ArtistDetail;

public class ArtistItemViewModel {

    private final ObservableField<String> name;
    private final ObservableField<String> url;//todo

    public ArtistItemViewModel(ArtistDetail artistDetail) {
        name = new ObservableField<>(artistDetail.getName());
        url = new ObservableField<>(artistDetail.getUrl());
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getUrl() {
        return url;
    }
}
