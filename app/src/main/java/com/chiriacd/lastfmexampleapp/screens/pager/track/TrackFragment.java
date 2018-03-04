package com.chiriacd.lastfmexampleapp.screens.pager.track;

import com.chiriacd.lastfmexampleapp.BR;
import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.databinding.TrackFragmentBinding;
import com.chiriacd.lastfmexampleapp.screens.BaseFragment;
import com.chiriacd.lastfmexampleapp.screens.SearchableViewModel;


public class TrackFragment extends BaseFragment<TrackFragmentBinding, SearchableViewModel> {
    @Override
    public int getBindingVariable() {
        return BR._all;
    }

    @Override
    public int getLayoutId() {
        return R.layout.track_fragment;
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
