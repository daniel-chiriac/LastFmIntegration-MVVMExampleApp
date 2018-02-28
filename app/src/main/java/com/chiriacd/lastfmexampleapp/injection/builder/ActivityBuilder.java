package com.chiriacd.lastfmexampleapp.injection.builder;

import com.chiriacd.lastfmexampleapp.screens.MasterActivity;

import dagger.Module;

/**
 * Created by DanielC on 28/02/2018.
 */

@Module
public abstract class ActivityBuilder {
    abstract MasterActivity bindMasterActivity();
}
