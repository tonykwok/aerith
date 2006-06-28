package org.jdesktop.swingx.mapviewer.animation;

import java.lang.reflect.Method;

import org.jdesktop.animation.timing.interpolation.KeyValues;
import org.jdesktop.swingx.mapviewer.GeoPosition;


public final class KeyValuesGeoPosition extends KeyValues<GeoPosition> {
    public KeyValuesGeoPosition(GeoPosition... values) {
        for(GeoPosition value : values) {
            this.values.add(value);
        }
    }

    @Override
    public Class<?> getType() {
        return GeoPosition.class;
    }

    @Override
    public void setValue(Object object, Method method, int i0, int i1, float fraction) {
        GeoPosition value = values.get(i0);
        if (i0 != i1) {
            GeoPosition v0 = values.get(i0);
            GeoPosition v1 = values.get(i1);
            double latitude = ((v1.getLatitude() - v0.getLatitude()) * fraction) + v0.getLatitude();
            double longitude = ((v1.getLongitude() - v0.getLongitude()) * fraction) + v0.getLongitude();
            value = new GeoPosition(latitude, longitude);
        }
        try {
            method.invoke(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setValue(Object object, Method method, int i) {
        try {
            method.invoke(object, values.get(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}