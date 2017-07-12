package com.develogical;

import com.sun.tools.internal.ws.wscompile.Options;
import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ape02 on 12/07/2017.
 */
public class ForecastAdapter implements ForecasterInterface {
    private Forecaster forecaster;

    ForecastAdapter(Forecaster forecaster){
        this.forecaster = forecaster;
    }

    @Override
    public Forecast forecastFor(Region region, Day day){
        return forecaster.forecastFor(region,day);
    }

}
