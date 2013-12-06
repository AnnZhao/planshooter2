package cs2114.mazesolver;

/**
 * // -------------------------------------------------------------------------
 * /** This interface represents an (x, y) coordinate pair.
 * 
 * @author Zhenshu Zhao
 * @version 2013-9-28
 */
public class Location
    implements ILocation
{
    private final int x;
    private final int y;


    /**
     * Constructor of Location.
     * 
     * @param x
     *            is the x coordinate row.
     * @param y
     *            is the y coordinate column.
     */
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    /**
     * Override the x coordinate.
     * 
     * @return x is x.
     */
    @Override
    public int x()
    {
        return x;
    }


    /**
     * Override the y coordinate.
     * 
     * @return y is y.
     */
    @Override
    public int y()
    {
        return y;
    }


    /**
     * Gets a new location that represents the (x, y) coordinates one cell east
     * of this location.
     * 
     * @return a new location that represents the (x, y) coordinates one cell
     *         east of this location.
     */
    @Override
    public Location east()
    {
        return new Location(x() + 1, y());
    }


    /**
     * Gets a new location that represents the (x, y) coordinates one cell north
     * of this location.
     * 
     * @return a new location that represents the (x, y) coordinates one cell
     *         north of this location.
     */
    @Override
    public Location north()
    {
        return new Location(x(), y() - 1);
    }


    /**
     * Gets a new location that represents the (x, y) coordinates one cell south
     * of this location.
     * 
     * @return a new location that represents the (x, y) coordinates one cell
     *         south of this location.
     */
    public Location south()
    {
        return new Location(x(), y() + 1);
    }


    /**
     * Gets a new location that represents the (x, y) coordinates one cell west
     * of this location.
     * 
     * @return a new location that represents the (x, y) coordinates one cell
     *         west of this location.
     */
    public Location west()
    {
        return new Location(x() - 1, y());
    }


    /**
     * An overridden equals(Object) method that returns true if the object
     * passed in is also a Location and has the same x- and y-coordinates as the
     * receiver.
     * 
     * @param obj
     *            the object to be compared
     * @return true if the objects have the same x and y coordinates.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Location && x() == ((Location)obj).x()
            && y() == ((Location)obj).y())
        {
            return true;
        }
        return false;
    }


    /**
     * returns a string representation of the location, formatted like "(x, y)".
     * 
     * @return the coordinates in the format (x, y)
     */
    @Override
    public String toString()
    {
        return "(" + x() + ", " + y() + ")";
    }
}
