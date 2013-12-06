package cs2114.mazesolver;

import sofia.graphics.RectangleShape;
import sofia.graphics.Color;
import android.widget.TextView;
import android.widget.Button;
import sofia.graphics.ShapeView;

// -------------------------------------------------------------------------
/**
 * This class is the test for mazesolverScreen.
 *
 * @author Zhenshu Zhao (zzhens7)
 * @version 2013.10.23
 */
public class MazeSolverScreenTests
    extends student.AndroidTestCase<MazeSolverScreen>
{
    private ShapeView shapeView;
    private Button    drawWalls;
    private Button    eraseWalls;
    private Button    setStart;
    private Button    setGoal;
    private Button    solve;
    private TextView  infoLabel;
    private int       cellSize;


// ~ Constructors ..........................................................

// ----------------------------------------------------------
    /**
     * This method calls super() and passes it the screen/activity class being
     * tested.
     */
    public MazeSolverScreenTests()
    {
        super(MazeSolverScreen.class);
    }


// ~ Public methods ........................................................

// ----------------------------------------------------------
    /**
     * set up method.
     */
    public void setUp()
    {
        float viewSize = Math.min(shapeView.getWidth(), shapeView.getHeight());
        cellSize = (int)(viewSize / getScreen().getMaze().size());
    }


// ~ Private methods .......................................................
    /**
     * this method test drawing walls on screen by single click and touch down
     * and move.
     */
    public void testDrawWalls()
    {
        click(drawWalls);
        clickCell(1, 1);
        assertEquals(Color.white, getFillColorAt(1, 1, true));

        touchDownCell(2, 2);
        touchMoveCell(2, 3);
        touchUp();
        assertEquals(Color.white, getFillColorAt(2, 2, true));
        assertEquals(Color.white, getFillColorAt(2, 3, true));
        assertEquals(MazeCell.WALL, getCellAt(2, 2));
        assertEquals(MazeCell.WALL, getCellAt(2, 3));
    }


    /**
     * This test is to test draw walls by touch move and move out of bound.
     */
    public void testDrawWallsOutBound()
    {
        click(drawWalls);
        touchDownCell(4, 0);
        touchMove(4, -1);
        touchUp();
        assertEquals(Color.white, getFillColorAt(4, 0, true));
        assertEquals(MazeCell.WALL, getCellAt(4, 0));
    }


    /**
     * this method is for try to draw wall on start location.
     */
    public void testDrawWallsOnStart()
    {
        click(drawWalls);
        clickCell(0, 0);
        assertEquals(Color.maroon, getFillColorAt(0, 0, true));
        assertEquals(Color.black, getFillColorAt(0, 0, false));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(0, 0));
    }


    /**
     * this method is for try to draw wall on goal location.
     */
    public void testDrawWallsOnGoal()
    {
        click(drawWalls);
        clickCell(7, 7);
        assertEquals(Color.orange, getFillColorAt(7, 7, true));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(7, 7));
    }


    /**
     * this method is for erasing walls.
     */
    public void testEraseWalls()
    {
        click(drawWalls);
        clickCell(1, 1);
        click(eraseWalls);
        clickCell(1, 1);
        assertEquals(Color.black, getFillColorAt(1, 1, true));

        click(drawWalls);
        touchDownCell(2, 2);
        touchUp();
        click(eraseWalls);
        touchDownCell(2, 2);

        touchUp();
        assertEquals(Color.black, getFillColorAt(2, 2, true));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(2, 2));
    }


    /**
     * this method is to test erase walls by touch move.
     */
    public void testEraseWallsOutBound()
    {
        click(drawWalls);
        clickCell(4, 0);
        click(eraseWalls);
        touchDownCell(4, 0);
        touchMove(5, 0);
        touchMove(5, -1);
        touchUp();
        assertEquals(Color.black, getFillColorAt(4, 0, true));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(4, 0));
    }


    /**
     * this method is for try to erase wall on start location.
     */
    public void testEraseWallsOnStart()
    {
        click(eraseWalls);
        clickCell(0, 0);
        assertEquals(Color.maroon, getFillColorAt(0, 0, true));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(0, 0));
    }


    /**
     * this method is for try to erase wall on goal location.
     */
    public void testEraseWallsOnGoal()
    {
        click(eraseWalls);
        clickCell(7, 7);
        assertEquals(Color.orange, getFillColorAt(7, 7, true));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(7, 7));
    }


    /**
     * this method is for setting start location to a different location.
     */
    public void testSetStart()
    {
        click(setStart);
        clickCell(1, 1);
        assertEquals(Color.maroon, getFillColorAt(1, 1, true));
        assertEquals(Color.black, getFillColorAt(0, 0, true));

        touchDownCell(2, 2);
        touchMoveCell(2, 3);
        touchUp();
        assertEquals(Color.black, getFillColorAt(2, 2, true));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(2, 3));
    }


    /**
     * this method is for setting start location to a different location which
     * is a wall.
     */
    public void testSetStartOnWall()
    {
        click(drawWalls);
        clickCell(1, 1);
        click(setStart);
        clickCell(1, 1);
        assertEquals(Color.maroon, getFillColorAt(1, 1, true));
        assertEquals(Color.black, getFillColorAt(1, 1, false));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(1, 1));
    }


    /**
     * this method is for setting goal location to a different location.
     */
    public void testSetGoal()
    {
        click(setGoal);
        clickCell(1, 1);
        assertEquals(Color.orange, getFillColorAt(1, 1, true));
        assertEquals(Color.black, getFillColorAt(5, 5, true));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(1, 1));

        touchDownCell(2, 2);
        touchMoveCell(2, 3);
        touchUp();
        assertEquals(Color.orange, getFillColorAt(2, 3, true));
        assertEquals(Color.black, getFillColorAt(1, 1, true));
    }


    /**
     * this method method for setting goal location to a different location
     * which is a wall.
     */
    public void testSetGoalOnWall()
    {
        click(drawWalls);
        clickCell(1, 1);
        click(setGoal);
        clickCell(1, 1);
        assertEquals(Color.orange, getFillColorAt(1, 1, true));
        assertEquals(Color.black, getFillColorAt(1, 1, false));
        assertEquals(MazeCell.UNEXPLORED, getCellAt(1, 1));
    }


    /**
     * this method is for testing clicking solve button in different situations.
     */
    public void testSolve()
    {
        String str;
        click(solve);
        str =
            "(0, 0)(0, 1)(0, 2)(0, 3)(0, 4)(0, 5)(0, 6)(0, 7)"
                + "(1, 7)(2, 7)(3, 7)(4, 7)(5, 7)(6, 7)(7, 7)";
        assertEquals(str, infoLabel.getText());
        click(solve);

        click(drawWalls);
        clickCell(1, 0);
        clickCell(0, 1);
        click(solve);
        assertEquals("No solution was possible.", infoLabel.getText()
            .toString());
    }


// ----------------------------------------------------------
    /**
     * this method simulates touching down on the middle of the specified cell
     * in the maze.
     */
    private void touchDownCell(int x, int y)
    {
        touchDown(shapeView, (x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    /**
     * this method simulates moving the finger instantaneously to the middle of
     * the specified cell in the maze.
     */
    private void touchMoveCell(int x, int y)
    {
        touchMove((x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    /**
     * this method simulates clicking the middle of the specified cell in the
     * maze.
     */
    private void clickCell(int x, int y)
    {
        touchDownCell(x, y);
        touchUp();
    }


    /**
     * Get fill color of block at (x, y) of the maze.
     *
     * @param x
     *            the x cooperation of block in maze
     * @param y
     *            the y cooperation of block in maze
     * @param front
     *            get the block at front or at back
     * @return color color of the block at (x, y) of maze
     */
    private Color getFillColorAt(int x, int y, boolean front)
    {
        Color color;
        if (front)
        {
            color =
                shapeView.getShapes()
                    .locatedAt((x + 0.5f) * cellSize, (y + 0.5f) * cellSize)
                    .withClass(RectangleShape.class).front().getFillColor();
        }
        else
        {
            color =
                shapeView.getShapes()
                    .locatedAt((x + 0.5f) * cellSize, (y + 0.5f) * cellSize)
                    .withClass(RectangleShape.class).back().getFillColor();
        }
        return color;
    }


    /**
     * Get cell type of cell at (x, y) in maze.
     *
     * @param x
     *            the x cooperation of block in maze
     * @param y
     *            the y cooperation of block in maze
     */
    private MazeCell getCellAt(int x, int y)
    {
        MazeCell cell = getScreen().getMaze().getCell(new Location(x, y));
        return cell;
    }
}
