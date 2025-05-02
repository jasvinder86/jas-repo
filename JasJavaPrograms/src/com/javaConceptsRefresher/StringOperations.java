package com.javaConceptsRefresher;

public class StringOperations {

    static String s1 = "one";
    static String s2 = "one";

    public static void main(String[] args) {

//        String Pool: When two strings have the same content and are created without the new keyword,
//        they point to the same memory location in the pool.

//        compares the reference or memory location of objects in a heap, whether they point to the same location or not.
        System.out.println(s1 == s2); //true

//         compares the content equality of two strings
        System.out.println(s1.equals(s2)); //true


//        Heap: Strings created using the new keyword always allocate new memory.

        String s3 = "HELLO"; // String pool
        String s4 = new String("HELLO"); // Heap

        System.out.println(s3 == s4); // false, since these are two different objects
        System.out.println(s3.equals(s4)); // true, since contents are same


    }
}
