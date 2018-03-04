package com.chiriacd.lastfmexampleapp.screens.pager.track.adapter;

import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.screens.pager.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TrackAdapter extends BaseAdapter {

    private List<TrackItemViewModel> tracks;

    @Inject public TrackAdapter() {
        tracks = new ArrayList<>();
    }

    @Override
    protected Object getObjForPosition(int position) {
        return tracks.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.track_item;
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public void clearTracks() {
        tracks.clear();
    }

    public void addTracks(List<TrackItemViewModel> tracks) {
        this.tracks.addAll(tracks);
        notifyDataSetChanged();
    }
}
