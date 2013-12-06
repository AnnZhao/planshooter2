package cs2114.aircraftbattle;

import android.graphics.PointF;
import sofia.graphics.Geometry;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author liuhx
 * @version 2013-11-23
 */
public class Aircraft
    extends RectangleShape
{
    private PointF startingPosition;
    // ----------------------------------------------------------
    /**
     * Create a new Aircraft object.
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public Aircraft(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        startingPosition = new PointF(left, top);
        setFillColor(Color.red);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param anything
     * @return
     */
    public boolean onCollisionWith(Enemy anything)
    {
        remove();
        return true;
    }

}
