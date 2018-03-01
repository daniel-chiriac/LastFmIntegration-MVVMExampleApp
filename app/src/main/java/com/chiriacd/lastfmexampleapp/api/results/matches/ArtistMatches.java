package com.chiriacd.lastfmexampleapp.api.results.matches;

import com.chiriacd.lastfmexampleapp.api.results.matches.details.ArtistDetail;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DanielC on 28/02/2018.
 */
public class ArtistMatches {
    @SerializedName("artist")
    List<ArtistDetail> artists;
}
