package com.chiriacd.lastfmexampleapp.api.results;

import com.chiriacd.lastfmexampleapp.api.PaginatedResult;
import com.google.gson.annotations.SerializedName;
import com.chiriacd.lastfmexampleapp.api.results.matches.ArtistMatches;

public class ArtistResult {

    @SerializedName("results")
    Result result;

    class Result extends PaginatedResult {

        @SerializedName("artistmatches")
        public ArtistMatches content;
    }

}
