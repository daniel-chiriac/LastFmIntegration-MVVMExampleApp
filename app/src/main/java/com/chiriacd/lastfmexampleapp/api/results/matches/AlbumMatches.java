package com.chiriacd.lastfmexampleapp.api.results.matches;


import com.chiriacd.lastfmexampleapp.api.results.AlbumResult;
import com.chiriacd.lastfmexampleapp.api.results.matches.details.AlbumDetail;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumMatches {

    @SerializedName("album")
    private List<AlbumDetail> albums;

    public AlbumMatches(List<AlbumDetail> albums) {
        this.albums = albums;
    }

    public List<AlbumDetail> getAlbums() {
        return albums;
    }
}
