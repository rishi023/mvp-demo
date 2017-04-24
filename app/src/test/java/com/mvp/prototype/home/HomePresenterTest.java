package com.mvp.prototype.home;


import com.mvp.prototype.base.BasePresenterTest;
import com.mvp.prototype.common.MockModel;
import com.mvp.prototype.data.remote.LocationApi;
import com.mvp.prototype.data.model.LocationResponse;
import com.mvp.prototype.ui.main.home.presenter.HomePresenter;
import com.mvp.prototype.ui.main.home.view.HomeView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import retrofit.Callback;

import static org.mockito.Mockito.verify;

public class HomePresenterTest extends BasePresenterTest{
    @Mock
    private LocationApi locationService;
    @Mock
    HomeView homeView;
    @InjectMocks
    private HomePresenter homePresenter = new HomePresenter();
    private LocationResponse locationResponse;
    @Before
    public void setUp() {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        homePresenter.attachView(homeView);
        locationResponse = MockModel.getLatLong();
        Mockito.doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Callback callback = (Callback) invocation.getArguments()[0];
                callback.success(locationResponse, response);
                return null;
            }
        }).when(locationService).getLocation(Mockito.any(Callback.class));

        homePresenter.getLocation();
    }

    @Test
    public void getLocationTest() throws Exception {
        verify(homeView).onSuccess(locationResponse);
    }


    @After
    public void detachView() {
        homePresenter.detachView();
    }
}
