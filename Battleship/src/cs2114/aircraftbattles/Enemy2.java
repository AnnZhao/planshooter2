package cs2114.aircraftbattles;

import sofia.graphics.ShapeMotion;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author liuhx
 *  @version 2013-11-24
 */
public class Enemy2 extends RectangleShape
{
    // ----------------------------------------------------------
    /**
     * Create a new Enemy3 object.
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public Enemy2(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setShapeMotion(ShapeMotion.DYNAMIC);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param x
     */
    public void speed(int x)
    {
        setLinearVelocity(0, x);
        //return x;
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
     * @return
     */
    public boolean onCollisionWith(Aircraft aircraft)
    {
        remove();
        return true;
    }

}
