package cs2114.aircraftbattles;

import sofia.graphics.ShapeMotion;
import sofia.util.Random;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author dell
 *  @version 2013-11-4
 */
public class Enemy1
extends RectangleShape
{


    // ----------------------------------------------------------


    /**
     * Create a new Aircraft object.
     * @param x
     * @param y
     */
    public Enemy1(float left, float top, float right, float bottom)
    {
        super(left, 0, left + 3, 3);
        setShapeMotion(ShapeMotion.DYNAMIC);
        setDensity(1);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param bullet
     */
    public boolean onCollisionWith(Bullet bullet)
    {
        remove();
        return true;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param aircraft
     */
    public void onCollisionWith(Aircraft aircraft)
    {
        remove();
    }
}

