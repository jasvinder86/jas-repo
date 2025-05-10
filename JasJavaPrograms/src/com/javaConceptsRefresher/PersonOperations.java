package com.javaConceptsRefresher;

/*
 * Trying to recall the question asked by Global Relay.
 * All persons have name, age and city.
 * Create a Person class first.
 * John Doe - 40, John - 42, John Rachel Zane - 44, Jane Doe - 46, Jon Specter - 48, Jane Litt - 50, Jessica Poster - 55, Mike Doug - 30, Mike Doss - 46
 *
 * Create a list of persons and then perform the following
 * 1. Print all the persons based on alphabetical order of their cities - first forward and then reverse
 * 2. Write a program that returns all persons whose last name starts with D and are over 45 years.
 * 3. Write a program that returns all persons whose second character of last names is 'o'.
 * 4. Get the person with the maximum age.
 * 5. Group persons by city
 * 6. Count persons per city
 * */

import java.util.*;
import java.util.stream.Collectors;


class Person {
    String name, city;
    int age;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String toString() {
        return (name + " is of age " + age + " and lives in " + city);
    }
}

public class PersonOperations {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("John Doe", 40, "Manhattan"));
        personList.add(new Person("John", 42, "Brooklyn"));
        personList.add(new Person("John Rachel Zane", 44, "The Bronx"));
        personList.add(new Person("Jane Doe", 46, "Queens"));
        personList.add(new Person("Jon Specter", 48, "Staten Island"));
        personList.add(new Person("Jane Litt", 50, "Brooklyn"));
        personList.add(new Person("Jessica Poster", 55, "Chicago"));
        personList.add(new Person("Mike Doug", 30, "Manhattan"));
        personList.add(new Person("Mike Doss", 46, "Seattle"));
        personList.add(new Person("Mike D", 56, "Seattle"));

//        Normal print of persons to check  the basic code correctness
        System.out.println("Original list");
        personList.forEach(person -> System.out.println(person)); // correct
        /*
        John Doe is of age 40 and lives in Manhattan
        John is of age 42 and lives in Brooklyn
        John Rachel Zane is of age 44 and lives in The Bronx
        Jane Doe is of age 46 and lives in Queens
        Jon Specter is of age 48 and lives in Staten Island
        Jane Litt is of age 50 and lives in Brooklyn
        Jessica Poster is of age 55 and lives in Chicago
        */

//        1. Print all the persons based on alphabetical order of their cities - first forward and then reverse
//        implement a comparator to compare the city names for the alphabetical order of the city names (without lambda)
        Comparator<Person> cityComparator = new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.city.charAt(0) < p2.city.charAt(0) ? -1 : 1;
            }
        };

        Collections.sort(personList, cityComparator);
        System.out.println("\nAnswer to question1; with alphabetical order");
        personList.forEach(person -> System.out.println(person)); // correct
        /*
        Answer to question1; with alphabetical order
        John is of age 42 and lives in Brooklyn
        Jane Litt is of age 50 and lives in Brooklyn
        Jessica Poster is of age 55 and lives in Chicago
        John Doe is of age 40 and lives in Manhattan
        Jane Doe is of age 46 and lives in Queens
        Jon Specter is of age 48 and lives in Staten Island
        John Rachel Zane is of age 44 and lives in The Bronx
        */


//        Now print in the reverse alphabetical order of the city names
        Collections.sort(personList, (person1, person2) -> person2.city.compareTo(person1.city));
        System.out.println("\nAnswer to question1; with reversed alphabetical order");
        personList.forEach(person -> System.out.println(person));
        /*
        Answer to question1; with reversed alphabetical order
        John Rachel Zane is of age 44 and lives in The Bronx
        Jon Specter is of age 48 and lives in Staten Island
        Jane Doe is of age 46 and lives in Queens
        John Doe is of age 40 and lives in Manhattan
        Jessica Poster is of age 55 and lives in Chicago
        John is of age 42 and lives in Brooklyn
        Jane Litt is of age 50 and lives in Brooklyn
        */

//         * 2. Write a program that returns all persons whose last name starts with D and are over 45 years.

//        split the name of each person by a space; if the charAt(0) of nameArray[size-1] is D, collect that in another list of people with last name starting with D

        List<Person> personListWithLastInitialDAbove45 = new ArrayList<>();

        /*Below are the two different implementations for filtering out the final output.
         * 1. Simple for loop
         * 2. Using streams
         * Output is the same in both the cases.
         * */

//        for (Person person : personList) {
//            String[] nameArray = person.name.split(" ");
//            if (nameArray[nameArray.length - 1].charAt(0) == 'D' && person.age > 45) {
//                personListWithLastInitialDAbove45.add(person);
//            }
//        }


        personListWithLastInitialDAbove45 = personList.stream().filter(person -> {
            String[] nameArray = person.name.split(" ");
            return (nameArray[nameArray.length - 1].charAt(0) == 'D' && person.age > 45);
        }).collect(Collectors.toList());


        System.out.println("\nPrinting the list of people with last initial D having age > 45");
        personListWithLastInitialDAbove45.forEach(person -> System.out.println(person));
        /* output =
        Printing the list of people with last initial D having age > 45
        Mike Doss is of age 46 and lives in Seattle
        Jane Doe is of age 46 and lives in Queens
        */

//         3. Write a program that returns all persons whose second character of last names is 'o'.
        List<Person> peopleWithSecondCharacterOfTheirLastNameasO = new ArrayList<>();

        peopleWithSecondCharacterOfTheirLastNameasO = personList.stream().filter(person -> {
            String nameArray[] = person.name.split(" ");
            if (nameArray.length > 1) { // this check is required for people without last names.
                String lastName = nameArray[nameArray.length - 1];
                return lastName.length() >= 2 && lastName.charAt(1) == 'o'; // length check is required for the cases where the last name is only a single character.
            }
            return false;

        }).collect(Collectors.toList());

        System.out.println("\nPeople With Second Character Of Their Last Name as o");
        peopleWithSecondCharacterOfTheirLastNameasO.forEach(person -> System.out.println(person));
        /*
        Mike Doss is of age 46 and lives in Seattle
        Jane Doe is of age 46 and lives in Queens
        John Doe is of age 40 and lives in Manhattan
        Mike Doug is of age 30 and lives in Manhattan
        Jessica Poster is of age 55 and lives in Chicago
        */

//        4. Get the person with the maximum age.
        Person oldestPerson = personList.get(0);
        for (int personIndex = 1; personIndex < personList.size(); personIndex++) {
            oldestPerson = oldestPerson.age > personList.get(personIndex).age ? oldestPerson : personList.get(personIndex);
        }
        System.out.println("\nThe oldest person is " + oldestPerson);

        Optional<Person> oldestPersonWithStream = personList.stream().max(Comparator.comparingInt(person -> person.age));
        oldestPersonWithStream.ifPresent(person -> System.out.println("Oldest Person With Stream is " + person));

//        5. Group persons by city
        System.out.println("\nGroup persons by city");
        System.out.println(personList.stream().collect(Collectors.groupingBy(person -> person.city)));

//        6. Count persons per city
        System.out.println("\nCount persons per city");
        Map<String, Long> personsPerCity = personList.stream().collect(Collectors.groupingBy(person -> person.city, Collectors.counting()));

        personsPerCity.forEach((city, count) -> System.out.println("Count of people in " + city + " is " + count));
    }
}
