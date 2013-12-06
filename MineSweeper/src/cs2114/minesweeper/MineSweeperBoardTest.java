package cs2114.minesweeper;
import sofia.util.Random;
/**
 * // -------------------------------------------------------------------------
/**
 *  This programming project is to test the Mine sweeper board.
 *  @author Zhenshu Zhao (zzhens7)
 *  @version 2013-9-17
 */
public class MineSweeperBoardTest extends student.TestCase
{
    private MineSweeperBoard board1;
    private MineSweeperBoard board2;
    /**
     *
     */
    public void setUp()
    {
        board1 = new MineSweeperBoard(4, 4, 2);
        board2 = new MineSweeperBoard(4, 4, 2);
    }


    /**
     * this method is to test the constructor.
     */
    public void testMineSweeperBoard()
    {
        Random.setNextInts(1, 2, 1, 2);

        MineSweeperBoard board = new MineSweeperBoard(4, 4, 2);
        assertEquals(board.getCell(1, 2), MineSweeperCell.MINE);
        Random.setNextInts(1, 2);
        assertEquals(board.getCell(1, 2), MineSweeperCell.MINE);


    }

    /**
     * this method test the constructor.
     * @param theBoard the new MineSweerBoard Object
     * @param expected the input string row
     */
    public void assertBoard(MineSweeperBoard theBoard, String... expected)
    {
        MineSweeperBoard expectedBoard =
            new MineSweeperBoard(expected[0].length(), expected.length, 0);
        expectedBoard.loadBoardState(expected);
        assertEquals(expectedBoard, theBoard);
        // uses equals() from MineSweeperBoardBase
    }


    // ----------------------------------------------------------
    /**
     * test the setCell() method.
     */
    public void testFlagCell()
    {
        board1.loadBoardState("    ",
            "OOOO",
            "O++O",
            "OOOO");
        board1.flagCell(1, 2);
        assertBoard(board1, "    ",
            "OOOO",
            "OM+O",
            "OOOO");
        board1.flagCell(1, 1);
        assertBoard(board1, "    ",
            "OFOO",
            "OM+O",
            "OOOO");
        board1.flagCell(1, 2);
        assertBoard(board1, "    ",
            "OFOO",
            "O++O",
            "OOOO");
        board1.flagCell(1, 1);
        assertBoard(board1, "    ",
            "OOOO",
            "O++O",
            "OOOO");
        board1.flagCell(-1, 5);
        assertEquals(MineSweeperCell.INVALID_CELL,
            board1.getCell(-1, 5));
    }

    /**
     * test the height.
     */
    public void testHeight()
    {
        board1.loadBoardState("    ",
            "OOOO",
            "O++O",
            "OOOO");
        assertEquals(board1.height(), 4);
    }
    /**
     * test the width
     */
    public void testWidth()
    {
        board1.loadBoardState("    ",
            "OOOO",
            "O++O",
            "OOOO");
        assertEquals(board1.width(), 4);
    }
    /**
     * test the game is lost.
     */
    public void testIsGameLost()
    {
        board1.loadBoardState("    ",
            "OOOO",
            "O++O",
            "OOOO");
        board1.uncoverCell(2, 2);
        assertEquals(board1.isGameLost(), true);
        board1.isGameWon();
    }

    /**
     * test the game is won.
     */
    public void testIsGameWon()
    {
        board1.loadBoardState("    ",
            "1221",
            "1++O",
            "1221");
        board1.flagCell(1, 2);
        board1.flagCell(2, 2);
        assertEquals(board1.isGameWon(), false);
        board1.isGameLost();
        board1.loadBoardState("    ",
            "1221",
            "1MM1",
            "1221");
        assertEquals(board1.isGameWon(), true);
    }

    /**
     * test the number of adjacent mines.
     */
    public void testNumberOfAdjacentMines()
    {
        board1.loadBoardState("    ",
                                   "1221",
                                   "1++1",
                                   "1221");
        assertEquals(board1.numberOfAdjacentMines(1, 1), 2);
    }

    /**
     * test the get cell method.
     */
    public void testGetCell()
    {
        board1.loadBoardState("    ",
            "OOOO",
            "O++O",
            "OOOO");
        assertEquals(board1.getCell(1, 1), MineSweeperCell.COVERED_CELL);
        assertEquals(board1.getCell(-1, 5), MineSweeperCell.INVALID_CELL);
        board1.setCell(-1, 5, MineSweeperCell.INVALID_CELL);
        assertBoard(board1, "    ",
            "OOOO",
            "O++O",
            "OOOO");

    }

    /**
     * This method test the heigth method.
     */
    public void testEqual()
    {
        board1.loadBoardState("    ",
            "OOOO",
            "O++O",
            "OOOO");
        board2.loadBoardState("    ",
            "OOOO",
            "O++O",
            "OOOO");
        assertEquals(board1, board2);
    }


    /**
     * test the reveal board method.
     */
    public void testRevealBoard()
    {
        board1.loadBoardState("    ",
                             "FOOO",
                             "OM+O",
                             "OOOO");
        board1.revealBoard();
        assertBoard(board1, "    ",
                           "1221",
                           "1**1",
                           "1221");
        board1.uncoverCell(1, 0);
    }


    /**
     * test the set cell method.
     */
    public void testSetCell()
    {
        board1.loadBoardState("    ",
            "OOOO",
            "O++O",
            "OOOO");

        board1.setCell(1, 2, MineSweeperCell.FLAGGED_MINE);

        assertBoard(board1, "    ",
                                 "OOOO",
                                 "OM+O",
                                 "OOOO");
        board1.setCell(-1, 5, MineSweeperCell.INVALID_CELL);
        assertEquals(MineSweeperCell.INVALID_CELL,
            board1.getCell(-1, 5));

    }

    /**
     * test the uncover all the cell method.
     */
    public void testUncoverCell()
    {
        board1.loadBoardState("    ",
            "OOOO",
            "O++O",
            "OOOO");
        board1.uncoverCell(3, 2);
        assertBoard(board1, "    ",
            "OOOO",
            "O++1",
            "OOOO");
        board1.uncoverCell(1, 2);
        assertBoard(board1, "    ",
            "OOOO",
            "O*+1",
            "OOOO");
        board1.uncoverCell(-1, 0);
        assertBoard(board1, "    ",
            "OOOO",
            "O*+1",
            "OOOO");
    }
}
