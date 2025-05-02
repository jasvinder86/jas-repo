package com.javaConceptsRefresher;

class Parent {
    int x = 1;

    public void test() {
        System.out.println("in Parent");
    }
}

class Child extends Parent {
    int x = 0;

    public void test() {
        System.out.println("in Child");
    }
}

public class DynamicMethodDispatch {

    int x = 5;


    public static void main(String[] args) {

        Parent p = new Parent();
        System.out.println(p.x); // 1
        p.test();// in Parent
        Child c = new Child();
        System.out.println(c.x); // 0
        c.test(); // in Child
        System.out.println();
        Parent pc = new Child();
        System.out.println(pc.x); // 1 (field access uses reference type, not object type)
        pc.test(); // in Child (dynamic method dispatch; resolved based on actual object type)
        Child cp = (Child) new Parent(); // ClassCastException
        System.out.println(cp.x);
        cp.test();
    }
}
