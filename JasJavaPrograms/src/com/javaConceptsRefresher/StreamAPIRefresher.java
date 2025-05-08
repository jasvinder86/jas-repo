package com.javaConceptsRefresher;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*Using streams, double all the even numbers and return their sum as the output*/

public class StreamAPIRefresher {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4);

        numList.forEach(n -> System.out.println(n));

        System.out.println("Stream operations");
        Stream<Integer> s1 = numList.stream();
//        s1.forEach(s -> System.out.println(s));
        s1.filter(n -> n % 2 == 0).forEach(s -> System.out.println(s * 2));

//        s1.forEach(s -> System.out.println(s * 2));

        Integer finalValue = numList.stream().filter(s -> s % 2 == 0).map(x -> x * 2).reduce(0, (c, e) -> c + e);
        System.out.println("finalValue :" + finalValue);

    }
}
