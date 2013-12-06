import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link ListBasedBag} class.
 *
 * @author Partner 1's name (pid)
 * @author Partner 2's name (pid)
 * @version (place the date here, in this format: yyyy.mm.dd)
 */
public class ListBasedBagTest
    extends TestCase
{
    //~ Instance/static variables .............................................

    private ListBasedBag<Book> bag1;
    private Book book1;
    private Book book2;
    private ListBasedBag<String> bag2;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public ListBasedBagTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty bag and a new 6-sided die as the test
     * fixture for each test method.
     */
    public void setUp()
    {
        bag1 = new ListBasedBag<Book>();
        book1 = new Book(
            "Data Structures: Abstraction and Design Using Java",
            "Elliot B. Koffman and Paul A. T. Wolfgang",
            "978-0-470-12870-1");
        book2 = new Book(
            "Data Structures and Problem Solving Using Java",
            "Mark Allen Weiss",
            "0321541405");
        bag2 = new ListBasedBag<String>();
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#ListBasedBag()}.
     */
    public void testArrayBag()
    {
        // Check that a new bag is empty

        // Initially, its size should be zero
        assertEquals(0, bag1.size());

        // It shouldn't contain our test die
        assertFalse(bag1.contains(book1));

        // If we try to pull out an element, nothing should come out
        assertNull(bag1.removeRandom());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#add(java.lang.Object)}.
     */
    public void testAdd()
    {
        fail("Not yet implemented");
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#remove(java.lang.Object)}.
     */
    public void testRemove()
    {
        fail("Not yet implemented");
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#removeRandom()}.
     */
    public void testRemoveRandom()
    {
        fail("Not yet implemented");
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#contains(java.lang.Object)}.
     */
    public void testContains()
    {
        fail("Not yet implemented");
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#isEmpty()}.
     */
    public void testIsEmpty()
    {
        fail("Not yet implemented");
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#size()}.
     */
    public void testSize()
    {
        fail("Not yet implemented");
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#toString()}.
     */
    public void testToString()
    {
        fail("Not yet implemented");
    }

}
