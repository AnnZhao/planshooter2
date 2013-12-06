import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * An implementation of the Levenshtein distance algorithm.
 *
 * @author Zhenshu Zhao (zzhens7) Yusheng Zhang (yusheng)
 * @version 2013.11.15
 */
public class Levenshtein
{
    // ~ Fields ..........................................................
    private String                   string1;
    private String                   string2;
    private HashMap<String, Integer> map;




    // ~ Constructors ....................................................
    /**
     * @param l  sss
     * @param m  ttt
     */
    public Levenshtein(String l, String m)
    {
        string1 = l;
        string2 = m;
        map = new HashMap<String, Integer>();
    }


    // TODO Add your constructors here.

    // ~ Methods .........................................................

    /**
     * distance
     * @param c1  c
     * @param len1 d
     * @param c2  d
     * @param len2 fjie
     */
    private int distance(int c1, int len1, int c2, int len2)
    {

        String key = c1 + "," + len1 + "," + c2 + "," + len2;

        if (map.containsKey(key))
        {
            return map.get(key);
        }
        else if (len1 == 0)
        {
            map.put(key, len2);
            return len2;
        }
        else if (len2 == 0)
        {
            map.put(key, len1);
            return len1;
        }
        else
        {
            int dis1 = distance(c1 + 1, len1 - 1, c2 + 1, len2 - 1);

            if (string1.charAt(c1) != string2.charAt(c2))
            {
                dis1++;
            }

            int dis2 = distance(c1, len1, c2 + 1, len2 - 1) + 1;
            int dis3 = distance(c1 + 1, len1 - 1, c2, len2) + 1;
            map.put(key, Math.min(Math.min(dis1, dis2), dis3));
            return Math.min(Math.min(dis1, dis2), dis3);

        }
    }

    /**
     * distance
     * @return return distance
     */
    public int distance()
    {
        return distance(0, string1.length(), 0, string2.length());
    }

}

