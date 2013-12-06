package cs2114.demos.temperatures;

import sofia.app.Screen;
import android.widget.EditText;

//--------------------------------------------------------------------------
/**
 * <p>
 * A small app that converts temperatures from degrees Fahrenheit to degrees
 * Celsius, and vice versa. This example shows how apps can listen to editing
 * events from text widgets.
 * </p><p>
 * Our Screen class is smart enough to find the layout that it should use
 * without having to explicitly specify it. If our class is named
 * "TemperatureScreen", then it will look for a layout in
 * "res/layout/temperaturescreen.xml" or in
 * "res/layout/temperature_screen.xml".
 * </p>
 *
 * @author  Tony Allevato
 * @version 2012.08.30
 */
public class TemperatureScreen extends Screen
{
	//~ Fields ................................................................

	// A reference to the model for our application, which will be initialized
	// in the initialize() method below.

	private TemperatureConverter converter;

	// Fields that have names matching view/widget IDs in your layout will
	// automatically be assigned references to those widgets so that you can
	// use them in your initialize method (if you have one) and other event
	// handlers.

	private EditText fahrenheitField;
	private EditText celsiusField;


	//~ Public methods ........................................................

	// ----------------------------------------------------------
	/**
	 * The initialize method is called when the screen is about to be presented
	 * to the user.
	 *
	 * Unlike most classes in Java, we usually do not write constructors for
	 * Screen subclasses to do initialization tasks. Instead, we write this
	 * initialize() method, which is called only after the system has
	 * guaranteed that resources we need are available.
	 */
	public void initialize()
	{
		// Create the model that our application will be using.

		converter = new TemperatureConverter();

		// Add the controller itself as an observer to the model. Whenever the
		// temperature is changed (by editing one of the text fields), the
		// observers will be notified (see the changeWasObserved method below).

		converter.addObserver(this);
	}


	// ----------------------------------------------------------
	/**
	 * This method is called when the user has finished typing a value into the
	 * Fahrenheit field and tapped the "Next" button on the keyboard (or
	 * pressed Enter).
	 */
	public void fahrenheitFieldEditingDone()
	{
		// Normally we would want to place a try/catch block around calls to
		// Double.parseDouble because it will throw an exception if the string
		// we pass in does not look like a valid number (for example, "49.X").
		// However, since the widgets in the layout have an inputType of
		// "numberDecimal", they will never contain something that does not
		// look like a valid decimal number, so we can ignore that case.

		double degreesF = Double.parseDouble(
				fahrenheitField.getText().toString());

		converter.setFahrenheit(degreesF);
	}


	// ----------------------------------------------------------
	/**
	 * This method is called when the user has finished typing a value into the
	 * Celsius field and tapped the "Done" button on the keyboard (or pressed
	 * Enter).
	 */
	public void celsiusFieldEditingDone()
	{
		double degreesC = Double.parseDouble(
				celsiusField.getText().toString());

		converter.setCelsius(degreesC);
	}


	// ----------------------------------------------------------
	/**
	 * This method is called when the user clicks the button with the ID
	 * "clearFields".
	 */
	public void clearFieldsClicked()
	{
		fahrenheitField.setText("");
		celsiusField.setText("");
	}


	// ----------------------------------------------------------
	/**
	 * Since this object is added as an observer to the model, the model will
	 * call this method whenever it internal calls notifyObservers(). This is
	 * where we are notified that the temperature in one of the fields has been
	 * updated and we can update the other one. (Notice that we update both
	 * fields no matter what in this example though, to keep it simple.)
	 *
	 * @param theConverter the instance of TemperatureConverter that had a
	 *     change occur. In our simple example there is only one, so it will
	 *     always be the same as our "converter" field. But if we wanted to
	 *     observe multiple instances of a class, we could use that parameter
	 *     to differentiate them.
	 */
	public void changeWasObserved(TemperatureConverter theConverter)
	{
		fahrenheitField.setText(
				String.format("%.2f", converter.getFahrenheit()));

		celsiusField.setText(
				String.format("%.2f", converter.getCelsius()));
	}
}
