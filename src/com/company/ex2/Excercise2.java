package com.company.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Excercise2 {

    public static void main(String[] args) {
        System.out.println("Results of ex2_1:");
        ex2_1();
        System.out.println("It should be: \n[Bob, Kate, Cristiano]");

        System.out.println("Results of ex2_2:");
        ex2_2();
        System.out.println("It should be: \n[Bob, Kate]");

        System.out.println("Results of ex2_3:");
        ex2_3();
        System.out.println("It should be: \n [Kate, Cristiano]");

        System.out.println("Results of ex2_4:");
        ex2_4();
        System.out.println("It should be: \n [Bob, Kate, Cristiano, Lionel]");

        System.out.println("Results of ex2_5:");
        ex2_5();
        System.out.println("It should be: \ntrue");
    }

    //Implement method getAllPeopleNames - it should take list of Person objects and return List of their firstNames
    private static void ex2_1() {
        Person firstPerson = new Person("Bob", "Kowalski", 25);
        Person secondPerson = new Person("Kate", "Kowalski", 40);
        Person thirdPerson = new Person("Cristiano", "Ronaldo", 40);
        System.out.println(getAllPeopleNames(List.of(firstPerson, secondPerson, thirdPerson)));
    }

    private static List<String> getAllPeopleNames(List<Person> people) {
        return people.stream()
                .map(person -> person.getFirstName())
                .toList();//TODO ex_2_1
    }

//    Implement method findByLastName - it should take list of Person objects and lastName and return List of Person Objects with given lastName
    private static void ex2_2() {
        Person firstPerson = new Person("Bob", "Kowalski", 25);
        Person secondPerson = new Person("Kate", "Kowalski", 40);
        Person thirdPerson = new Person("Cristiano", "Ronaldo", 40);
        System.out.println(findByLastName(List.of(firstPerson, secondPerson, thirdPerson), "Kowalski"));
//        System.out.println(findByLastName(List.of(firstPerson, secondPerson, thirdPerson), "Ronaldo"));
    }

    private static List<Person> findByLastName(List<Person> people, String lastName) {

        return people.stream()
                .filter(person -> person.getLastName().equals(lastName))
                .toList();

         //TODO ex_2_2
    }

//    Implement method findAllPeopleAboveOrEqual30YearsOld() it should take list of Person objects and return List with people with 30 years old or older
    private static void ex2_3() {
        Person firstPerson = new Person("Bob", "Kowalski", 25);
        Person secondPerson = new Person("Kate", "Kowalski", 30);
        Person thirdPerson = new Person("Cristiano", "Ronaldo", 40);
        System.out.println(findAllPeopleAboveOrEqual30YearsOld(List.of(firstPerson, secondPerson, thirdPerson)));
    }

    private static List<Person> findAllPeopleAboveOrEqual30YearsOld(List<Person> people) {
        return people.stream().filter(person -> person.getAge() >= 30).toList();
        //TODO ex_2_3
    }

//    Implement method addToList - it should take list of person objects and another person. It should return List with new object added.
    private static void ex2_4() {
        Person firstPerson = new Person("Bob", "Kowalski", 25);
        Person secondPerson = new Person("Kate", "Kowalski", 30);
        Person thirdPerson = new Person("Cristiano", "Ronaldo", 40);
        List<Person> group = new ArrayList<>();
                group.addAll(List.of(firstPerson,secondPerson,thirdPerson));

        Person newPerson = new Person("Lionel", "Messi", 37);
        System.out.println(addToList(group, newPerson));
    }

    private static List<Person> addToList(List<Person> people, Person personToAdd) {
        people.add(personToAdd);
        return people; //TODO ex_2_4
    }

    //Implement method 'areGroupsEqual()'
    //Consider changing something in class Person to properly check groups equality
    private static void ex2_5() {
        Person firstPerson = new Person("Bob", "Kowalski", 25, "123");
        Person secondPerson = new Person("Kate", "Kowalski", 30, "333");
        Person thirdPerson = new Person("Cristiano", "Ronaldo", 40, "444");
        Set<Person> group1 = Set.of(firstPerson, secondPerson, thirdPerson);
//
        Person firstFake = new Person("Bobby", "Kowalskii", 23, "123");
        Person secondFake = new Person("Katy", "Kowalska", 30, "333");
        Person thirdFake = new Person("Chris", "Ronaldinho", 40, "444");
        Set<Person> fakeGroup = Set.of(firstPerson, secondPerson, thirdPerson);
        System.out.println(areGroupsEqual(group1, fakeGroup));
    }

    private static boolean areGroupsEqual(Set<Person> group1, Set<Person> group2) {
        return group1.equals(group2); //TODO ex2_5
    }
}
