package cs2114.aircraftbattles;

import sofia.graphics.Color;
import sofia.graphics.ShapeMotion;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Hangxin Liu
 *  @version 2013-11-6
 */
public class Bullet extends RectangleShape
{
    // ----------------------------------------------------------
    /**
     * Create a new Bullet object.
     * @param x
     * @param y
     */
    public Bullet(float left, float top, float right, float bottom)
    {
        super(left, top, 1, 4);

        setShapeMotion(ShapeMotion.DYNAMIC);

        setFillColor(Color.lightGray);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param enemy1
     */
    public void onCollisionWith(Enemy1 enemy1)
    {
        remove();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param enemy2
     */
    public void onCollisionWith(Enemy2 enemy2)
    {
        remove();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param enemy3
     */
    public void onCollisionWith(Enemy3 enemy3)
    {
        remove();
    }
}
