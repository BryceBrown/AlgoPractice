package com.company.topcoder;

/**
 * Created by fatma on 6/19/2017.
 */
public class AimToTen {

    public static int need(int[] marks){

        int score = 0;
        for(int i=0;i < marks.length; i++){
            score += marks[i];
        }

        if((float)score / (float)marks.length >= 9.5){
            return 0;
        }

        return (19 * (marks.length)) - (2 * score);
    }

}
