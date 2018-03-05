package com.chiriacd.lastfmexampleapp.screens.pager.album;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;

import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.api.results.AlbumResult;
import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumItemViewModel;
import com.chiriacd.lastfmexampleapp.utils.LastFmTestResponse;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;
import com.chiriacd.lastfmexampleapp.utils.TestSchedulersProvider;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.TestScheduler;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AlbumFragmentViewModelTest {

    @Rule public TestRule rule = new InstantTaskExecutorRule();

    @Mock private LastFmService lastFmService;
    @Mock private MutableLiveData<List<AlbumItemViewModel>> albumsLiveData;
    @Mock private Observer<List<AlbumItemViewModel>> observer;

    private TestScheduler testScheduler;
    private AlbumFragmentViewModel albumFragmentViewModel;

    @Before
    public void setUp() {
        testScheduler = new TestScheduler();
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> testScheduler);
        SchedulersProvider schedulersProvider = new TestSchedulersProvider(testScheduler);
        albumsLiveData = new MutableLiveData<>();
        albumFragmentViewModel = new AlbumFragmentViewModel(lastFmService, schedulersProvider, albumsLiveData);
    }

    @Test
    public void givenViewModelSearch_whenCompletes_thenLiveDataObserversGetNotified() {

        albumsLiveData.observeForever(observer);

        AlbumResult albumResult = LastFmTestResponse.provideTestAlbumResut(1);
        Mockito.when(lastFmService.searchByAlbum(anyString()))
                .thenReturn(Observable.just(albumResult));

        albumFragmentViewModel.search(anyString());

        testScheduler.triggerActions();

        verify(observer).onChanged(any());

    }

    @Test
    public void givenViewModelSearch_whenCompletes_expectedNumberOfElementsIsReceived() {

        albumsLiveData.observeForever(observer);

        int numberOfResults = 10;
        AlbumResult albumResult = LastFmTestResponse.provideTestAlbumResut(numberOfResults);
        Mockito.when(lastFmService.searchByAlbum(anyString()))
                .thenReturn(Observable.just(albumResult));

        albumFragmentViewModel.search(anyString());

        testScheduler.triggerActions();

        List<AlbumItemViewModel> value = albumsLiveData.getValue();
        assertEquals("Unexpected number of elements", numberOfResults, value.size());
    }
}
