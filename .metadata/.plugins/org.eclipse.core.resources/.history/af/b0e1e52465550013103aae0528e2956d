package cs2114.aircraftbattles;

import android.graphics.PointF;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author dell
 * @version 2013-11-4
 */
public class Aircraft
    extends RectangleShape
{
    private PointF position;

    // ----------------------------------------------------------
    /**
     * Create a new Aircraft object.
     * @param x
     * @param y
     */
    public Aircraft(float left, float top, float right, float bottom)
    {
        super(left, top, left + 5, top + 6);
        reset();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void reset()
    {
        setPosition(position);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param enemy1
     * @return
     */
    public boolean onCollisionWith(Enemy1 enemy1)
    {
        remove();
        return true;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param enemy2
     */
    public boolean onCollisionWith(Enemy2 enemy2)
    {
        remove();
        return true;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param enemy3
     */
    public boolean onCollisionWith(Enemy3 enemy3)
    {
        remove();
        return true;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void onTouchMove(float x, float y)
    {
        float xPosition = x;
        float yPosition = y;
        position = new PointF (xPosition, yPosition);
    }
}

