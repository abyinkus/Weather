package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
@RunWith(MockitoJUnitRunner.class)
public class ForecastAdapterTest {

    @Mock
    Forecaster forecaster;
    @InjectMocks
    ForecastAdapter client;


    @Test
    public void retrievForcast() throws Exception {
        Forecast BirminghamForecast = client.forecastFor(Region.BIRMINGHAM, Day.WEDNESDAY);
        verify(forecaster).forecastFor(Region.BIRMINGHAM, Day.WEDNESDAY);
    }

}