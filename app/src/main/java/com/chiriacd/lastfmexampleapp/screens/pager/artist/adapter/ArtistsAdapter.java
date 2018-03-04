package com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter;

import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.screens.pager.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ArtistsAdapter extends BaseAdapter {

    private List<ArtistItemViewModel> artists;

    @Inject public ArtistsAdapter() {
        artists = new ArrayList<>();
    }

    @Override
    protected Object getObjForPosition(int position) {
        return artists.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.artists_item;
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void clearArtists() {
        artists.clear();
    }

    public void addArtists(List<ArtistItemViewModel> artists) {
        this.artists.addAll(artists);
        notifyDataSetChanged();
    }
}
