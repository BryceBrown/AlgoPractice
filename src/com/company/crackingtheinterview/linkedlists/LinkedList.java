package com.company.crackingtheinterview.linkedlists;

/**
 * Created by tehowner on 5/17/17.
 */
public class LinkedList {

    public Node head;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Linked List: ");
        Node hd = head;
        while(hd != null){
            sb.append(Integer.toString(hd.value)).append(" ");
            hd = hd.next;
        }

        return sb.toString();
    }
}
