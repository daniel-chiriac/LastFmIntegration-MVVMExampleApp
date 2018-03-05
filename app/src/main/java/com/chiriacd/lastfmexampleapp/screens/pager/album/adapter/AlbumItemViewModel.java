package com.chiriacd.lastfmexampleapp.screens.pager.album.adapter;

import android.databinding.ObservableField;

import com.chiriacd.lastfmexampleapp.api.results.matches.details.AlbumDetail;
import com.chiriacd.lastfmexampleapp.screens.pager.ItemClickListener;
import com.chiriacd.lastfmexampleapp.screens.pager.track.adapter.BaseItemViewModel;

public class AlbumItemViewModel extends BaseItemViewModel {

    private final ObservableField<String> name;
    private final ObservableField<String> artist;
    private final ObservableField<String> url;

    public AlbumItemViewModel(AlbumDetail album, ItemClickListener listener) {
        super(listener);
        name = new ObservableField<>(album.getName());
        artist = new ObservableField<>(album.getArtist());
        url = new ObservableField<>(album.getUrl());
    }

    public ObservableField<String> getArtist() {
        return artist;
    }

    public ObservableField<String> getName() {
        return name;
    }

    @Override
    public String getItemClickedUrl() {
        return url.get();
    }
}
