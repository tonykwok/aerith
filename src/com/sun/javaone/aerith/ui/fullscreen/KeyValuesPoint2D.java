package com.sun.javaone.aerith.ui.fullscreen;

import java.awt.geom.Point2D;
import java.lang.reflect.Method;

import org.jdesktop.animation.timing.interpolation.KeyValues;
import org.jdesktop.swingx.mapviewer.GeoPosition;


public final class KeyValuesPoint2D extends KeyValues<Point2D> {
    public KeyValuesPoint2D(Point2D... values) {
        for(Point2D value : values) {
            this.values.add(value);
        }
    }

    @Override
    public Class<?> getType() {
        return Point2D.class;
    }

    @Override
    public void setValue(Object object, Method method, int i0, int i1, float fraction) {
        Point2D value = values.get(i0);
        if (i0 != i1) {
            Point2D v0 = values.get(i0);
            Point2D v1 = values.get(i1);
            double x = ((v1.getX() - v0.getX()) * fraction) + v0.getX();
            double y = ((v1.getY() - v0.getY()) * fraction) + v0.getY();
            value = new Point2D.Double(x, y);
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