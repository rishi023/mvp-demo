package com.mvp.prototype.base;



import com.mvp.prototype.DemoApp;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit.client.Response;


@RunWith(MockitoJUnitRunner.class)
public class BasePresenterTest {
    @Mock
    protected DemoApp context;
    protected Response response;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}
