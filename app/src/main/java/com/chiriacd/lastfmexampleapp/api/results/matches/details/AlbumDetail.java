package com.chiriacd.lastfmexampleapp.api.results.matches.details;

public class AlbumDetail {

    String name;
    String artist;
    String url;

    public AlbumDetail(String name, String artist, String url) {
        this.name = name;
        this.artist = artist;
        this.url = url;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}