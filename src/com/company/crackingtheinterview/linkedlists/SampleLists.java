package com.company.crackingtheinterview.linkedlists;

/**
 * Created by tehowner on 5/17/17.
 */
public class SampleLists {

    public static LinkedList getTestList1()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node();
        node1.value = 10;
        list.head = node1;

        Node node2 = new Node();
        node1.next = node2;
        node2.value = 4;

        Node node3 = new Node();
        node2.next = node3;
        node3.value = 10;

        Node node4 = new Node();
        node3.next = node4;
        node4.value = 11;

        return list;
    }


    public static LinkedList getKthTest()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node();
        node1.value = 10;
        list.head = node1;

        Node node2 = new Node();
        node1.next = node2;
        node2.value = 4;

        Node node3 = new Node();
        node2.next = node3;
        node3.value = 10;

        Node node4 = new Node();
        node3.next = node4;
        node4.value = 11;

        return list;
    }

}
