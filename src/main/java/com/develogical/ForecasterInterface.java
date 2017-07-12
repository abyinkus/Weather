package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;

/**
 * Created by ape02 on 12/07/2017.
 */
public interface ForecasterInterface {
    Forecast forecastFor(Region region, Day day);
}
