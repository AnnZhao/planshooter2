import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test cases for the Levenshtein distance algorithm.
 *
 * @author Zhenshu Zhao (zzhens7), YuSheng Zhang (yusheng)
 * @version 2013.11.15
 */
public class LevenshteinTests
    extends TestCase
{
// ~ Public methods ..................................................
// ----------------------------------------------------------
    /**
     * Test case for base
     */
    public void testBase()
    {
        Levenshtein lev = new Levenshtein("c", "");
        assertEquals(1, lev.distance());
    }


// ----------------------------------------------------------
    /**
     * Test case for base2
     */
    public void testBase2()
    {
        Levenshtein lev = new Levenshtein("", "c");
        assertEquals(1, lev.distance());
    }


// ----------------------------------------------------------
    /**
     * Test case for base3
     */
    public void testBase3()
    {
        Levenshtein lev = new Levenshtein("", "");
        assertEquals(0, lev.distance());
    }


// ----------------------------------------------------------
    /**
     * Test case for short String.
     */
    public void testShortString()
    {
        Levenshtein lev = new Levenshtein("clap", "clap");
        assertEquals(0, lev.distance());
    }


// ----------------------------------------------------------
    /**
     * Test case for short String2.
     */
    public void testShortString2()
    {
        Levenshtein lev = new Levenshtein("clap", "cram");
        assertEquals(2, lev.distance());
    }


// ----------------------------------------------------------
    /**
     * Test case for short String3.
     */
    public void testShortString3()
    {
        Levenshtein lev = new Levenshtein("mitt", "smitten");
        assertEquals(3, lev.distance());
    }


// ----------------------------------------------------------
    /**
     * Test case for short String4.
     */
    public void testShortString4()
    {
        Levenshtein lev = new Levenshtein("start", "cart");
        assertEquals(2, lev.distance());
    }
}
