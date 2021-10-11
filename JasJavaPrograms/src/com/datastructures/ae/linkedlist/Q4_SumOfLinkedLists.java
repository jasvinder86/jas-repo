package com.datastructures.ae.linkedlist;

public class Q4_SumOfLinkedLists {

    static LinkedList head;

    public static LinkedList appendToLinkedList(int data) {
        LinkedList newNode = new LinkedList(data);

        if (null == head) {
            head = newNode;
        } else {
            LinkedList currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        return head;

    }


    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.

        int lengthOfLL1 = 0, lengthOfLL2 = 0, sum = 0;

//        find length of both LLs
        LinkedList currentNodeOfLL1 = linkedListOne;
        while (currentNodeOfLL1 != null) {
            lengthOfLL1++;
            currentNodeOfLL1 = currentNodeOfLL1.next;
        }

        LinkedList currentNodeOfLL2 = linkedListTwo;
        while (currentNodeOfLL2 != null) {
            lengthOfLL2++;
            currentNodeOfLL2 = currentNodeOfLL2.next;
        }

//        create integers out of both the LLs
        int integerFromLL1 = 0, integerFromLL2 = 0;

//        integer 1
        currentNodeOfLL1 = linkedListOne;
        int power = 0;
        while (currentNodeOfLL1 != null) {

            System.out.println((int) Math.pow(10, power));

            integerFromLL1 = integerFromLL1 + currentNodeOfLL1.value * (int) Math.pow(10, power);
            currentNodeOfLL1 = currentNodeOfLL1.next;
            power++;
        }

        //        integer 2
        power = 0;
        currentNodeOfLL2 = linkedListTwo;
        while (currentNodeOfLL2 != null) {
            integerFromLL2 = integerFromLL2 + currentNodeOfLL2.value * (int) Math.pow(10, power);
            currentNodeOfLL2 = currentNodeOfLL2.next;
            power++;
        }


        int finalSum = integerFromLL1 + integerFromLL2;
        System.out.println("sum is " + finalSum);

        int lengthOfFinalSumInteger = String.valueOf(finalSum).length();
        LinkedList newHead = null;
        LinkedList newNode = null;

//        logic for MSB as head but we want LSB as head
//        while (lengthOfFinalSumInteger > 0) {
//            int msbOfSum = finalSum / (int) Math.pow(10, lengthOfFinalSumInteger - 1);
//            finalSum = finalSum % (int) Math.pow(10, lengthOfFinalSumInteger - 1);
//            newNode = new LinkedList(msbOfSum);
//            if (null == newHead) {
//                newHead = newNode;
//            } else {
//                LinkedList currentNode = newHead;
//                while (currentNode.next != null) {
//                    currentNode = currentNode.next;
//                }
//                currentNode.next = newNode;
//            }
//            lengthOfFinalSumInteger--;
//
//        }

//      Check the time complexity of their solution. Mine has n^2.

        while (lengthOfFinalSumInteger > 0) {
            int lsbOfSum = finalSum % 10;
            finalSum = finalSum / 10;
            newNode = new LinkedList(lsbOfSum);
            if (null == newHead) {
                newHead = newNode;
            } else {
                LinkedList currentNode = newHead;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;
            }
            lengthOfFinalSumInteger--;

        }

        return newHead;

//        return new LinkedList(msbOfSum);

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Q4_SumOfLinkedLists.appendToLinkedList(1);
        Q4_SumOfLinkedLists.appendToLinkedList(2);
        Q4_SumOfLinkedLists.appendToLinkedList(3);
        LinkedList argHead = Q4_SumOfLinkedLists.appendToLinkedList(4);

        Q4_SumOfLinkedLists obj = new Q4_SumOfLinkedLists();
        LinkedList resultList = obj.sumOfLinkedLists(argHead, argHead);
        System.out.println(resultList);

    }

}

