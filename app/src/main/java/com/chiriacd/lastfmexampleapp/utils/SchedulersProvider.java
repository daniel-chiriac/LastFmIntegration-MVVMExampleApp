package com.chiriacd.lastfmexampleapp.utils;

import io.reactivex.Scheduler;

public interface SchedulersProvider {

    Scheduler io();
    Scheduler mainThread();
}
