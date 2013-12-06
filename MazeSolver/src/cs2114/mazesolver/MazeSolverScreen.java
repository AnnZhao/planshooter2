package cs2114.mazesolver;

import android.widget.TextView;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 * This class design an Android GUI that combines standard widgets and custom
 * graphics for MazeSolver.
 *
 * @author Zhenshu Zhao (zzhens7)
 * @version 2013.10.23
 */
public class MazeSolverScreen
    extends ShapeScreen
{
    private Maze               maze;
    private boolean            draw;
    private boolean            start;
    private boolean            goal;
    private boolean            erase;

    private int                size;
    private RectangleShape[][] shapelocation;
    private RectangleShape     startpoint1;
    private RectangleShape     endpoint1;
    private TextView           infoLabel;


    /**
     * Create a visual representation of the maze using a grid of shapes.
     */
    public void initialize()
    {
        maze = new Maze(8);

        draw = false;
        start = false;
        goal = false;
        erase = false;
        shapelocation = new RectangleShape[8][8];
        float min = Math.min(getHeight(), getWidth());
        size = (int)min / 8;

        setShape();
        setStartAndGoal();
    }


    /**
     * This method set the 8 * 8 screen. Choose the minimum between width and
     * height so that each cell on screen is a square.
     */
    private void setShape()
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                shapelocation[x][y] =
                    new RectangleShape(size * x, size * y, size * (x + 1), size
                        * (y + 1));
                shapelocation[x][y].setColor(Color.white);
                shapelocation[x][y].setFillColor(Color.black);
                this.add(shapelocation[x][y]);
            }
        }
    }


    /**
     * This method set the initial start and goal point.
     */
    private void setStartAndGoal()
    {
        startpoint1 = new RectangleShape(0, 0, size, size);
        startpoint1.setColor(Color.white);
        startpoint1.setFillColor(Color.maroon);
        this.add(startpoint1);

        endpoint1 = new RectangleShape(7 * size, 7 * size, 8 * size, 8 * size);
        endpoint1.setColor(Color.white);
        endpoint1.setFillColor(Color.orange);
        this.add(endpoint1);
    }


    /**
     * Get the maze when the method called.
     *
     * @return return the maze
     */
    public IMaze getMaze()
    {
        return maze;
    }


    /**
     * When drawWalls bottom is clicked, it changes to draw mode.
     */
    public void drawWallsClicked()
    {
        draw = true;
        start = false;
        goal = false;
        erase = false;
    }


    /**
     * When eraseWalls bottom is clicked, it change to erase mode.
     */
    public void eraseWallsClicked()
    {
        draw = false;
        start = false;
        goal = false;
        erase = true;
    }


    /**
     * When setStart is clicked, it changes to start mode.
     */
    public void setStartClicked()
    {
        draw = false;
        start = true;
        goal = false;
        erase = false;
    }


    /**
     * When setGoal button was clicked, it changes to set goal location mode.
     */
    public void setGoalClicked()
    {
        draw = false;
        start = false;
        goal = true;
        erase = false;
    }


    /**
     * This method is called when solve bottom is clicked, it changes to solve
     * mode before solving.
     */
    public void solveClicked()
    {
        this.reset();
        String str = maze.solve();
        if (str != null)
        {
            infoLabel.setText(str);
        }
        else
        {
            infoLabel.setText("No solution was possible.");
        }

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                MazeCell cell = maze.getCell(new Location(j, i));
                if (cell == MazeCell.CURRENT_PATH)
                {
                    shapelocation[i][j] =
                        this.getShapes()
                            .locatedAt((i + 1) * size, (j + 1) * size)
                            .withClass(RectangleShape.class).back();
                    shapelocation[i][j].setFillColor(Color.green);
                }
                else if (cell == MazeCell.FAILED_PATH)
                {
                    shapelocation[i][j] =
                        this.getShapes()
                            .locatedAt((i + 1) * size, (j + 1) * size)
                            .withClass(RectangleShape.class).back();
                    shapelocation[i][j].setFillColor(Color.red);
                }
            }
        }
    }


    /**
     * this method reset in maze and on screen to be Unexplored(black).
     */
    private void reset()
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (maze.getCell(new Location(i, j)) == MazeCell.CURRENT_PATH
                    || maze.getCell(new Location(i, j)) == MazeCell.FAILED_PATH)
                {
                    maze.setCell(new Location(i, j), MazeCell.UNEXPLORED);
                    shapelocation[i][j] =
                        this.getShapes()
                            .locatedAt((i + 1) * size, (j + 1) * size)
                            .withClass(RectangleShape.class).back();
                    shapelocation[i][j].setColor(Color.white);
                    shapelocation[i][j].setFillColor(Color.black);
                    this.add(shapelocation[i][j]);
                }
            }
        }
    }


    /**
     * Process the command according to the current mode.
     *
     * @param x
     *            the x-cooperation that touched
     * @param y
     *            the y-cooperation that touched
     */
    public void processTouch(float x, float y)
    {
        if (x > 0 && y > 0 && x < this.getWidth() && y < this.getHeight())
        {
            int xCo = (int)Math.floor(x / size);
            int yCo = (int)Math.floor(y / size);
            Location loc = new Location(xCo, yCo);
            shapelocation[xCo][yCo] =
                this.getShapes().locatedAt(x, y)
                    .withClass(RectangleShape.class).front();
            if (draw)
            {
                if (shapelocation[xCo][yCo].getFillColor() != Color.maroon
                    && shapelocation[xCo][yCo].getFillColor() != Color.orange)
                {
                    maze.setCell(loc, MazeCell.WALL);
                    shapelocation[xCo][yCo].setFillColor(Color.white);
                }
            }
            else if (start)
            {
                maze.setStartLocation(loc);
                if (shapelocation[xCo][yCo].getFillColor() == Color.white)
                {
                    shapelocation[xCo][yCo].setFillColor(Color.black);
                }
                startpoint1.setPosition(
                    (xCo + (float)0.5) * size,
                    (yCo + (float)0.5) * size);
            }
            else if (goal)
            {
                maze.setGoalLocation(loc);
                if (shapelocation[xCo][yCo].getFillColor() == Color.white)
                {
                    shapelocation[xCo][yCo].setFillColor(Color.black);
                }
                endpoint1.setPosition(
                    (xCo + (float)0.5) * size,
                    (yCo + (float)0.5) * size);
            }
            else if (erase
                && shapelocation[xCo][yCo].getFillColor() != Color.maroon
                && shapelocation[xCo][yCo].getFillColor() != Color.orange)
            {

                shapelocation[xCo][yCo].setFillColor(Color.black);
                maze.setCell(loc, MazeCell.UNEXPLORED);

            }
        }
    }


    /**
     * This method is to Get the x, y coordinate when touch the screen, and
     * determine which mode is the user in.
     *
     * @param x
     *            the x-cooperation that touched
     * @param y
     *            the y-cooperation that touched
     */
    public void onTouchDown(float x, float y)
    {
        this.processTouch(x, y);
    }


    /**
     * This method read the touch move x-, y-cooperations and pass into
     * processTouch(x, y) method to process the command.
     *
     * @param x
     *            the x-cooperation that touch moved
     * @param y
     *            the y-cooperation that touch moved
     */
    public void onTouchMove(float x, float y)
    {
        this.processTouch(x, y);
    }
}
