package cs2114.tipcalculator;
import android.widget.TextView;
import android.widget.EditText;
import sofia.app.Screen;

//-------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Your name (pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class TipCalculatorScreen extends Screen
{
	//~ Fields ................................................................

    private TipCalculator tipclac;
    private EditText amountOfBill;
    private TextView tipAmount;

	//~ Public methods ........................................................

    public void initialize()
    {
        tipclac = new TipCalculator();
        tipclac.addObserver(this);
        tipclac.setTipRate(0.15);
    }
    public void tip15Clicked()
    {
        tipclac.setTipRate(0.15);
    }
    public void tip18Clicked()
    {
        tipclac.setTipRate(0.18);
    }
    public void tip20Clicked()
    {
        tipclac.setTipRate(0.20);
    }
    public void amountOfBillEditingDone()
    {
        tipclac.setAmountOfBill(Double.parseDouble(amountOfBill.getText()
            .toString()));
    }
    public void changeWasObserved(TipCalculator x)
    {
        tipAmount.setText(String.format("%.2f",tipclac.getTipAmount()));
    }
}
