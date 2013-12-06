//-------------------------------------------------------------------------
/**
 * Represents a binary tree of arbitrary structure.  This class is different
 * from those in the textbook.  It does not use a separate node class.
 *
 * @param <E> The type of data elements contained in the tree.
 *
 * @author  John Lewis (lewis63) and Stephen Edwards (stedwar2)
 * @author  Your name (pid)
 * @version (place the date here, in this format: yyyy.mm.dd)
 */
public class BinaryTree<E>
{
    //~ Instance/static variables .............................................

    private E element;
    private BinaryTree<E> left;
    private BinaryTree<E> right;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a single binary tree node containing the
     * given element and no children.
     * @param value The data element to store in the new tree node.
     */
    public BinaryTree(E value)
    {
        // TODO: remove this throw statement when you implement this
        throw new UnsupportedOperationException(
            "You have not implemented the BinaryTree(T) "
            + "constructor yet");
    }


    // ----------------------------------------------------------
    /**
     * Creates a single binary tree node containing the given
     * element and child subtrees.
     * @param value The data value to store on the new node.
     * @param leftChild  A reference to the left child for the new node.
     * @param rightChild A reference to the right child for the new node.
     */
    public BinaryTree(
        E value, BinaryTree<E> leftChild, BinaryTree<E> rightChild)
    {
        // TODO: remove this throw statement when you implement this
        throw new UnsupportedOperationException(
            "You have not implemented the "
            + "BinaryTree(T, BinaryTree, BinaryTree) constructor yet");
    }


    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Get the data element in this node (i.e., stored at the root of
     * this tree).
     * @return This node's data element
     */
    public E getElement()
    {
        return element;
    }


    // ----------------------------------------------------------
    /**
     * Sets the data element in this node (i.e., store it at the root of
     * this tree).
     * @param value The new data value to store in this node
     */
    public void setElement(E value)
    {
        // TODO: remove this throw statement when you implement this method
        throw new UnsupportedOperationException(
            "You have not implemented setElement() yet");
    }


    // ----------------------------------------------------------
    /**
     * Get the left child of this node.
     * @return This node's left child, or null if none.
     */
    public BinaryTree<E> getLeft()
    {
        return left;
    }


    // ----------------------------------------------------------
    /**
     * Sets the left child of this node.
     * @param subtree A reference to the new left child for this node.
     */
    public void setLeft(BinaryTree<E> subtree)
    {
        left = subtree;
    }


    // ----------------------------------------------------------
    /**
     * Get the right child of this node.
     * @return This node's right child, or null if none.
     */
    public BinaryTree<E> getRight()
    {
        return right;
    }


    // ----------------------------------------------------------
    /**
     * Sets the right child of this node.
     * @param subtree A reference to the new right child for this node.
     */
    public void setRight(BinaryTree<E> subtree)
    {
        right = subtree;
    }


    // ----------------------------------------------------------
    /**
     * Calculate the size of this binary tree.
     * @return The size of this tree.
     */
    public int size()
    {
        // TODO: remove this throw statement when you implement this method
        throw new UnsupportedOperationException(
            "You have not implemented size() yet");
    }


    // ----------------------------------------------------------
    /**
     * Calculate the height of this binary tree.
     * @return The height of this tree.
     */
    public int height()
    {
        // TODO: remove this throw statement when you implement this method
        throw new UnsupportedOperationException(
            "You have not implemented height() yet");
    }


    // ----------------------------------------------------------
    /**
     * Produce a copy of this entire tree.  The copy will contain
     * duplicates of all of the nodes in this tree, but will share
     * references to the same data values (i.e., this tree's node structure
     * is duplicated, but the data elements stored in the nodes are not).
     * @return A reference to a brand new duplicate of this tree.
     */
    public BinaryTree<E> clone()
    {
        BinaryTree<E> copy = new BinaryTree<E>(element);

        if (left != null)
        {
            // If there's a left subtree, duplicate it and attach to the copy
            copy.left = left.clone();
        }
        if (right != null)
        {
            // If there's a right subtree, duplicate it and attach to the copy
            copy.right = right.clone();
        }
        return copy;    // Return resulting tree
    }


    // ----------------------------------------------------------
    /**
     * Generate a string containing the "printed version" of this binary
     * tree using a pre-order traversal.  The tree's contents are printed
     * as a parenthesized list.  See {@link #toPostOrderString()} for an
     * example.
     * @return a printable representation of this tree's contents, using
     *         a pre-order traversal.
     */
    public String toPreOrderString()
    {
        // TODO: remove this throw statement when you implement this method
        throw new UnsupportedOperationException(
            "You have not implemented toPreOrderString() yet");
    }


    // ----------------------------------------------------------
    /**
     * Generate a string containing the "printed version" of this binary
     * tree using a in-order traversal.  The tree's contents are printed as
     * a parenthesized list.  See {@link #toPostOrderString()} for an example.
     * @return a printable representation of this tree's contents, using
     *         an in-order traversal.
     */
    public String toInOrderString()
    {
        // TODO: remove this throw statement when you implement this method
        throw new UnsupportedOperationException(
            "You have not implemented toInOrderString() yet");
    }


    // ----------------------------------------------------------
    /**
     * Generate a string containing the "printed version" of this binary
     * tree using a post-order traversal.  The tree's contents are printed
     * as a parenthesized list.  For example, if a tree containing the data
     * value A has a left child containing B and a right child containing C,
     * it would be printed as ((B) (C) A).  The parentheses directly reflect
     * the structure of each node in the tree.
     * @return a printable representation of this tree's contents, using
     *         a post-order traversal.
     */
    public String toPostOrderString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        if (left != null)
        {
            builder.append(left.toPostOrderString());
            // Add a space before the next element
            builder.append(" ");
        }
        if (right != null)
        {
            builder.append(right.toPostOrderString());
            // Add a space before the next element
            builder.append(" ");
        }
        builder.append(element);
        builder.append(")");

        return builder.toString();
    }
}
