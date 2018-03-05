package com.chiriacd.lastfmexampleapp.api.results.matches.details;

public class AlbumDetail {

    String name;
    String artist;

    public AlbumDetail(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }
}