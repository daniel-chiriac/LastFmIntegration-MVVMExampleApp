package com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter;

import android.databinding.ObservableField;

import com.chiriacd.lastfmexampleapp.api.results.matches.details.ArtistDetail;
import com.chiriacd.lastfmexampleapp.screens.pager.ItemClickListener;
import com.chiriacd.lastfmexampleapp.screens.pager.track.adapter.BaseItemViewModel;

public class ArtistItemViewModel extends BaseItemViewModel{

    private final ObservableField<String> name;
    private final ObservableField<String> url;

    public ArtistItemViewModel(ArtistDetail artistDetail, ItemClickListener listener) {
        super(listener);
        name = new ObservableField<>(artistDetail.getName());
        url = new ObservableField<>(artistDetail.getUrl());
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getUrl() {
        return url;
    }

    @Override
    public String getItemClickedUrl() {
        return url.get();
    }
}
