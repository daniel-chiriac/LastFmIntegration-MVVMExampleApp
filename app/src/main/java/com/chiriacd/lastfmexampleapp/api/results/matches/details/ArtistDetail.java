package com.chiriacd.lastfmexampleapp.api.results.matches.details;

import com.google.gson.annotations.SerializedName;

public class ArtistDetail {
    @SerializedName("name")
    String name;

    @SerializedName("url")
    String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}