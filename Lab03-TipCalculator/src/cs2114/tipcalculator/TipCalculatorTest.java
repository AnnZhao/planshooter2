package cs2114.tipcalculator;

//-------------------------------------------------------------------------
/**
 * Some minimal testing to achieve full coverage for the TipCalculator class.
 *
 * @author  Tony Allevato
 * @version 2012.09.11
 */
public class TipCalculatorTest extends student.TestCase
{
	//~ Fields ................................................................

	/** The tip calculator object we're testing. */
	private TipCalculator tipper;


	//~ Public methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Called before each test to initialize a fresh state.
	 */
	public void setUp()
	{
		tipper = new TipCalculator();
	}


	// ----------------------------------------------------------
	/**
	 * A simple test case to assert that multiplication works correctly.
	 */
	public void testTipper()
	{
		tipper.setAmountOfBill(10.00);
		tipper.setTipRate(0.15);

		assertEquals(1.50, tipper.getTipAmount(), 0.001);
	}
}
