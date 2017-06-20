package com.company.topcoder;

import java.util.ArrayList;

/**
 * Created by fatma on 6/15/2017.
 */
public class ABBA {

    public static String canObtain(String initial, String target){


        if(initial.length() > 0 &&
                (!target.contains(initial) ||
                        !target.contains(new StringBuilder(initial).reverse().toString()))){
            return "Impossible";
        }

        ArrayList<StringBuilder> paths = new ArrayList<>();
        paths.add(new StringBuilder(initial));

        while (paths.size() > 0){
            StringBuilder builder = paths.remove(0);

            //first, try A
            builder.append("A");
            if(target.contains(builder.toString())){
                if(target.equals(builder.toString())){
                    return "Possible";
                }
                paths.add(new StringBuilder(builder.toString()));
            }
            builder.setLength(builder.length() - 1);

            builder.reverse().append("B");
            if(target.contains(builder.toString())){
                if(target.equals(builder.toString())){
                    return "Possible";
                }
                paths.add(new StringBuilder(builder.toString()));
            }
        }
        return "Impossible";
    }


}
