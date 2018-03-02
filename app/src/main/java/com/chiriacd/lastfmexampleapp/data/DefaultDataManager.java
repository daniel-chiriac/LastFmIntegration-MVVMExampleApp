package com.chiriacd.lastfmexampleapp.data;

import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.api.results.AlbumResult;
import com.chiriacd.lastfmexampleapp.api.results.ArtistResult;
import com.chiriacd.lastfmexampleapp.api.results.TrackResult;

import javax.inject.Inject;

import io.reactivex.Single;

public class DefaultDataManager implements DataManager {

    private LastFmService lastFmService;

    @Inject public DefaultDataManager(LastFmService lastFmService) {
        this.lastFmService = lastFmService;
    }

    @Override
    public Single<ArtistResult> searchByArtist(String artist) {
        return lastFmService.searchByArtist(artist);
    }

    @Override
    public Single<AlbumResult> searchByAlbum(String album) {
        return lastFmService.searchByAlbum(album);
    }

    @Override
    public Single<TrackResult> searchByTrack(String track) {
        return lastFmService.searchByTrack(track);
    }
}
