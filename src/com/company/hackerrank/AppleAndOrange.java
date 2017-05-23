package com.company.hackerrank;

import java.util.Scanner;

/**
 * Created by tehowner on 5/17/17.
 * https://www.hackerrank.com/challenges/apple-and-orange?h_r=next-challenge&h_v=zen
 */
public class AppleAndOrange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }

        int applesFell = 0;
        int orangesFell = 0;

        for(int i = 0; i < orange.length; i++){
            int orangeFallSpot = orange[i] + b;
            if(orangeFallSpot <= t && orangeFallSpot >= s){
                orangesFell++;
            }
        }


        for(int i = 0; i < apple.length; i++){
            int appleFallSpot = apple[i] + a;
            if(appleFallSpot <= t && appleFallSpot >= s){
                applesFell++;
            }
        }
        System.out.println(applesFell);
        System.out.println(orangesFell);
    }
}
