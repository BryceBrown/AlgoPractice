package com.company.crackingtheinterview.linkedlists;

import java.util.HashSet;

/**
 * Created by tehowner on 5/17/17.
 */
public class RemoveDups {


    private static void removeDups(LinkedList list)
    {
        Node node = list.head;
        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.add(node.value);

        while(node != null){
            if(node.next != null){
                if(integerHashSet.contains(node.next.value)){
                    node.next = node.next.next;
                }else{
                    integerHashSet.add(node.next.value);
                }
            }

            node = node.next;
        }
    }



    public static void main(String[] args) {
        System.out.println("Starting parsing");
        LinkedList testList1 = SampleLists.getTestList1();

        System.out.println("Before");
        Utilities.printListContents(testList1);
        removeDups(testList1);
        System.out.println("After");
        Utilities.printListContents(testList1);
    }
}
