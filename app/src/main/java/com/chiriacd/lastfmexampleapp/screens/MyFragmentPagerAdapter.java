package com.chiriacd.lastfmexampleapp.screens;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chiriacd.lastfmexampleapp.screens.album.AlbumFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

    private static final int FRAGMENT_COUNT = 3;

    private static final int ALBUM_FRAGMENT = 0;
    private static final int ARTIST_FRAGMENT = 1;
    private static final int TRACK_FRAGMENT = 2;

    //todo get current seach term from somewhere

    private final FragmentManager fragmentManager;
    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragmentManager.findFragmentByTag(getTag(position));
        if (fragment != null) return fragment;
        fragment = createNewFragmentAtPosition(position);
        return fragment;
    }

    private Fragment createNewFragmentAtPosition(int position) {
        switch (position) {
            case ALBUM_FRAGMENT:
                return AlbumFragment.Companion.newInstance();
        }
        return AlbumFragment.Companion.newInstance();

    }

    @Override
    public String getPageTitle(int position) {
        switch (position) {
            case ALBUM_FRAGMENT: return "Album";
            case ARTIST_FRAGMENT: return "Artist";
            case TRACK_FRAGMENT: return "Track";
        }
        return "";
    }

    private String getTag(int position) {
        return "MyFragmentPagerAdapterFrament" + position;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
}
