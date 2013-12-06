package cs2114.demos.temperatures;

import android.widget.Button;
import android.widget.EditText;

// -------------------------------------------------------------------------
/**
 * An example test case that shows how to test a custom screen class. Note
 * that this test case is not intended to be complete. Instead, it provides
 * an example of just one test method, nothing more. A real test set for the
 * activity would probably exercise all of its features more completely.
 *
 * @author  Tony Allevato
 * @version 2012.08.30
 */
public class TemperatureScreenTest
    extends student.AndroidTestCase<TemperatureScreen>
{
    //~ Static/instance variables .............................................

    // The test case class will automatically fill in any fields that
	// represent widgets/views based on their type and name, just like they do
	// in your screen class.

    private EditText fahrenheitField;
    private EditText celsiusField;
    private Button clearFields;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * This constructor is required by Android's unit testing framework. Simply
     * declare a no-argument constructor in your test class and call the
     * superclass constructor, passing it the class that represents the
     * screen that you are testing.
     */
    public TemperatureScreenTest()
    {
        super(TemperatureScreen.class);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * A simple example of a test method for exercising TemperatureScreen.
     */
    public void testFahrenheitToCelsius()
    {
        // You can simulate actions in your activity's GUI, such as typing
        // text into a field:

    	enterText(fahrenheitField, "98.6");

        // And then check the state of your widgets:

        assertEquals("37.00", celsiusField.getText());
    }


    // ----------------------------------------------------------
    /**
     * A simple example of a test method for exercising TemperatureScreen.
     */
    public void testClearFields()
    {
        enterText(fahrenheitField, "-40.0");

        // You can also click buttons:

        click(clearFields);

        // And again, check the state of your widgets:

        assertEquals("", celsiusField.getText());
        assertEquals("", fahrenheitField.getText());
    }


    // Place other test methods here...
}
