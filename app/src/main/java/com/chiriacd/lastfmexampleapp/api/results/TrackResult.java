package com.chiriacd.lastfmexampleapp.api.results;

import com.chiriacd.lastfmexampleapp.api.PaginatedResult;
import com.chiriacd.lastfmexampleapp.api.results.matches.TrackMatches;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielC on 01/03/2018.
 */

public class TrackResult {

    @SerializedName("results")
    Result result;

    public Result getResult() {
        return result;
    }

    public class Result extends PaginatedResult {

        @SerializedName("trackmatches")
        public TrackMatches trackMatches;

        public TrackMatches getTrackMatches() {
            return trackMatches;
        }
    }
}
