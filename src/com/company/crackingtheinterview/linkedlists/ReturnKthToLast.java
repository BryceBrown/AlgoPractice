package com.company.crackingtheinterview.linkedlists;

/**
 * Created by tehowner on 5/17/17.
 */
public class ReturnKthToLast {

    //basically, keep a trailing pointer to K behind the current head
    public static Node GetKLast(int k, LinkedList list){
        Node head = list.head;
        Node kth = null;
        int count = 0;

        //TODO - Check for loops
        while(head != null){
            if(count == k - 1){
                kth = list.head;
            }

            head = head.next;

            if(kth != null && head != null){
                kth = kth.next;
            }


            count++;
        }

        return kth;
    }

    public static void main(String[] args){
        LinkedList list = SampleLists.getKthTest();
        System.out.println("Starting ReturhKthToLast");
        System.out.println(list.toString());
        Node node = GetKLast(3, list);
        if(node != null){
            System.out.println("3nd to last element " + Integer.toString(node.value));
        }


    }

}
