package com.chiriacd.lastfmexampleapp.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielC on 28/02/2018.
 */

public class PaginatedResult {

    @SerializedName("opensearch:Query") Query query;
    @SerializedName("opensearch:totalResults") int totalResults;
    @SerializedName("opensearch:startIndex") int startIndex;
    @SerializedName("opensearch:itemsPerPage") int itemsPerPage;

    public class Query {
        String searchTerms;
        String startPage;
    }
}
