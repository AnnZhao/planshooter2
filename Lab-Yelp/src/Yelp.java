import realtimeweb.yelp.Review;
import realtimeweb.yelp.exceptions.BusinessSearchException;
import realtimeweb.yelp.BusinessDataListener;
import realtimeweb.yelp.SearchResponse;
import java.util.List;
import realtimeweb.yelp.BusinessSearchListener;
import java.util.ArrayList;
import realtimeweb.yelp.BusinessQuery;
import realtimeweb.yelp.Business;
import realtimeweb.yelp.BusinessSearch;

/**
 * // -------------------------------------------------------------------------
 * /** Write a one-sentence summary of your class here. Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Ann
 * @version 2013-11-8
 */
public class Yelp
    implements BusinessSearchListener, BusinessDataListener
{
    private BusinessSearch      businessSearch;
    private ArrayList<Business> busArray;


    /**
     * A Yelp object class.
     */
    public Yelp()
    {
        businessSearch = BusinessSearch.getInstance();
    }


    /**
     * The effect of calling this method is that the Yelp service will be pinged
     * to search for businesses in Blacksburg.
     */
    public void processBusinesses()
    {
        busArray = new ArrayList<Business>();
        businessSearch.searchBusinesses(
            new BusinessQuery("Blacksburg, VA"),
            this);

    }


    /**
     * This method returns the list of perfect rating businesses.
     *
     * @return returns a list of the businesses.
     */
    public List<Business> perfectBusinesses()
    {
        return busArray;
    }


    /**
     * This method runs when the search is completed
     *
     * @param a
     *            is the list of search response objects.
     */
    @Override
    public void businessSearchCompleted(SearchResponse a)
    {
        float rating = 0;
        for (Business business2 : a.getBusinesses())
        {
            rating = business2.getRating();
            if (Math.abs(rating - 5) < .00001f)
            {
                busArray.add(business2);
                businessSearch.getBusinessData(business2, this);
            }
        }
    }


    /**
     * This method runs when the data gathering is completed.
     *
     * @param a
     *            is the business type.
     */
    @Override
    public void businessDataCompleted(Business a)
    {
        for (Review review1 : a.getReviews())
        {
            if (review1.getRating() != 5)
            {
                busArray.remove(a);
            }
        }

    }


    /**
     * This method runs when search failes.
     *
     * @param a
     *            this is the exception.
     */
    @Override
    public void businessDataFailed(BusinessSearchException a)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void businessSearchFailed(BusinessSearchException arg0)
    {
        // TODO Auto-generated method stub

    }
}
