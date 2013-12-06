package sofia.demo.avians;

import sofia.graphics.Color;
import sofia.graphics.RectangleShape;

//-------------------------------------------------------------------------
/**
 * Represents the slingshot in the Irritated Avians game. For now, we're just
 * going to use a boring brown rectangle.
 *
 * @author  Tony Allevato
 * @version 2013.03.05
 */
public class Slingshot extends RectangleShape
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a new slingshot at the specified location.
     *
     * @param left the x-coordinate of the top-left corner
     * @param top the y-coordinate of the top-left corner
     * @param right the x-coordinate of the bottom-right corner
     * @param bottom the y-coordinate of the bottom-right corner
     */
    public Slingshot(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);

        // The slingshot should be inactive, meaning that it is drawn but does
        // not participate in the physical simulation or offer collisions with
        // other shapes.
        setActive(false);

        // Set other visual properties of the slingshot.
        setColor(Color.brown);
        //setFilled(true);
        this.setFillColor(Color.brown);
    }
}
