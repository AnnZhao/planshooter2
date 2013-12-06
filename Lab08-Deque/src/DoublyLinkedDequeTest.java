import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link DoublyLinkedDeque} class.
 *
 * @author So Hyun Jo (sohyun)
 * @author Zhenshu Zhao (zzhens7)
 * @version (2013/10/15)
 */
public class DoublyLinkedDequeTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    private Deque<String> deque;


    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public DoublyLinkedDequeTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp()
    {
        deque = new DoublyLinkedDeque<String>();
    }


    /**
     * this method test size.
     */
    public void testSize()
    {
        deque.size();
        assertEquals(0, deque.size());
    }


    /**
     * this method test front item.
     */
    public void testFrontItem()
    {
        deque.enqueueAtFront("1");
        assertEquals("1", deque.frontItem());
    }


    /**
     * this method test rear item.
     */
    public void testRearItem()
    {
        deque.enqueueAtRear("rear1");
        assertEquals("rear1", deque.rearItem());
    }


    /**
     * test the enqueueAtRear.
     */
    public void testenqueueAtRear()
    {
        deque.enqueueAtRear("1");
        deque.enqueueAtRear("2");

        assertEquals("1", deque.frontItem());
    }


    /**
     * test dequeueAtFront.
     */
    public void testdequeueAtFront()
    {
        deque.enqueueAtFront("1");
        deque.enqueueAtFront("2");
        deque.dequeueAtFront();
        assertEquals("1", deque.frontItem());
    }


    /**
     * test enqueueAtFront.
     */
    public void testenqueueAtFront()
    {
        deque.enqueueAtFront("1");
        deque.enqueueAtFront("2");
        assertEquals("2", deque.frontItem());
    }


    /**
     * test dequeueAtRear
     */
    public void testdequeueAtRear()
    {
        deque.enqueueAtFront("1");
        deque.dequeueAtRear();
        assertEquals(null, deque.frontItem());
    }


    /**
     * test clear method.
     */
    public void testClear()
    {
        deque.enqueueAtFront("1");
        deque.clear();
        assertEquals(0, deque.size());

    }


    /**
     * test toStirng method.
     */
    public void testtoString()
    {
        deque.enqueueAtFront("1");
        deque.enqueueAtFront("2");
        assertEquals(deque.toString(), "[2, 1, ]");
    }
}
