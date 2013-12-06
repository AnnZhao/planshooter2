import student.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** This is the test class for binarytree.
 *
 * @author Zhenshu Zhao(zzhens7)
 * @version 2013-11-21
 */
public class BinaryTreeTest
    extends TestCase

{
    private BinaryTree<String> tree;


    // ----------------------------------------------------------

    /**
     * Set up
     */
    public void setUp()
    {
        tree = new BinaryTree<String>("1");
    }


    /**
     * test get element
     */
    public void testGetElement()
    {
        assertEquals(tree.getElement(), "1");
    }


    /**
     * test set element
     */
    public void testSetElement()
    {
        tree.setElement("a");
        assertEquals(tree.getElement(), "a");
    }


    /**
     * test get set left
     */
    public void testGetSetLeft()
    {
        assertNull(tree.getLeft());

        BinaryTree<String> left = new BinaryTree<String>("b");
        tree.setLeft(left);
        assertEquals(tree.getLeft(), left);
    }


    /**
     * Test get set right
     */
    public void testGetSetRight()
    {
        assertNull(tree.getRight());

        BinaryTree<String> right = new BinaryTree<String>("b");
        tree.setRight(right);
        assertEquals(tree.getRight(), right);
    }


    /**
     * Test size
     */
    public void testSize()
    {
        assertEquals(1, tree.size());

        BinaryTree<String> left = new BinaryTree<String>("b");
        tree.setLeft(left);
        assertEquals(2, tree.size());

        BinaryTree<String> right = new BinaryTree<String>("b");
        tree.setRight(right);
        assertEquals(3, tree.size());
    }


    /**
     * Test height
     */
    public void testHeight()
    {
        assertEquals(1, tree.height());

        BinaryTree<String> left = new BinaryTree<String>("b");
        tree.setLeft(left);
        assertEquals(2, tree.height());

        BinaryTree<String> right = new BinaryTree<String>("b");
        tree.setRight(right);
        assertEquals(2, tree.height());

        BinaryTree<String> left1 = new BinaryTree<String>("b");
        tree.getLeft().setLeft(left1);
        assertEquals(3, tree.height());
    }


    /**
     * test clone
     */
    public void testClone()
    {
        assertEquals(tree.clone().getElement(), tree.getElement());

        BinaryTree<String> left = new BinaryTree<String>("b");
        tree.setLeft(left);
        assertEquals(tree.clone().getElement(), tree.getElement());
        assertEquals(tree.clone().getLeft().getElement(), tree.getLeft()
            .getElement());

        BinaryTree<String> right = new BinaryTree<String>("b");
        tree.setRight(right);
        assertEquals(tree.clone().getElement(), tree.getElement());
        assertEquals(tree.clone().getRight().getElement(), tree.getRight()
            .getElement());
    }


    /**
     * test to pre order string
     */
    public void testToPreOrderString()
    {
        assertEquals("(1)", tree.toPreOrderString());

        BinaryTree<String> left = new BinaryTree<String>("2");
        tree.setLeft(left);
        assertEquals("(1 (2))", tree.toPreOrderString());

        BinaryTree<String> right = new BinaryTree<String>("3");
        tree.setRight(right);
        assertEquals("(1 (2) (3))", tree.toPreOrderString());
    }


    /**
     * Test to in order string
     */
    public void testToInOrderString()
    {
        assertEquals("(1)", tree.toInOrderString());

        BinaryTree<String> left = new BinaryTree<String>("2");
        tree.setLeft(left);
        assertEquals("((2) 1)", tree.toInOrderString());

        BinaryTree<String> right = new BinaryTree<String>("3");
        tree.setRight(right);
        assertEquals("((2) 1 (3))", tree.toInOrderString());
    }


    /**
     * Test to post order string
     */
    public void testToPostOrderString()
    {
        assertEquals("(1)", tree.toPostOrderString());

        BinaryTree<String> left = new BinaryTree<String>("2");
        tree.setLeft(left);
        assertEquals("((2) 1)", tree.toPostOrderString());

        BinaryTree<String> right = new BinaryTree<String>("3");
        tree.setRight(right);
        assertEquals("((2) (3) 1)", tree.toPostOrderString());
    }

}
