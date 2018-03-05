package com.chiriacd.lastfmexampleapp.api.results;

import com.chiriacd.lastfmexampleapp.api.PaginatedResult;
import com.chiriacd.lastfmexampleapp.api.results.matches.AlbumMatches;
import com.google.gson.annotations.SerializedName;

public class AlbumResult {

    @SerializedName("results")
    private Result result;

    public AlbumResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public static class Result extends PaginatedResult {

        @SerializedName("albummatches")
        private AlbumMatches albumMatches;

        public Result(AlbumMatches albumMatches) {
            this.albumMatches = albumMatches;
        }

        public AlbumMatches getAlbumMatches() {
            return albumMatches;
        }
    }
}
