import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link ArrayStack} class.
 *
 * @author Partner 1's name (pid)
 * @author Partner 2's name (pid)
 * @version (place the date here, in this format: yyyy.mm.dd)
 */
public class ArrayStackTest
    extends TestCase
{
    //~ Instance/static variables .............................................

    private Stack<String> stack;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public ArrayStackTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new ArrayStack<String>();
    }

    // ----------------------------------------------------------
    /**
     * Test the push() method.
     */
    public void testPush()
    {
        stack.push("hello");
        assertEquals(1, stack.size());
        assertEquals("hello", stack.top());

        stack.push("goodbye");
        assertEquals(2, stack.size());
        assertEquals("goodbye", stack.top());
    }


    // ----------------------------------------------------------
    /**
     * Test the pop() method.
     */
    public void testPop()
    {
        String word = "hello";
        stack.push(word);
        assertEquals(1, stack.size());

        stack.pop();

        // After removal, make sure the inserted object is no longer there.
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test the topAndPop() method.
     */
    public void testTopAndPop()
    {
        String word = "hello";
        stack.push(word);

        // Use assertSame() to ensure the specific object added is the
        // one returned here
        assertSame(word, stack.topAndPop());

        // After removal, make sure the inserted object is no longer there.
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test clear() with multiple values in the stack.
     */
    public void testRemove3()
    {
        String word1 = "hello";
        stack.push(word1);
        String word2 = "goodbye";
        stack.push(word2);
        assertEquals(2, stack.size());

        stack.clear();
        assertEquals(0, stack.size());
    }

}
