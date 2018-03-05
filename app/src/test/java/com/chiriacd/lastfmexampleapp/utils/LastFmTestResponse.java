package com.chiriacd.lastfmexampleapp.utils;

import com.chiriacd.lastfmexampleapp.api.results.AlbumResult;
import com.chiriacd.lastfmexampleapp.api.results.matches.AlbumMatches;
import com.chiriacd.lastfmexampleapp.api.results.matches.details.AlbumDetail;
import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class LastFmTestResponse {

    public static AlbumResult provideTestAlbumResut(int numberOfResults) {
        ArrayList<AlbumDetail> albums = new ArrayList<>();
        for (int i=0; i<numberOfResults; i++) {
            albums.add(new AlbumDetail("test", "test", "test"));
        }
        AlbumMatches albumMatches = new AlbumMatches(albums);
        AlbumResult.Result result = new AlbumResult.Result(albumMatches);
        return new AlbumResult(result);
    }

    public static List<AlbumItemViewModel> albumItemViewModelFrom(AlbumResult albumResult) {
        List<AlbumDetail> albums = albumResult.getResult().getAlbumMatches().getAlbums();
        return Observable.fromIterable(albums)
                .map(albumDetail -> new AlbumItemViewModel(albumDetail, null))
                .toList()
                .blockingGet();

    }
}
