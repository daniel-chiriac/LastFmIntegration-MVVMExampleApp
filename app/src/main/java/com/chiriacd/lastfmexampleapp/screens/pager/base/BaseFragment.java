package com.chiriacd.lastfmexampleapp.screens.pager.base;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chiriacd.lastfmexampleapp.screens.MasterViewModel;
import com.chiriacd.lastfmexampleapp.utils.qualifier.MasterVM;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<T extends ViewDataBinding, V extends SearchableViewModel> extends DaggerFragment {

    private T viewDataBinding;

    @Inject @MasterVM ViewModelProvider.Factory masterFactory;

    public abstract int getBindingVariable();

    @LayoutRes public abstract int getLayoutId();

    public abstract V getViewModel();

    public T getViewDataBinding() {
        return viewDataBinding;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MasterViewModel masterViewModel = ViewModelProviders.of(getActivity(), masterFactory).get(MasterViewModel.class);
        //observing live data, seems to keep adding observers on screen rotation. Also,
        //onNewSearchTerm is triggered on rotation, regardless of having no data changes (the term
        //didn't change). There seems to be some recent issues around this explained in this post:
        //https://github.com/googlesamples/android-architecture-components/issues/47

        masterViewModel.getSearchTermLiveData().observe(this, s -> getViewModel().search(s));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return viewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding.setVariable(getBindingVariable(), getViewModel());
        viewDataBinding.executePendingBindings();
    }
}
