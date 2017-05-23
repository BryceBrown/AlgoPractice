package com.company.hackerrank;

import java.util.Scanner;

/**
 * Created by tehowner on 5/17/17.
 * https://www.hackerrank.com/challenges/kangaroo?h_r=next-challenge&h_v=zen
 */
public class Kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        if((x1 <= x2 && v1 < v2) ||
                (x2 <= x1 && v2 < v1)){
            System.out.println("NO");
            return;
        }

        int bigV = v1 > v2 ? v1 : v2;
        int littleV = v2 > v1 ? v2 : v1;

        if(bigV % littleV == Math.abs(x1 - x2))

        //starts behind, will never catch
        if((x1 <= x2 && v1 < v2) ||
                (x2 <= x1 && v2 < v1)){
            System.out.println("NO");
        }else if (x1 == x2 && v1 != v2){
            System.out.println("NO");
        }else if (x1 == x2 && v1 == v2){
            System.out.println("YES");
        }else{
            int largestPos = x1 > x2 ? x1 : x2;
            int smallestPos = x2 > x1 ? x2 : x1;

            int forwardV = x1 > x2 ? v1 : v2;
            int rearV = x2 > x1 ? v2 : v1;
            double jumps = ((double)(largestPos - smallestPos) / (double)(forwardV - rearV));
            if ((jumps == Math.floor(jumps)) && !Double.isInfinite(jumps)) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
