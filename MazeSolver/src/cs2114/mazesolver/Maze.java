package cs2114.mazesolver;

import java.util.Stack;

/**
 * This class implements the ILocation that gets the location.
 *
 * @author Zhenshu Zhao
 * @version 2013.10.04
 */
public class Maze
    implements IMaze
{

    private int          size;
    private MazeCell[][] cell;
    private Location     startpoint;
    private Location     goallocation;


    /**
     * create the maze.
     *
     * @param size
     *            is the size of maze
     */
    public Maze(int size)
    {
        this.size = size;
        cell = new MazeCell[size][size];
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                cell[x][y] = MazeCell.UNEXPLORED;
            }
        }
        startpoint = new Location(0, 0);
        goallocation = new Location(size - 1, size - 1);
    }


    /**
     * get the cell.
     *
     * @param location
     *            is the location of the cell
     * @return maze is maze
     */
    public MazeCell getCell(ILocation location)
    {
        if (location.x() >= size || location.x() < 0 || location.y() >= size
            || location.y() < 0)
        {
            return MazeCell.INVALID_CELL;
        }
        else
        {
            return cell[location.x()][location.y()];
        }
    }


    /**
     * set cell.
     *
     * @param location
     *            is the location of the cell
     * @param maze
     *            is the maze
     */
    public void setCell(ILocation location, MazeCell maze)
    {
        if (getCell(location) != MazeCell.INVALID_CELL
            && (!(location.equals(startpoint) || location.equals(goallocation))
                || maze != MazeCell.WALL))
        {
            cell[location.x()][location.y()] = maze;
        }
    }


    /**
     * get start location.
     *
     * @return start's location
     */
    public ILocation getStartLocation()
    {
        return startpoint;
    }


    /**
     * set the location of start.
     *
     * @param location
     *            is the location
     */
    public void setStartLocation(ILocation location)
    {
        if (getCell(location) != MazeCell.INVALID_CELL)
        {
            if (getCell(location) == MazeCell.WALL)
            {
                cell[location.x()][location.y()] = MazeCell.UNEXPLORED;
            }
            startpoint = (Location)location;
        }
    }


    /**
     * get goal location.
     *
     * @return goal's location
     */
    public ILocation getGoalLocation()
    {
        return goallocation;
    }


    /**
     * set the location of goal.
     *
     * @param location
     *            is the location
     */
    public void setGoalLocation(ILocation location)
    {
        if (getCell(location) != MazeCell.INVALID_CELL)
        {
            if (getCell(location) == MazeCell.WALL)
            {
                cell[location.x()][location.y()] = MazeCell.UNEXPLORED;
            }
            goallocation = (Location)location;
        }
    }


    /**
     * return the size of maze.
     *
     * @return size as the maze's size
     */
    public int size()
    {
        return this.size;
    }


    /**
     * solver method.
     *
     * @return string as the solution
     */
    public String solve()
    {
        Stack<Location> path = new Stack<Location>();
        String solution1 = "";
        path.push(startpoint);
        Location current = path.peek();
        this.setCell(current, MazeCell.CURRENT_PATH);

        while (!current.equals(goallocation))
        {
            boolean fail = false;
            if (this.getCell(current.south()) == MazeCell.UNEXPLORED)
            {
                current = current.south();
            }
            else if (this.getCell(current.east()) == MazeCell.UNEXPLORED)
            {
                current = current.east();
            }
            else if (this.getCell(current.north()) == MazeCell.UNEXPLORED)
            {
                current = current.north();
            }
            else if (this.getCell(current.west()) == MazeCell.UNEXPLORED)
            {
                current = current.west();
            }
            else
            {
                fail = true;
                this.setCell(path.pop(), MazeCell.FAILED_PATH);
                if (path.size() == 0)
                {
                    return null;
                }
                current = path.peek();
            }
            if (!fail)
            {
                path.push(current);
                this.setCell(current, MazeCell.CURRENT_PATH);
            }
        }

        while (!path.isEmpty())
        {
            solution1 = path.pop().toString() + solution1;
        }

        return solution1;
    }
}
