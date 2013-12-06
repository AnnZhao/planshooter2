package sofia.demo.avians;

import static sofia.graphics.Anchor.CENTER;
import sofia.graphics.Color;
import sofia.graphics.OvalShape;

//-------------------------------------------------------------------------
/**
 * Represents a dot left behind along the path traveled by a bird before its
 * first collision.
 *
 * @author  Tony Allevato
 * @version 2013.03.05
 */
public class TrailDot extends OvalShape
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a new dot located at the given {@link Bird}'s current
     * position, adds it to the same field where the bird is located, and then
     * queues up an animation that will fade the dot away after a short delay.
     *
     * @param bird the bird where the dot should be centered
     */
    public TrailDot(Bird bird)
    {
        super(CENTER.of(bird), 0.25f);

        // Trail dots should be inactive, meaning that they are drawn but do
        // not participate in the physical simulation or offer collisions with
        // other shapes.
        setActive(false);

        // Set other visual properties of the bird.
        setFillColor(Color.white);
        setColor(Color.rgb(64, 64, 64));
        //setFilled(true);
        setZIndex(-100);

        // Add the dot to the same field that contains the bird.
        bird.addOther(this);

        // Begin an animation with a half-second duration, starting after one
        // second, that fades the dot out and removes it from the field when
        // complete.
        animate(500).delay(1000).alpha(0).removeWhenComplete().play();
    }
}
