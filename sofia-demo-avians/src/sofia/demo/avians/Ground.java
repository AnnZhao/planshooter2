package sofia.demo.avians;

import sofia.graphics.LineShape;

//-------------------------------------------------------------------------
/**
 * Represents a segment of the boundary of the game field. We just use these
 * so that the bird has something to bounce off of instead of flying off the
 * screen.
 *
 * @author  Tony Allevato
 * @version 2013.03.05
 */
public class Ground extends LineShape
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a new ground segment with the specified coordinates.
     *
     * @param left the x-coordinate of the first point
     * @param top the y-coordinate of the first point
     * @param right the x-coordinate of the second point
     * @param bottom the y-coordinate of the second point
     */
    public Ground(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setFriction(2.0f);
    }
}
