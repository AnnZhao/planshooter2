package cs2114.demos.temperatures;

// -------------------------------------------------------------------------
/**
 * Unit tests for the TemperatureConverter class.
 *
 * Remember that testing is best performed in isolation whenever possible. The
 * model should be designed in such a way that it can be used independently of
 * the views and controllers in the application, so that we can test the model
 * without having to start the activity or interact with the GUI.
 *
 * When you're testing a class that doesn't involve an Android activity or GUI
 * interaction (such as your model classes), you should extend the
 * {@code student.TestCase} class, NOT {@code student.AndroidTestCase}.
 *
 * @author  Tony Allevato
 * @version 2011.07.03
 */
public class TemperatureConverterTest extends student.TestCase
{
    //~ Static/instance variables .............................................

    // The model used for testing.
    private TemperatureConverter converter;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * The setUp method is called before each test method below in order to
     * start each test with fresh copies of the objects being tested. 
     */
    public void setUp()
    {
    	converter = new TemperatureConverter();
    }


    // ----------------------------------------------------------
    /**
     * Tests that the Celsius to Fahrenheit conversion works properly.
     */
    public void testCelsiusToFahrenheit()
    {
    	converter.setCelsius(37.0);
    	
    	// Since we're comparing doubles, we use the three-argument form of
    	// assertEquals that takes a "tolerance".

        assertEquals(98.6, converter.getFahrenheit(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests that the Fahrenheit to Celsius conversion works properly.
     */
    public void testFahrenheitToCelsius()
    {
    	converter.setFahrenheit(98.6);
        assertEquals(37.0, converter.getCelsius(), 0.01);
    }
}
