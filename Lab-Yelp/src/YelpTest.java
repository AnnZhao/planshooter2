import realtimeweb.yelp.exceptions.BusinessSearchException;

/**
 * // -------------------------------------------------------------------------
 * /** Write a one-sentence summary of your class here. Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Ann
 * @version 2013-11-8
 */
public class YelpTest
    extends student.TestCase
{
    private Yelp yelp;


    /**
     * Sets up the tests
     */

    public void setUp()
    {
        yelp = new Yelp();
    }


    /**
     * Tests Yelp methods (calls empty methods to show that they do nothing)
     */

    public void testProcessBusinesses()
    {
        yelp.businessDataFailed(new BusinessSearchException("", "", ""));
        yelp.businessSearchFailed(new BusinessSearchException("", "", ""));
        yelp.processBusinesses();
        assertEquals(1, yelp.perfectBusinesses().size());
    }
}
