package com.chiriacd.lastfmexampleapp.api;


import com.chiriacd.lastfmexampleapp.api.results.AlbumResult;
import com.chiriacd.lastfmexampleapp.api.results.ArtistResult;
import com.chiriacd.lastfmexampleapp.api.results.TrackResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LastFmService {

    @GET("/2.0/?method=artist.search")
    Observable<ArtistResult> searchByArtist(@Query("artist") String artist);
    @GET("/2.0/?method=album.search")
    Observable<AlbumResult> searchByAlbum(@Query("album") String album);
    @GET("/2.0/?method=track.search")
    Observable<TrackResult> searchByTrack(@Query("track") String track);

}
