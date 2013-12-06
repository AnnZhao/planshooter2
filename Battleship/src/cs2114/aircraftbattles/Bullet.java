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
 *  @author liuhx
 *  @version 2013-11-24
 */
public class Bullet extends RectangleShape
{
    // ----------------------------------------------------------
    /**
     * Create a new Bullet object.
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public Bullet(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setFillColor(Color.lightGray);
        setShapeMotion(ShapeMotion.DYNAMIC);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void move()
    {
        setLinearVelocity(0, -300);
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
}
