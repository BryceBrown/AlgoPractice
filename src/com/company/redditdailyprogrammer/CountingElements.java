package com.company.redditdailyprogrammer;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by fatma on 5/31/2017.
 * https://www.reddit.com/r/dailyprogrammer/comments/6eerfk/20170531_challenge_317_intermediate_counting/
 */
public class CountingElements {

    //Alright, so basically, we need to parse out the different number of molecules from the input, by either grabbing elements and their numbers
    // sorting it somewhere, and then outputing the total
    //Everything outside of the parenthesis should be straiht forward
    //Walk the string until you find a number or another capital letter
    //A Hashtable of strings to ints should do nicely for storing the counts
    //Once you hit an open parenthesis, start collecting a group of elemtnts, stored in a newer, tempory hash table
    //Once you hit the end, multiply the contents of the temporary hashtable by the parenthesis repotitions, and then
    //add them back to the total count hashtable.
    //I don't think we need to deal with nested parenthesis, so we are going to ignore that for now

    /*
        Psuedocode
        for every element in the given formula:
            Check to see if we are already working on a parenthesis
                keep a reference to the hastable we
                if so, (element first, check the next character)
                    if it is a lower case, combine it and add it to



     */

    public static void main(String[] args){
        //Read input from input
        Scanner scanner = new Scanner(System.in);
        char[] formula = scanner.nextLine().toCharArray();

        Hashtable<String, Integer> elementCounts = new Hashtable<>();
        Hashtable<String, Integer> elementGroup = null;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < formula.length; i++) {
            Hashtable<String, Integer> currentGroup = elementCounts;
            if(elementGroup != null) {
                //We are in a parenthesis
                currentGroup = elementGroup;
            }

            if(formula[i] == '('){
                elementGroup = new Hashtable<>();

                if(sb.length() > 0){
                    addToHashtable(currentGroup, sb.toString(), 1);
                    sb = new StringBuilder();
                }
            }else if ((int)formula[i] >= (int)'A' && (int)formula[i] < (int)'a'){
                //Assume the input string is an upper case character if it's farther than upper case ASCII
                if(sb.length() > 0){
                    addToHashtable(currentGroup, sb.toString(), 1);
                    sb = new StringBuilder();
                }
                sb.append(formula[i]);

            }else if ((int)formula[i] >= (int)'a'){

                //lower case
                //check for numbers
                sb.append(formula[i]);
                String number = "";
                int x = 1;
                while(i + x < formula.length && IsDigit(formula[i + x])) {
                    number = number + Character.toString(formula[i + x]);
                    x++;
                }
                int numberOfElements = 1;
                if(number.length() > 0){
                    numberOfElements = Integer.parseInt(number);
                }

                addToHashtable(currentGroup, sb.toString(), numberOfElements);

                //move the pointer forward
                i += x - 1;
                sb = new StringBuilder();
            }else if (IsDigit(formula[i])){
                String number = Character.toString(formula[i]);

                int x = 1;
                while(i + x < formula.length && IsDigit(formula[i + x])) {
                    number = number + Character.toString(formula[i + x]);
                    x++;
                }
                int numberOfElements = 1;
                if(number.length() > 0){
                    numberOfElements = Integer.parseInt(number);
                }

                addToHashtable(currentGroup, sb.toString(), numberOfElements);

                //move the pointer forward
                i += x - 1;
                sb = new StringBuilder();
            }else if (formula[i] == ')'){
                if(sb.length() > 0){
                    addToHashtable(currentGroup, sb.toString(), 1);
                    sb = new StringBuilder();
                }

                String number = "";

                int x = 1;
                while(i + x < formula.length && IsDigit(formula[i + x])) {
                    number = number + Character.toString(formula[i + x]);
                    x++;
                }
                int numberOfGroup = 1;
                if(number.length() > 0){
                    numberOfGroup = Integer.parseInt(number);
                }

                //move the pointer forward
                i += x - 1;

                //Add the number of sets to the total
                for(int y = 0; y < numberOfGroup; y++){
                    for(String key : elementGroup.keySet()){
                        addToHashtable(elementCounts, key, elementGroup.get(key));
                    }
                }
                elementGroup = null;
            }

        }

        for(String key : elementCounts.keySet()){
            System.out.print(key  + ": ");
            System.out.println(elementCounts.get(key));
        }



    }

    private static void addToHashtable(Hashtable<String, Integer> table,
                                        String element, int numberOfElemetns){
        if(table == null)
            return;

        if(table.containsKey(element)){
            table.put(element, table.get(element) + numberOfElemetns);
        }else{
            table.put(element, numberOfElemetns);
        }
    }

    private static boolean IsDigit(char ch){
        return (int)ch >= (int)'0' && (int)ch < (int)'9';
    }

}
