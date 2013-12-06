package sofia.demo.avians;

import sofia.app.ShapeScreen;
import sofia.graphics.Anchor;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 * The main gameplay screen for the Irritated Avians game.
 *
 * @author  Tony Allevato
 * @version 2013.03.05
 */
public class IrritatedAviansScreen extends ShapeScreen
{
    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Initializes the state of the screen: its background color, the
     * coordinate system, gravity, and the shapes in the field.
     */
    public void initialize()
    {
        // This background color matches the top of background.png.
        setBackgroundColor(Color.rgb(193, 232, 239));

        // By default, ShapeScreen uses the same coordinate system as a regular
        // Android view: (0, 0) is at the top-left, and each pixel is one
        // "unit". When using physics though, it's best to provide a
        // traditional Cartesian system with more realistic units. So here we
        // set up the coordinate system to have (0, 0) in the bottom-left
        // corner, we explicitly flip the y-axis to grow upward instead of
        // downward, and we map the view's width to 50 units in our field
        // space.
        getCoordinateSystem().origin(Anchor.BOTTOM_LEFT).flipY().width(50);

        // Apply standard Earth gravity to our scene.
        setGravity(0, -9.8f);

        // Add things to the scene.
        addScenery();
        addBird();
        addPiggies();
    }


    // ----------------------------------------------------------
    /**
     * Adds a nice image background, "ground" lines on the bottom and sides of
     * the field to catch the birds if they fly off the screen, and then adds
     * the slingshot.
     */
    private void addScenery()
    {
        RectangleShape background = new RectangleShape(0, 0, 50, 26);
        background.setActive(false);
        background.setImage("background");
        background.setZIndex(-1000);
        add(background);

        add(new Ground(0, 0, 50, 0));
        add(new Ground(0, 0, 0, 1000));
        add(new Ground(50, 0, 50, 1000));

        add(new Slingshot(7, 0, 8, 7));
    }


    // ----------------------------------------------------------
    /**
     * Adds a red bird to the field.
     */
    private void addBird()
    {
        add(new Bird(7.5f, 7.0f));
    }


    // ----------------------------------------------------------
    /**
     * Places four pigs randomly in the game field.
     */
    private void addPiggies()
    {
        Random random = Random.generator();

        for (int i = 0; i < 4; i++)
        {
            int hwidth = (50 / 2);
            int x = random.nextInt(hwidth) + hwidth;
            int y = random.nextInt((int) 20);

            Piggy pig = new Piggy(x, y);
            add(pig);
        }
    }
}
