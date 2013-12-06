package cs2114.mazesolver;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This class tests the Maze class
 *
 * @author Zhenshu Zhao
 * @version 2013-10-4
 */
public class MazeTest
    extends TestCase
{
    private Location startpoint;
    private Location goallocation;
    private Location location;
    private Location invalid;
    private Maze     maze;


    /**
     * set up method.
     */
    public void setUp()
    {
        maze = new Maze(5);
        location = new Location(2, 2);
        startpoint = new Location(0, 0);
        goallocation = new Location(4, 4);
        invalid = new Location(-1, 0);
    }


    /**
     * test get cell.
     */
    public void testGetCell()
    {
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(location));
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(invalid));
    }


    /**
     * test set cell.
     */
    public void testSetCell()
    {
        maze.setCell(invalid, MazeCell.INVALID_CELL);
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(invalid));

        maze.setCell(location, MazeCell.WALL);
        assertEquals(MazeCell.WALL, maze.getCell(location));

        maze.setCell(startpoint, MazeCell.WALL);
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(startpoint));

        maze.setCell(goallocation, MazeCell.WALL);
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(goallocation));
    }


    /**
     * test get start location.
     */
    public void testGetStartLocation()
    {
        assertEquals(startpoint, maze.getStartLocation());
    }


    /**
     * test set goal locaiton.
     */
    public void testSetGoalLocation()
    {
        {
            maze.setGoalLocation(location);
            assertEquals(location, maze.getGoalLocation());

            maze.setCell(goallocation, MazeCell.WALL);
            maze.setGoalLocation(goallocation);
            assertEquals(goallocation, maze.getGoalLocation());
            assertEquals(MazeCell.UNEXPLORED, maze.getCell(goallocation));

            maze.setGoalLocation(invalid);
            assertEquals(goallocation, maze.getGoalLocation());
        }
    }


    /**
     * test size.
     */
    public void testSize()
    {
        assertEquals(5, maze.size());
    }


    /**
     * test set start locaiton.
     */
    public void testSetStartLocation()
    {
        maze.setStartLocation(location);
        assertEquals(location, maze.getStartLocation());

        maze.setCell(startpoint, MazeCell.WALL);
        maze.setStartLocation(startpoint);
        assertEquals(startpoint, maze.getStartLocation());
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(startpoint));

        maze.setStartLocation(invalid);
        assertEquals(startpoint, maze.getStartLocation());
    }


    /**
     * test get goal location.
     */
    public void testGetGoalLocation()
    {
        assertEquals(goallocation, maze.getGoalLocation());
    }


    /**
     * test solve
     */
    public void testSolve()
    {
        String string =
            "(0, 0)(0, 1)(0, 2)(0, 3)(0, 4)(1, 4)(2, 4)(3, 4)(4, 4)";
        assertEquals(string, maze.solve());

        Maze mazetest1 = new Maze(5);
        mazetest1.setCell(new Location(0, 1), MazeCell.WALL);
        mazetest1.setCell(new Location(2, 3), MazeCell.WALL);
        mazetest1.setCell(new Location(2, 4), MazeCell.WALL);
        string = "(0, 0)(1, 0)(1, 1)(1, 2)(2, 2)(3, 2)(3, 3)(3, 4)(4, 4)";
        assertEquals(string, mazetest1.solve());

        Maze mazetest2 = new Maze(5);
        mazetest2.setCell(new Location(0, 1), MazeCell.WALL);
        mazetest2.setCell(new Location(1, 2), MazeCell.WALL);
        mazetest2.setCell(new Location(2, 3), MazeCell.WALL);
        mazetest2.setCell(new Location(3, 3), MazeCell.WALL);
        string = "(0, 0)(1, 0)(1, 1)(2, 1)(2, 2)(3, 2)(4, 2)(4, 3)(4, 4)";
        assertEquals(string, mazetest2.solve());

        Maze mazetest3 = new Maze(5);
        mazetest3.setStartLocation(new Location(2, 2));
        mazetest3.setGoalLocation(new Location(2, 3));
        string = "(2, 2)(2, 3)";
        assertEquals(string, mazetest3.solve());

        Maze mazetest4 = new Maze(5);
        mazetest4.setCell(new Location(0, 1), MazeCell.WALL);
        mazetest4.setCell(new Location(1, 0), MazeCell.WALL);
        assertNull(mazetest4.solve());

        Maze mazetest5 = new Maze(5);
        mazetest5.setCell(new Location(3, 4), MazeCell.WALL);
        mazetest5.setCell(new Location(4, 3), MazeCell.WALL);
        assertNull(mazetest5.solve());

        Maze mazetest6 = new Maze(5);
        mazetest6.setStartLocation(new Location(2, 2));
        mazetest6.setGoalLocation(startpoint);
        mazetest6.setCell(new Location(1, 2), MazeCell.WALL);
        mazetest6.setCell(new Location(2, 1), MazeCell.WALL);
        mazetest6.setCell(new Location(3, 2), MazeCell.WALL);
        mazetest6.setCell(new Location(2, 3), MazeCell.WALL);
        assertNull(mazetest6.solve());
    }
}
