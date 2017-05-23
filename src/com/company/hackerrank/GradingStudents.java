package com.company.hackerrank;

import java.util.Scanner;

/**
 * Created by tehowner on 5/17/17.
 */
public class GradingStudents {

    private static int[] solve(int[] grades){
        // Complete this function
        int[] results = new int[grades.length];

        for(int i=0; i<grades.length;i++){
            int currentGrade = grades[i];
            if(currentGrade < 38){
                results[i] = currentGrade;
                continue;
            }

            if(currentGrade % 5 >= 3){
                results[i] = currentGrade + 5 - (currentGrade % 5);
            }else{
                results[i] = currentGrade;
            }
        }


        return results;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


    }
}
