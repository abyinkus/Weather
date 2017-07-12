package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ape02 on 12/07/2017.
 */
public class ForecastCache implements ForecasterInterface{

    private static final int MAX = 3;
    private ForecasterInterface forecaster;
    private Map<String, Forecast> cache = new HashMap<>();


    public ForecastCache(ForecasterInterface forescaster){
        this.forecaster = forescaster;
    }

    @Override
    public Forecast forecastFor(Region region, Day day) {
        if (cache.values().size() > MAX){
            cache.clear();
        }

        if(cache.containsKey(region.name()+day.name())){
            return cache.get(region.name()+day.name());
        }
        Forecast forecast = forecaster.forecastFor(region, day);
        cache.put(region.name()+day.name(), forecast);
        return  forecast;
    }
}
