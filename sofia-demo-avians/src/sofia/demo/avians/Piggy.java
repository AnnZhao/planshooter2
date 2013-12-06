package sofia.demo.avians;

import sofia.graphics.OvalShape;

//-------------------------------------------------------------------------
/**
 * Represents a piggy in the Irritated Avians game.
 *
 * @author  Tony Allevato
 * @version $Date: 2012/08/04 16:34 $
 */
public class Piggy extends OvalShape
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a new piggy at the specified location on the field.
     *
     * @param x the x-coordinate of the center of the piggy
     * @param y the y-coordinate of the center of the piggy
     */
    public Piggy(float x, float y)
    {
        super(x, y, 1.7f, 1.6f);

        setImage("green_pig");
        setDensity(1);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Called by Sofia when a {@code Piggy} is involved in a collision with a
     * {@link Bird}.
     *
     * @param bird the {@code Bird} that collided with the {@code Piggy}
     */
    public void onCollisionWith(Bird bird)
    {
        die();
    }


    // ----------------------------------------------------------
    /**
     * "Kills" the piggy by fading it out, making it spin around, and then
     * removing it from the playing field.
     */
    private void die()
    {
        animate(400).alpha(0).rotation(720).removeWhenComplete().play();
    }
}
