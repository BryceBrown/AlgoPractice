package com.company.crackingtheinterview.linkedlists;

/**
 * Created by tehowner on 5/17/17.
 */
public class Utilities {

    public static void printListContents(LinkedList list){
        if(list != null){
            Node node = list.head;
            while (node != null){
                System.out.println(node.value);
                node = node.next;
            }
        }
    }
}
