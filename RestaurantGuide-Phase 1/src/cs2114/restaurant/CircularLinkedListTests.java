package cs2114.restaurant;

import java.util.NoSuchElementException;
import java.util.Iterator;

// -------------------------------------------------------------------------
/**
 * this class is tests for the CircularLinkedList class.
 *
 * @author <Zhenshu Zhao> (zzhens7)
 * @version 2013.11.04.
 */
@SuppressWarnings("unused")
public class CircularLinkedListTests
    extends student.TestCase
{
// ~ Fields ................................................................

    private CircularLinkedList<String> list;


// ~ Public methods ........................................................

// ----------------------------------------------------------
    /**
     * Creates a brand new, empty CircularLinkedList for each test method.
     */
    public void setUp()
    {
        list = new CircularLinkedList<String>();
    }


// ----------------------------------------------------------
    /**
     * Test methond for next.
     */
    public void testnext()
    {
        list.next();
        list.add("1");
        list.next();
        assertEquals("1", list.getCurrent());
        list.add("2");
        list.next();
        assertEquals("1", list.getCurrent());
        list.add("3");
        list.next();
        list.add("4");
        assertEquals("4", list.getCurrent());
    }


// ----------------------------------------------------------
    /**
     * Test methond for getcurrent
     */
    public void testGetCurrent()
    {
        Exception thrown = null;
        try
        {
            list.getCurrent();
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof NoSuchElementException);
        assertEquals("It's Empty", thrown.getMessage());

        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals(list.getCurrent(), "3");
    }


// ----------------------------------------------------------
    /**
     * Test methond for getprevious
     */
    public void testprevious()
    {
        list.previous();
        list.add("1");
        list.add("2");
        list.previous();
        assertEquals("1", list.getCurrent());

        list.previous();
        list.add("1");
        list.add("2");
        list.add("3");
        list.previous();
        assertEquals("1", list.getCurrent());
    }


    /**
     * Test methond for add
     */
    public void testadd()
    {
        assertEquals(0, list.size());
        list.add("1");
        list.add("2");
        assertEquals("2", list.getCurrent());
        assertEquals(2, list.size());
        list.add(null);
        assertEquals(3, list.size());
        assertNull(list.getCurrent());
    }


// ----------------------------------------------------------
    /**
     * Test methond for size
     */
    public void testsize()
    {
        list.add("1");
        assertEquals(1, list.size());
        list.add("2");
        assertEquals(2, list.size());
    }


// ----------------------------------------------------------
    /**
     * Test methond for removercurrent
     */
    public void testremoveCurrent()
    {

        Exception thrown = null;
        try
        {
            list.getCurrent();
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof NoSuchElementException);
        assertEquals("It's Empty", thrown.getMessage());

        list.add("1");
        list.add("2");
        list.add("3");
        list.removeCurrent();
        assertEquals("2", list.getCurrent());
    }


// ----------------------------------------------------------
    /**
     * Test methond for clear
     */
    public void testclear()
    {
        list.add("1");
        list.add("2");
        list.clear();
        assertEquals(0, list.size());
    }


// ----------------------------------------------------------
    /**
     * Test methond for toString
     */
    public void testtoString()
    {
        assertEquals("[]", list.toString());
        list.add("1");
        assertEquals("[1]", list.toString());
        list.add("2");
        list.add("3");
        assertEquals("[3, 2, 1]", list.toString());

    }


// ----------------------------------------------------------
    /**
     * Test methond for hasNext
     */
    public void testhasNext()
    {
        assertEquals(0, list.size());
        Iterator<String> test = list.iterator();
        test.next();
        assertFalse(test.hasNext());

        list.add("1");
        list.add("2");
        Iterator<String> test1 = list.iterator();
        assertTrue(test1.hasNext());
        assertEquals("2", list.getCurrent());

        list.add("2");
        list.add("3");
        list.removeCurrent();
        Iterator<String> test2 = list.iterator();
        assertTrue(test2.hasNext());
        assertEquals("2", list.getCurrent());

        list.add("1");
        Iterator<String> test3 = list.iterator();
        assertTrue(test3.hasNext());
        assertEquals("1", list.getCurrent());
    }


// ----------------------------------------------------------
    /**
     * Test methond for Enext
     */
    public void testEnext()
    {
        assertNull(list.iterator().next());

        list.add("1");
        Iterator<String> test = list.iterator();
        assertTrue(test.hasNext());
        assertEquals(list.getCurrent(), test.next());
        list.add("2");
        list.add("3");
        assertEquals("1", test.next());
    }


// ----------------------------------------------------------
    /**
     * Test methond for remove
     */
    public void testremove()
    {
        Iterator<String> test = list.iterator();

        Exception thrown = null;
        try
        {
            test.remove();
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof UnsupportedOperationException);
        assertEquals("It's Empty", thrown.getMessage());
    }

}
