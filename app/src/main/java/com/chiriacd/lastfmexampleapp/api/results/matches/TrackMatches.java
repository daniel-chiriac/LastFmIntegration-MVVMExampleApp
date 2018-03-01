package com.chiriacd.lastfmexampleapp.api.results.matches;

import com.chiriacd.lastfmexampleapp.api.results.matches.details.TrackDetail;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DanielC on 28/02/2018.
 */

public class TrackMatches {

    @SerializedName("track")
    List<TrackDetail> artists;
}
