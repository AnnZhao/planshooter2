import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link Node} class.
 *
 * @author Zhenshu Zhao (zzhens7) Hangxin Liu(liuhx)
 * @version (2013.10.04)
 */
public class NodeTest
    extends TestCase
{
    // ~ Fields ................................................................

    private Node<String> node1;
    private Node<String> node2;
    private Node<String> node3;
    private Node<String> node4;


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Create some new nodes for each test method.
     */
    public void setUp()
    {
        node1 = new Node<String>("node1");
        node2 = new Node<String>("node2");
        node3 = new Node<String>("node3");
        node4 = null;
    }


    /**
     * test join
     */
    public void testJoin()
    {
        Exception thrown = null;
        try
        {
            node1.join(node2);
            node1.join(node3);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }

        assertTrue(thrown instanceof IllegalStateException);
        assertNotNull(thrown);

        node3.join(node4);
        assertNull(node3.next());
    }


    /**
     * test join
     */
    public void testJoin1()
    {

        Exception thrown = null;
        try
        {
            node1.join(node2);
            node3.join(node2);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalStateException);
        assertNotNull(thrown);
    }


    /**
     * test split
     */
    public void testSplit()
    {
        node1.join(node2.join(node3));
        Node<String> nodeReturn = node2.split();
        assertNull(node2.next());
        assertEquals(nodeReturn, node3);
        node1.previous();
    }
}

