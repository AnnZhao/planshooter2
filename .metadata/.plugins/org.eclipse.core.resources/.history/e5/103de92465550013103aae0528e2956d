package cs2114.aircraftbattles;

import sofia.graphics.RectangleShape;
import sofia.graphics.ShapeMotion;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Hangxin Liu
 *  @version 2013-11-8
 */
public class Enemy2 extends RectangleShape
{
    /**
     * Create a new Aircraft object.
     * @param x
     * @param y
     */
    public Enemy2(float left, float top, float right, float bottom)
    {
        super(left, 0, left + 5, 7);
        setShapeMotion(ShapeMotion.DYNAMIC);
        setDensity(3);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param bullet
     * @return
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
