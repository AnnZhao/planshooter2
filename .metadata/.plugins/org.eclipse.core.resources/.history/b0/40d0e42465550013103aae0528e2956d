package cs2114.aircraftbattles;

import sofia.graphics.RectangleShape;
import sofia.graphics.ShapeMotion;

public class Enemy3 extends RectangleShape
{
    /**
     * Create a new Aircraft object.
     * @param x
     * @param y
     */
    public Enemy3(float left, float top, float right, float bottom)
    {
        super(left, 0, left + 12, 12);
        setShapeMotion(ShapeMotion.DYNAMIC);
        setDensity(5);
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
