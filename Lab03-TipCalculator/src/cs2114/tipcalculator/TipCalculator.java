package cs2114.tipcalculator;
import sofia.util.Observable;
//-------------------------------------------------------------------------
/**
 * A small class that acts as a tip calculating "machine". It has two-valued
 * state: the amount of the bill (the subtotal), and the rate that you want to
 * tip (as a decimal number, so 0.15 for 15%). When these values are set,
 * another getter lets you retrieve the amount of the tip (just the tip, not
 * the grand total).
 *
 * (So really, this class is just a fancy multiplier.)
 *
 * YOUR TASK is to make this class observable, so that setting either of those
 * state values will cause observers to be notified.
 *
 * @author  Tony Allevato (authored starter version of class)
 * @author  Your name (pid)
 * @version 2012.09.11
 */
public class TipCalculator extends Observable
{
	//~ Fields ................................................................

	/** The amount of the bill before the tip. */
	private double amountOfBill;

	/** The tip rate as a decimal number (such as 0.15 for 15%). */
	private double tipRate;


	//~ Public methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Gets the amount of the bill, before a tip is applied.
	 *
	 * @return the amount of the bill before the tip
	 */
	public double getAmountOfBill()
	{
		return amountOfBill;
	}


	// ----------------------------------------------------------
	/**
	 * Sets the amount of the bill, before a tip is applied. This method
	 * notifies observers of a state change.
	 *
	 * @param newAmount the new amount of the bill before the tip
	 */
	public void setAmountOfBill(double newAmount)
	{
		amountOfBill = newAmount;
	}


	// ----------------------------------------------------------
	/**
	 * Gets the tip rate, as a decimal value. For example, to tip 15%, you
	 * would pass in 0.15.
	 *
	 * @return the tip rate
	 */
	public double getTipRate()
	{
		return tipRate;
	}


	// ----------------------------------------------------------
	/**
	 * Sets the tip rate, as a decimal value. For example, to tip 15%, you
	 * would pass in 0.15. This method notifies observers of a state change.
	 *
	 * @param newTip the new tip rate
	 */
	public void setTipRate(double newTip)
	{
		tipRate = newTip;
	}


	// ----------------------------------------------------------
	/**
	 * Gets the dollar amount of the tip based on the amount of the bill and
	 * the tip rate.
	 *
	 * @return the dollar amount of the tip, calculated from the other values
	 */
	public double getTipAmount()
	{
		return amountOfBill * tipRate;
	}
}
