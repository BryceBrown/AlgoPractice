package com.company.topcoder;

/**
 * Created by fatma on 6/19/2017.
 */
public class AlienMultiplication {

    public static int getCorrections(int a, int b, int c){
        if(a * b == c)
            return 0;

        String abRes = Integer.toString(a * b);

        //check last 6
        String cStr = Integer.toString(c);
        if(abRes.substring(abRes.length() - 6).equals(cStr.substring(cStr.length())))




        return 0;
    }

}
