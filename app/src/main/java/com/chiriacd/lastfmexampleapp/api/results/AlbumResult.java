package com.chiriacd.lastfmexampleapp.api.results;

import com.chiriacd.lastfmexampleapp.api.PaginatedResult;
import com.chiriacd.lastfmexampleapp.api.results.matches.AlbumMatches;
import com.google.gson.annotations.SerializedName;

public class AlbumResult {

    @SerializedName("results")
    private Result result;

    public Result getResult() {
        return result;
    }

    public class Result extends PaginatedResult {

        @SerializedName("albummatches")
        private AlbumMatches albumMatches;

        public AlbumMatches getAlbumMatches() {
            return albumMatches;
        }
    }
}
