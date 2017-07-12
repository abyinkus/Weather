package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ForecastCacheTest {

    @Mock
    ForecasterInterface forecaster;
    @InjectMocks
    ForecastCache forecastCache;
    @Mock
    Forecast forecast;

    @Before
    public void setUp() {
        when(forecaster.forecastFor(Region.BIRMINGHAM, Day.WEDNESDAY)).thenReturn(forecast);
    }

    @Test
    public void retrievForcastFromCache() throws Exception {
        forecastCache.forecastFor(Region.BIRMINGHAM, Day.TUESDAY);
        forecastCache.forecastFor(Region.BIRMINGHAM, Day.WEDNESDAY);
        forecastCache.forecastFor(Region.BIRMINGHAM, Day.THURSDAY);
        forecastCache.forecastFor(Region.BIRMINGHAM, Day.FRIDAY);
        forecastCache.forecastFor(Region.BIRMINGHAM, Day.TUESDAY);
        verify(forecaster, times(2)).forecastFor(Region.BIRMINGHAM, Day.TUESDAY);
    }

}