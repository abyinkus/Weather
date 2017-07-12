package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ape02 on 12/07/2017.
 */
public class ForecastCacheAdapter implements ForecasterInterface{

    private ForecasterInterface forescaster;
    private Map<String, Forecast> cache = new HashMap<>();

    public ForecastCacheAdapter(ForecasterInterface forescaster){
        this.forescaster = forescaster;
    }

    @Override
    public Forecast forecastFor(Region region, Day day) {
        if(cache.containsKey(region.name()+day.name())){
            return cache.get(region.name()+day.name());
        }
        Forecast forecast = forescaster.forecastFor(region, day);
        cache.put(region.name()+day.name(), forecast);
        return  forecast;
    }
}
