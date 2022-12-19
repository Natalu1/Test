package com.company.ex3;

import com.company.ex2.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Excercise3 {


    public static void main(String[] args) {
        ex_3_1();
        System.out.println("Oldest owner of the animal - " + ex_3_2());
    }

    //Create one instance of Bird and two instances of Cat
    //run method giveVoice() on each created object
    private static void ex_3_1() {
        Bird bird = new Bird("sparrow", Set.of(new Person("ABC", "CXZ", 25)), 50);
        Cat cat1 = new Cat("Persik", Set.of(new Person("Dik", "HGF", 35)));
        Cat cat2 = new Cat("Cat", Set.of(new Person("Ewa", "Kowalski", 42)));

        List<Animal> animals = Arrays.asList(
                new Bird("Sparrow", Set.of(new Person("ABC", "CXZ", 25)), 50),
                new Cat("Persik", 23),
                new Cat("Cat", 24));
        animals.forEach(Animal::giveVoice);

    }

    //Create one instance of Bird and two instances of Cat together with owners
    //Write method returning Set of Person - it should be the oldest owner of the animal
    private static Set<Person> ex_3_2() {
        List<Animal> animals = Arrays.asList(
                new Bird("Sparrow", Set.of(new Person("Adam", "CXZ", 42)), 50),
                new Cat("Persik",
                        Set.of(
                                new Person("Dik", "HGF", 23),
                                new Person("Den", " kjhgfd", 42))),
        new Cat("Cat", Set.of(new Person("Ewa", "Kowalski", 42))));
        Map.Entry<Integer, Set<Person>> max = animals.stream()
                .map(animal -> animal.getOwners())
                .flatMap(Set::stream)
                .collect(Collectors.groupingBy(Person::getAge, Collectors.toSet()))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .orElseThrow();
        return max.getValue();
    }

    //Create one instance of Bird and two instances of Cat together with owners
    //One of animals should be homeless (without owners)
    //Write method returning List of string (owner names) - if Animal doesn't have the owner it should return "UNKNOWN" instead of owner name
    private static void ex_3_3() {
        List<Animal> animals = Arrays.asList(
                new Bird("Sparrow", Set.of(new Person("Adam", "CXZ", 25)), 50),
                new Cat("Persik", Set.of(new Person("Dik", "HGF", 42))),
                new Cat("Cat", Set.of()));
        Map<String, List<Person>> listMap = animals.stream()
                .map(animal -> animal.getOwners())
                .flatMap(Set::stream)
                .collect(Collectors.groupingBy(Person::getFirstName));


    }

    //Create one instance of Bird and two instances of Cat together with owners
    //One of animals should be homeless (without owners)
    //Write method returning Set of objects - AnimalId - it should contain Animal name and the oldest person fullName
    private static void ex_3_4() {
    }

    //DLA CHĘTNYCH!!!
    //Create one instance of Bird and two instances of Cat together with owners
    //One of animals should be homeless (without owners)
    //Write method returning List of objects - AnimalId - it should contain Animal name and the oldest person fullName
    //List should be sorted by cat's tail length or bird's flySpeed.
    //Fly speed should be pointed twice, so for list of animals with their attribute:
    // Cat(3)
    // Cat(5)
    // Cat(7)
    // Cat(13)
    // Bird(1)
    // Bird(2)
    // Bird(4)
    // Bird(5)


    // It should return list of animalId with order:
    // Bird(1)
    // Cat(3)
    // Bird(2)
    // Cat(5)
    // Cat(7)
    // etc...

    private static void ex_3_5() {
    }
}
