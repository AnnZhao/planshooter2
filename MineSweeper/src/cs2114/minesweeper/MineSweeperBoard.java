package cs2114.minesweeper;
import sofia.util.Random;
/**
 * // -------------------------------------------------------------------------
/**
 *  This programming project is implementing the playing board for Mine Sweeper.
 *  The game makes use of the Model/View/Controller design pattern
 *  (MVC) that will be covered in class.
 *  @author Zhenshu Zhao (zzhens7)
 *  @version 2013-9-17
 */
public class MineSweeperBoard extends MineSweeperBoardBase
{
    private int height;
    private int width;
    private MineSweeperCell[][] mineBoard;
    /**
     * define the int gameLost
     */
    boolean gameLost1;

    /**
     * initializes a Mine sweeper board object with all properties specified.
     * @param width is width
     * @param height is height
     * @param mine is mine
     */
    public MineSweeperBoard(int width, int height, int mine)
    {
        this.width = width;
        this.height = height;
        Random regn = new sofia.util.Random();
        mineBoard = new MineSweeperCell[width][height];
        for (int t = 0; t < width; t++)
        {
            for (int p = 0; p < height; p++)
            {
                mineBoard[t][p] = MineSweeperCell.COVERED_CELL;
            }
        }
        int counter = 0;
        while (counter < mine)
        {
            int wit1 = regn.nextInt(width);
            int hit1 = regn.nextInt(height);
            if (getCell(wit1, hit1) != MineSweeperCell.MINE)
            {
                mineBoard[wit1][hit1] = MineSweeperCell.MINE;
                counter++;
            }
        }

    }

    /**
     * This method set the cell of the mine sweeper board.
     * @param x is the height
     * @param y is the width
     * @param value is the number of cell
     */
    protected void setCell(int x, int y, MineSweeperCell value)
    {
        if (getCell(x, y) != MineSweeperCell.INVALID_CELL)
        {
            mineBoard[x][y] = value;
        }
    }

    /**
     * This method get the cell of the mine sweeper board.
     * @param x is height
     * @param y is the width
     * @return MineBoard[x][y]
     */

    public MineSweeperCell getCell(int x, int y)
    {
        if (x >= 0 && x < width && y >= 0 && y < height)
        {
            return mineBoard[x][y];
        }
        else
        {
            return MineSweeperCell.INVALID_CELL;
        }
    }

    /**
     * This method flag all the cell.
     * @param x is height
     * @param y is the width
     */
    public void flagCell(int x, int y)
    {

        if (getCell(x, y) == MineSweeperCell.MINE)
        {
            mineBoard[x][y] = MineSweeperCell.FLAGGED_MINE;
        }
        else if (getCell(x, y) == MineSweeperCell.COVERED_CELL)
        {
            mineBoard[x][y] = MineSweeperCell.FLAG;
        }
        else if (getCell(x, y) == MineSweeperCell.FLAG)
        {
            mineBoard[x][y] = MineSweeperCell.COVERED_CELL;
        }
        else if (getCell(x, y) == MineSweeperCell.FLAGGED_MINE)
        {
            mineBoard[x][y] = MineSweeperCell.MINE;
        }
    }

    /**
     * This method return the height of the board.
     * @return MineBoard.length
     */
    public int height()
    {
        return mineBoard.length;
    }

    /**
     * This method return the width of the board.
     * @return MineBoard[0].length
     */
    public int width()
    {
        return mineBoard[0].length;
    }

    /**
     * This method count the number of adjacent mines.
     * @param x is the height
     * @param y is the width
     * @return count is the number of adjacent mines
     *
     */
    public int numberOfAdjacentMines(int x, int y)
    {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++)
        {
            for (int j = y - 1; j <= y + 1; j++)
            {
                if (getCell(i, j) == MineSweeperCell.MINE ||
                    getCell(i, j) == MineSweeperCell.UNCOVERED_MINE ||
                    getCell(i, j) == MineSweeperCell.FLAGGED_MINE)
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * This method is to uncover the cell.
     * @param x is height
     * @param y is width
     */
    public void uncoverCell(int x, int y)
    {
        if (getCell(x, y) != MineSweeperCell.INVALID_CELL)
        {
            int numOfAM;
            if (getCell(x, y) == MineSweeperCell.MINE)
            {
                mineBoard[x][y] = MineSweeperCell.UNCOVERED_MINE;
                gameLost1 = true;
            }
            if (getCell(x, y) == MineSweeperCell.COVERED_CELL)
            {
                numOfAM = numberOfAdjacentMines(x, y);
                mineBoard[x][y] = MineSweeperCell.adjacentTo(numOfAM);
            }
        }
    }

    /**
     * This method is to reveal the board.
     *
     */
    public void revealBoard()
    {
        int numOfAM1;
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                if (getCell(i, j) == MineSweeperCell.FLAGGED_MINE)
                {
                    mineBoard[i][j] = MineSweeperCell.UNCOVERED_MINE;
                }
                if (getCell(i, j) == MineSweeperCell.FLAG ||
                    getCell(i, j) == MineSweeperCell.COVERED_CELL)
                {
                    numOfAM1 = numberOfAdjacentMines(i, j);
                    mineBoard[i][j] = MineSweeperCell.adjacentTo(numOfAM1);
                }
                if (getCell(i, j) == MineSweeperCell.MINE)
                {
                    mineBoard[i][j] = MineSweeperCell.UNCOVERED_MINE;
                }
            }
        }
    }

    /**
     * This method is to check if the game is won.
     * @return gameWon
     */
    public boolean isGameWon()
    {
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                if (getCell(x, y) == MineSweeperCell.COVERED_CELL ||
                    getCell(x, y) == MineSweeperCell.MINE ||
                    getCell(x, y) == MineSweeperCell.FLAG)
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method is to check if the game is lost.
     * @return gameLost1 is game lost
     */
    public boolean isGameLost()
    {
        return gameLost1;
    }
}


