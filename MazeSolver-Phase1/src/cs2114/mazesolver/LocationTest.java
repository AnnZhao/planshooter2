package cs2114.mazesolver;

import student.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** Test cases of Location.
 * 
 * @author Zhenshu Zhao
 * @version 2013-9-29
 */
public class LocationTest
    extends TestCase
{
    private Location location1;
    private Location location2;
    private Location location3;


    /**
     * Test cases set up.
     */
    public void setUp()
    {
        location1 = new Location(1, 2);
        location2 = new Location(2, 1);
        location3 = new Location(2, 2);
    }


    /**
     * Test the x().
     */
    public void testX()
    {
        assertEquals(1, location1.x());
    }


    /**
     * Test the y().
     */
    public void testY()
    {
        assertEquals(2, location1.y());
    }


    /**
     * Test the east.
     */
    public void testEast()
    {
        assertEquals("(2, 2)", location1.east().toString());
    }


    /**
     * test the north.
     */
    public void testNorth()
    {
        assertEquals("(1, 1)", location1.north().toString());
    }


    /**
     * test the west.
     */
    public void testWest()
    {
        assertEquals("(0, 2)", location1.west().toString());
    }


    /**
     * test the south.
     */
    public void testSouth()
    {
        assertEquals("(1, 3)", location1.south().toString());
    }


    /**
     * test toString method.
     */
    public void testToString()
    {
        assertEquals("(1, 2)", location1.toString());
    }


    /**
     * test equals true: same coordinates.
     */
    public void testEqualsCoordinatesT()
    {
        Location location4 = new Location(1, 2);
        assertEquals(location1, location4);
    }


    /**
     * test equals false: not a location object
     */
    public void testEqualsF()
    {
        String hah = "test";
        assertFalse(location1.equals(hah));
    }


    /**
     * test equals false: different coordinates.
     */
    public void testEqualsCoordinatesF()
    {
        assertFalse(location1.equals(location2));
        assertFalse(location1.equals(location3));
    }

}
