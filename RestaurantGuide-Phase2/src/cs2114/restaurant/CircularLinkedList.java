package cs2114.restaurant;

import java.util.Iterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 * This class is a circular doubly-linked list, which you will use later on to
 * store information about restaurants in Blacksburg.
 * 
 * @param <E>
 *            the type of element stored in the list
 * @author Zhenshu Zhao (zzhens7)
 * @version 2013.11.03
 */
@SuppressWarnings("unused")
public class CircularLinkedList<E>
    implements CircularList<E>
{
// ~ Fields ................................................................

    private int     size;
    private Node<E> currentNode;


// ~ Constructors ..........................................................

// ----------------------------------------------------------
// ----------------------------------------------------------
    /**
     * Create a new CircularLinkedList object.
     */
    public CircularLinkedList()
    {
        currentNode = null;
        size = 0;
    }


// ~ Public methods ........................................................

// ----------------------------------------------------------
    /**
     * this is a next method.
     */
    public void next()
    {
        if (size > 0)
        {
            currentNode = currentNode.next();
        }
    }


// ----------------------------------------------------------
    /**
     * this is a previous method.
     */
    public void previous()
    {
        if (size > 0)
        {
            currentNode = currentNode.previous();
        }
    }


// ----------------------------------------------------------
    /**
     * this method get current data.
     * 
     * @return current data
     */
    public E getCurrent()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException("It's Empty");
        }
        else
        {
            return currentNode.data();
        }
    }


// ----------------------------------------------------------
    /**
     * this method return the size.
     * 
     * @return the size for the list
     */
    public int size()
    {
        return size;
    }


// ----------------------------------------------------------
    /**
     * this is an add method.
     * 
     * @param item
     *            for the list
     */
    public void add(E item)
    {
        Node<E> addedNode = new Node<E>(item);
        if (size == 0)
        {
            currentNode = addedNode;
            currentNode.join(addedNode);
        }
        else
        {
            Node<E> prevNode = currentNode.previous();
            prevNode.split();
            prevNode.join(addedNode);
            addedNode.join(currentNode);
            currentNode = addedNode;
        }
        size++;
    }


// ----------------------------------------------------------
    /**
     * this is a removeCurrent method.
     * 
     * @return the removeNode from the list
     */
    public E removeCurrent()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("It's Empty");
        }
        else
        {
            E removeNode = currentNode.data();
            Node<E> preNode = currentNode.previous();
            preNode.split();
            currentNode = currentNode.split();
            preNode.join(currentNode);
            this.size--;
            return removeNode;
        }
    }


// ----------------------------------------------------------
    /**
     * this is a clear method.
     */
    public void clear()
    {
        currentNode = null;
        size = 0;
    }


// ----------------------------------------------------------
    /**
     * this is a toString method.
     * 
     * @return the rewrite answer for the list
     */
    public String toString()
    {
        Node<E> curr = currentNode;
        String result = "";

        if (size == 0)
        {
            return "[]";
        }
        else
        {
            for (int i = 0; i < size - 1; i++)
            {
                result += curr.data() + ", ";
                curr = curr.next();
            }
            result += curr.data();
        }
        return "[" + result + "]";
    }


// ----------------------------------------------------------
    /**
     * this is the iterator method.
     * 
     * @return the CircularLinkedListIterator for the list
     */
    public Iterator<E> iterator()
    {
        return new CircularLinkedListIterator();
    }


// ~ Inner classes .........................................................

// ----------------------------------------------------------
    /**
     * create an iterator to attach all the elements in the list.
     * 
     * @author Zhenshu Zhao (zzhens7)
     * @version 2013.11.04
     */
    private class CircularLinkedListIterator
        implements Iterator<E>
    {
        private Node<E> iter;
        private boolean round;


        /**
         * this method create a new CircularLinkedList object.
         */
        public CircularLinkedListIterator()
        {
            iter = currentNode;
            round = true;
        }


        // ~ Public methods ....................................................

        // ----------------------------------------------------------
        /**
         * this method create a hasNext method for the list.
         * 
         * @return true for the list false for the list
         */
        public boolean hasNext()
        {
            if (iter != null)
            {
                if (round)
                {
                    return true;
                }

                return iter != currentNode;
            }

            return false;
        }


        // ----------------------------------------------------------
        /**
         * this method create a E type next method for the list.
         * 
         * @return null for empty list the result of next data
         */
        public E next()
        {
            if (hasNext())
            {
                E result = iter.data();
                iter = iter.next();
                round = false;
                return result;
            }
            return null;
        }


        // ----------------------------------------------------------
        /**
         * this method create a remove method for the list.
         */
        public void remove()
        {
            throw new UnsupportedOperationException("It's Empty");
        }
    }
}
