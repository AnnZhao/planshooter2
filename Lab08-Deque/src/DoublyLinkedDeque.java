// -------------------------------------------------------------------------
/**
 * A deque implemented using a doubly-linked chain with sentinel nodes at each
 * end.
 *
 * @param <T>
 *            The type of elements contained in the deque.
 * @author So Hyun Jo (sohyun)
 * @author Zhenshu Zhao (zzhens7)
 * @version (2013/10/15)
 */
public class DoublyLinkedDeque<T>
    implements Deque<T>
{
    // ~ Instance/static variables .............................................

    // A reference to the sentinel node at the beginning of the deque.
    private Node<T> head;

    // A reference to the sentinel node at the end of the deque.
    private Node<T> tail;

    // The number of elements in the deque.
    private int     size;


    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Construct the stack.
     */
    public DoublyLinkedDeque()
    {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.join(tail);

    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Insert a new item at the rear (the tail) of the deque.
     *
     * @param value
     *            the item to insert.
     * @postcondition [new-contents] == [old-contents] * [value]
     */
    public void enqueueAtRear(T value)
    {
        Node<T> new1 = new Node<T>(value);
        Node<T> old1 = tail.previous();
        old1.split();
        old1.join(new1);
        new1.join(tail);
        size++;

    }


    // ----------------------------------------------------------
    /**
     * Remove the item at the front (the head) of the deque.
     *
     * @return The item that was removed
     * @precondition |[old-contents]| > 0
     * @postcondition [old-contents] == [result] * [new-contents]
     */
    public T dequeueAtFront()
    {
        T new1 = head.next().data();
        Node<T> headNext = head.next();
        Node<T> headNextNext = headNext.next();
        head.split();
        headNext.split();
        head.join(headNextNext);
        size--;
        return new1;
    }


    // ----------------------------------------------------------
    /**
     * Insert a new item at the front (the head) of the deque.
     *
     * @param value
     *            the item to insert.
     * @postcondition [new-contents] = [value] * [old-contents]
     */
    public void enqueueAtFront(T value)
    {

        Node<T> new1 = new Node<T>(value);
        Node<T> old1 = head.split();
        new1.join(old1);
        head.join(new1);
        size++;
    }


    // ----------------------------------------------------------
    /**
     * Remove the item at the rear (the tail) of the deque.
     *
     * @return The item that was removed
     * @precondition |[old-contents]| > 0
     * @postcondition [old-contents] = [new-contents] * [result]
     */
    public T dequeueAtRear()
    {
        T new1 = tail.previous().data();
        Node<T> tailprevious = tail.previous();
        Node<T> pretailpre = tailprevious.previous();

        tailprevious.split();
        pretailpre.split();
        pretailpre.join(tail);
        size--;
        return new1;
    }


    // ----------------------------------------------------------
    /**
     * Get the item at the front (the head) of the deque. Does not alter the
     * deque.
     *
     * @return the item at the front of the deque.
     * @precondition |[contents]| > 0
     * @postcondition [new-contents] == [old-contents] and [contents] = [result]
     *                * [rest-of-items]
     */
    public T frontItem()
    {
        return head.next().data();
    }


    // ----------------------------------------------------------
    /**
     * Get the item at the rear (the tail) of the deque. Does not alter the
     * deque.
     *
     * @return the item at the rear of the deque.
     * @precondition |[contents]| > 0
     * @postcondition [new-contents] == [old-contents] and [contents] =
     *                [rest-of-items] * [result]
     */
    public T rearItem()
    {
        return tail.previous().data();
    }


    // ----------------------------------------------------------
    /**
     * Get the number of items in this deque. Does not alter the deque.
     *
     * @return The number of items this deque contains.
     * @postcondition result = |[contents]|
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Empty the deque.
     *
     * @postcondition [new-contents] = []
     */
    public void clear()
    {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.join(tail);
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of this deque. A deque's string
     * representation is written as a comma-separated list of its contents (in
     * front-to-rear order) surrounded by square brackets, like this:
     *
     * <pre>
     * [52, 14, 12, 119, 73, 80, 35]
     * </pre>
     * <p>
     * An empty deque is simply <code>[]</code>.
     * </p>
     *
     * @return a string representation of the deque
     */
    public String toString()
    {

        Node<T> current = head.next();
        String result = "";
        while (current != tail)
        {
            result = result + current.data().toString() + ", ";
            current = current.next();
        }

        result = "[" + result + "]";
        return result;
    }
}
