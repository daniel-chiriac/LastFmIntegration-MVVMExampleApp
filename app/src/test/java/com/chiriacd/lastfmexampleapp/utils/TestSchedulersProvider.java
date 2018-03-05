package com.chiriacd.lastfmexampleapp.utils;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;


public class TestSchedulersProvider implements SchedulersProvider {

    private TestScheduler scheduler;

    public TestSchedulersProvider(TestScheduler testScheduler) {
        scheduler = testScheduler;
    }

    @Override
    public Scheduler io() {
        return scheduler;
    }

    @Override
    public Scheduler mainThread() {
        return scheduler;
    }
}
