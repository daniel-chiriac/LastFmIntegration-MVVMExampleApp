package com.chiriacd.lastfmexampleapp.api.results;

import com.chiriacd.lastfmexampleapp.api.PaginatedResult;
import com.chiriacd.lastfmexampleapp.api.results.matches.AlbumMatches;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielC on 01/03/2018.
 */

public class AlbumResult {
    @SerializedName("results")
    Result result;

    class Result extends PaginatedResult {

        @SerializedName("albummatches")
        public AlbumMatches content;

    }
}
