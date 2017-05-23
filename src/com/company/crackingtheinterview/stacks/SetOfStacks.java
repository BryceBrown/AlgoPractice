package com.company.crackingtheinterview.stacks;

import java.util.ArrayList;

/**
 * Created by tehowner on 5/22/17.
 */

public class SetOfStacks<T> {

    private int maxStackSize;
    private ArrayList<ArrayList<T>> stacks = new ArrayList<>();

    public SetOfStacks(int maxStackSize){
        this.maxStackSize = maxStackSize;
    }

    public T peek() {
        if(stacks.size() > 0){
            return stacks.get(0).get(0);
        }
        return null;
    }

    public void push(T item){
        //grab the last stack
        ArrayList<T> currentStack;
        if(stacks.size() == 0){
            currentStack = new ArrayList<>();
            stacks.add(currentStack);
        }else{
            currentStack = stacks.get(stacks.size() - 1);
        }

        if(currentStack.size() == maxStackSize){
            currentStack = new ArrayList<>();
            stacks.add(currentStack);
        }
        currentStack.add(item);
    }

    public T pop(){

        if(stacks.size() == 0) {
            return null;
        }

        T elementToPop = stacks.get(0).remove(0);
        //Now we need to pop an element off of each of the other stacks and add it to the previous one
        for(int stack = 1; stack < stacks.size();stack++){
            ArrayList<T> currentStack = stacks.get(stack);
            stacks.get(stack - 1).add(currentStack.remove(0));
        }

        //If the last stack is empty, remove it
        if(stacks.get(stacks.size() - 1).size() == 0){
            stacks.remove(stacks.get(stacks.size() - 1));
        }

        return elementToPop;
    }

    public boolean isEmpty(){
        return stacks.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i < stacks.size(); i++){
            sb.append("Stack ").append(i).append(":");
            ArrayList<T> currentStack = stacks.get(i);
            for(int x=0; x < currentStack.size();x++){
                sb.append(currentStack.get(x)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
