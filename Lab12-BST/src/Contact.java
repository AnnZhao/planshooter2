/**
 * // -------------------------------------------------------------------------
 * /** this class represents the contact information for a particular person.
 *
 * @author Zhenshu Zhao (zzhens7)
 * @author Yusheng Zhang(yusheng)
 * @version 2013.12.06
 */
public class Contact
    implements Comparable<Contact>
{
    private String firstname;
    private String lastname;
    private String phone;


    // ----------------------------------------------------------
    /**
     * initialize the contact information.
     *
     * @param f
     *            is the first name.
     * @param l
     *            is the last name
     * @param num
     *            is the phone number.
     */
    public Contact(String f, String l, String num)
    {
        firstname = f;
        lastname = l;
        phone = num;
    }


    // ----------------------------------------------------------
    /**
     * compare to contact.
     *
     * @param o
     *            is the contact information
     * @return the compare result
     */
    public int compareTo(Contact o)
    {
        if (o.getLast().compareTo(lastname) == 0)
        {
            if (o.getFirst().compareTo(firstname) == 0)
            {
                return o.getNumber().compareTo(phone);
            }
            else
            {
                return o.getFirst().compareTo(firstname);
            }
        }
        else
        {
            return o.getLast().compareTo(lastname);
        }
    }


    // ----------------------------------------------------------
    /**
     * get first name.
     *
     * @return first is the first name
     */
    public String getFirst()
    {
        return firstname;
    }


    // ----------------------------------------------------------
    /**
     * get last name.
     *
     * @return last is the lastname
     */
    public String getLast()
    {
        return lastname;
    }


    // ----------------------------------------------------------
    /**
     * get phone number.
     *
     * @return number is the phone number
     */
    public String getNumber()
    {
        return phone;
    }

}
