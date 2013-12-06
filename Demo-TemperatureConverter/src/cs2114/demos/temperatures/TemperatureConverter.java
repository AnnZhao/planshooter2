package cs2114.demos.temperatures;

//-------------------------------------------------------------------------
/**
 * <p>
 * The model that contains the "business logic" for the temperature converter.
 * Think of the converter as a black box that can take temperatures in any
 * supported scale (currently just Fahrenheit and Celsius) and stores them in
 * an internal format (which happens to be Celsius, so other scales get
 * converted before they're stored). Then, you can query the "black box" for
 * the current temperature in any supported scale.
 * </p><p>
 * This conceptual model would make it easy to add additional temperature
 * scales (say, Kelvin) by supplying only another getter and setter, rather
 * than having to write NxN conversion methods (C to K, K to C, F to K,
 * K to F...).
 * </p><p>
 * Notice that this class extends the sofia.util.Observable class; this allows
 * other classes (such as the controller, TemperatureScreen), to hook in and
 * be notified when changes are made to the model.
 * </p>
 *
 * @author  Tony Allevato
 * @version 2012.08.30
 */
public class TemperatureConverter extends sofia.util.Observable
{
    //~ Fields ................................................................

	// Holds the last temperature set, internally stored as degrees Celsius.
	private double degreesCelsius;
	

	//~ Public methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Gets the last temperature set in degrees Celsius.
	 * 
	 * @return the last temperature set in degrees Celsius
	 */
	public double getCelsius()
	{
		return degreesCelsius;
	}
	
	
	// ----------------------------------------------------------
	/**
	 * Sets the temperature in degrees Celsius.
	 * 
	 * @param value the temperature in degrees Celsius
	 */
	public void setCelsius(double value)
	{
		degreesCelsius = value;
		
		notifyObservers();
	}


	// ----------------------------------------------------------
	/**
	 * Gets the last temperature set in degrees Fahrenheit.
	 * 
	 * @return the last temperature set in degrees Fahrenheit
	 */
	public double getFahrenheit()
	{
		return degreesCelsius * 9 / 5 + 32;
	}
	
	
	// ----------------------------------------------------------
	/**
	 * Sets the temperature in degrees Fahrenheit.
	 * 
	 * @param value the temperature in degrees Fahrenheit
	 */
	public void setFahrenheit(double value)
	{
		degreesCelsius = (value - 32) * 5 / 9;
		
		notifyObservers();
	}
}
