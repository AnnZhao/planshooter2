import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link Node} class.
 *
 * @author  Your name (pid)
 * @version (place the date here, in this format: yyyy.mm.dd)
 */
public class NodeTest
    extends TestCase
{
    //~ Fields ................................................................

    // TODO: Depending on how you test, you might need more, or fewer, of
    // these.
    private Node<String> node1;
    private Node<String> node2;
    private Node<String> node3;


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Create some new nodes for each test method.
     */
    public void setUp()
    {
        node1 = new Node<String>("node1");
        node2 = new Node<String>("node2");
        node3 = new Node<String>("node3");
    }


    // TODO Add your own test methods here.
}
