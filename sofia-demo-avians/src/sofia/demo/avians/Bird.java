package sofia.demo.avians;

import sofia.graphics.Geometry;
import sofia.graphics.OvalShape;
import sofia.graphics.Shape;
import sofia.graphics.ShapeMotion;
import sofia.util.Timer;
import android.graphics.PointF;

//-------------------------------------------------------------------------
/**
 * Represents a bird in the Irritated Avians game.
 *
 * @author  Tony Allevato
 * @version 2013.03.05
 */
public class Bird extends OvalShape
{
    //~ Instance/static variables .............................................

    private PointF startingPosition;
    private Timer trailTimer;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a new bird at the specified position in the field.
     *
     * @param x the x-coordinate of the center of the bird
     * @param y the y-coordinate of the center of the bird
     */
    public Bird(float x, float y)
    {
        // We give the bird a slightly oval shape instead of a perfect circle,
        // otherwise it will take a very long time to fully come to rest when
        // it rolls.
        super(x, y, 1.5f, 1.3f);

        // We remember the starting position because we need to be able to
        // reset it when it comes to rest.
        startingPosition = new PointF(x, y);

        // Set various permanent visual and physical properties of the shape.
        setImage("red_bird");
        setShapeMotion(ShapeMotion.DYNAMIC);
        setDensity(2);
        setRestitution(0.4f);
        setFriction(2.0f);

        // Use the reset method to initialize other "transient" properties
        // of the bird.
        reset();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Resets the bird's state; disables its gravity, stops its motion, resets
     * its rotation, and moves it back at its starting position.
     */
    public void reset()
    {
        setGravityScale(0);
        setLinearVelocity(0, 0);
        setRotation(0);
        setPosition(startingPosition);
    }


    // ----------------------------------------------------------
    /**
     * This method is called by Sofia when the bird collides with any other
     * shape in the field.
     *
     * @param anything the shape that the bird collided with
     */
    public void onCollisionWith(Shape anything)
    {
        // When a bird collides with something, we stop the repeating timer
        // that drops trail dots along the bird's path.

        if (trailTimer != null)
        {
            trailTimer.stop();
            trailTimer = null;
        }
    }


    // ----------------------------------------------------------
    /**
     * This method is called by Sofia when the bird first comes to rest after
     * being in motion.
     */
    public void onSleep()
    {
        // Once the bird has come to rest, wait half a second and then reset
        // the bird's position.

        Timer.callOnce(this, "reset", 500);
    }


    // ----------------------------------------------------------
    /**
     * This method is called by Sofia when the user's finger moves after
     * having touched the bird.
     *
     * @param x the x-coordinate, in field units (not pixels) where the user's
     *          finger moved
     * @param y the y-coordinate, in field units (not pixels) where the user's
     *          finger moved
     */
    public void onTouchMove(float x, float y)
    {
        // We do a little math here to clamp the distance that the bird can be
        // pulled from the slingshot.

        float distance = Geometry.distanceBetween(
                startingPosition.x, startingPosition.y, x, y);
        float angle = Geometry.angleBetween(
                startingPosition.x, startingPosition.y, x, y);

        distance = Math.min(distance, 4.0f);

        PointF newPosition = Geometry.polarShift(
                startingPosition, angle, distance);
        setPosition(newPosition);
    }


    // ----------------------------------------------------------
    /**
     * This method is called by Sofia when the user releases his or her finger
     * from the bird.
     *
     * @param x the x-coordinate where the user released his or her finger
     * @param y the y-coordinate where the user released his or her finger
     */
    public void onTouchUp(float x, float y)
    {
        // Here we calculate the distance from the starting point, which we'll
        // use to calculate the impulse that "flings" the bird.

        float dx = x - startingPosition.x;
        float dy = y - startingPosition.y;

        // Restore the effects of gravity on the bird before it is flung, then
        // apply a linear impulse that "flings" it in the opposite direction
        // that the user pulled it. The 50 multiplier was found through
        // experimentation.

        setGravityScale(1);
        applyLinearImpulse(-dx * 50, -dy * 50);

        // Set up a timer that repeatedly calls the leaveTrail() method on this
        // bird; this will create the "dots" on the screen that show the path
        // that the bird traveled.

        trailTimer = Timer.callRepeatedly(this, "leaveTrail", 100);
    }


    // ----------------------------------------------------------
    /**
     * This method is called on a timer (see onTouchUp, above) every
     * half-second to leave a dot on the screen at the bird's current position.
     * The {@link TrailDot} constructor actually does all of the work.
     */
    public void leaveTrail()
    {
        new TrailDot(this);
    }
}
