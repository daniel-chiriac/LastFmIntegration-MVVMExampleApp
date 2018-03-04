package com.chiriacd.lastfmexampleapp.screens.pager.artist;

import com.chiriacd.lastfmexampleapp.BR;
import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.databinding.ArtistFragmentBinding;
import com.chiriacd.lastfmexampleapp.screens.pager.base.BaseFragment;
import com.chiriacd.lastfmexampleapp.screens.pager.base.SearchableViewModel;

public class ArtistFragment extends BaseFragment<ArtistFragmentBinding, SearchableViewModel> {
    @Override
    public int getBindingVariable() {
        return BR._all;
    }

    @Override
    public int getLayoutId() {
        return R.layout.artist_fragment;
    }

    @Override
    public SearchableViewModel getViewModel() {
        return new SearchableViewModel() {
            @Override
            public void search(String term) {
            }
        };
    }
}
