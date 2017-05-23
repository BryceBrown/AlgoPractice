package com.company.crackingtheinterview.linkedlists;

import java.util.ArrayList;

/**
 * Created by tehowner on 5/21/17.
 */
public class CheckIfLinkedListIsPalindrome {

    public static LinkedList getPalindromeList()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node();
        node1.value = 1;
        list.head = node1;

        Node node2 = new Node();
        node1.next = node2;
        node2.value = 2;

        Node node3 = new Node();
        node2.next = node3;
        node3.value = 2;

        Node node4 = new Node();
        node3.next = node4;
        node4.value = 1;

        return list;
    }

    public static LinkedList getNonPalindromeList()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node();
        node1.value = 1;
        list.head = node1;

        Node node2 = new Node();
        node1.next = node2;
        node2.value = 2;

        Node node3 = new Node();
        node2.next = node3;
        node3.value = 2;

        Node node4 = new Node();
        node3.next = node4;
        node4.value = 13;

        return list;
    }


    public static boolean IsLinkedListPalindrome(LinkedList list){

        Node walker = list.head;
        //Ok, O(N) would be to store values in a list, get the length, and start from the center and work outwards
        ArrayList<Integer> palindromeList = new ArrayList<>();
        while (walker != null){
            palindromeList.add(walker.value);
            walker = walker.next;
        }

        int midpoint = palindromeList.size() / 2;
//        midpoint += (midpoint % 2 == 0) ? 1 : 0;
        for(int i=0;i <= midpoint; i++) {
            System.out.println("Testing " + (midpoint - i) + " and " + (midpoint + i - 1));
            System.out.println("Testing " + palindromeList.get(midpoint - i) + " and " + palindromeList.get(midpoint + i - 1));
            if(palindromeList.get(midpoint - i) != palindromeList.get(midpoint + i - 1)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        LinkedList palindromeList = getPalindromeList();
        System.out.println(palindromeList);
        if(IsLinkedListPalindrome(palindromeList)){
            System.out.println("W00t");
        }

        LinkedList nonPalList = getNonPalindromeList();
        System.out.println(nonPalList);
        if(!IsLinkedListPalindrome(nonPalList)){
            System.out.println("W00t");
        }
    }

}
