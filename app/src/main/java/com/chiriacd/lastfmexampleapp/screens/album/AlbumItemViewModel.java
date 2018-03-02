package com.chiriacd.lastfmexampleapp.screens.album;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.chiriacd.lastfmexampleapp.api.results.matches.details.AlbumDetail;

public class AlbumItemViewModel extends ViewModel {

    private final ObservableField<String> name;
    private final ObservableField<String> artist;

    public AlbumItemViewModel(AlbumDetail album) {
        name = new ObservableField<>(album.getName());
        artist = new ObservableField<>(album.getArtist());
    }

    public ObservableField<String> getArtist() {
        return artist;
    }

    public ObservableField<String> getName() {
        return name;
    }
}
