package com.company.crackingtheinterview.stacks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tehowner on 5/22/17.
 */
public class StackOfPlates {


    private static SetOfStacks<Integer> GetTestStack(){
        SetOfStacks<Integer> stack = new SetOfStacks<>(3);
        for (int i=0; i < 10; i++){
            stack.push(i);
        }

        return stack;
    }

    public static void main(String[] args){
        SetOfStacks<Integer> stack = GetTestStack();
        System.out.println(stack);

        while(!stack.isEmpty()){
            System.out.println("Top Element:" + stack.pop());
            System.out.println(stack);
        }
    }


}
