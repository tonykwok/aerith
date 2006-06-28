/*
 * AnimationUtil.java
 *
 * Created on April 3, 2006, 10:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.sun.javaone.aerith.g2d;

import org.jdesktop.animation.timing.Cycle;
import org.jdesktop.animation.timing.Envelope;
import org.jdesktop.animation.timing.Envelope.EndBehavior;
import org.jdesktop.animation.timing.Envelope.RepeatBehavior;
import org.jdesktop.animation.timing.TimingController;
import org.jdesktop.animation.timing.interpolation.KeyFrames;
import org.jdesktop.animation.timing.interpolation.KeyValues;
import org.jdesktop.animation.timing.interpolation.ObjectModifier;
import org.jdesktop.animation.timing.interpolation.PropertyRange;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author rbair
 */
public final class AnimationUtil {

    /** Creates a new instance of AnimationUtil */
    private AnimationUtil() {
    }

    public static TimingController createFadeInAnimation(JXPanel panel) {
        return createFadeAnimation(panel, 0.01f, .99f);
    }

    public static TimingController createFadeOutAnimation(JXPanel panel) {
        return createFadeAnimation(panel, 0.99f, .01f);
    }

    public static TimingController createFadeAnimation(JXPanel panel, float start, float end) {
        Cycle cycle = new Cycle(400, 10);
        Envelope envelope = new Envelope(1, 0, RepeatBehavior.FORWARD, EndBehavior.HOLD);
        KeyValues keyValues = KeyValues.createKeyValues(new float[] { start, end });
        KeyFrames keyFrames = new KeyFrames(keyValues);
        PropertyRange range = new PropertyRange("alpha", keyFrames);
        TimingController animator = new TimingController(cycle, envelope, new ObjectModifier(panel, range));
        animator.setAcceleration(0.7f);
        animator.setDeceleration(0.3f);
        return animator;
    }
}
