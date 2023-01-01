package com.company.ex3;

import com.company.ex2.Person;
import util.Utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Excercise3 {


    public static void main(String[] args) {
        ex_3_1();
        System.out.println("Oldest owner of the animal - " + ex_3_2());
        System.out.println(ex_3_3());
        System.out.println(ex_3_4());
        System.out.println(ex_3_5());
        Utils<AnimalId> utils = new Utils<>();
        utils.printCollectionInColumn(ex_3_5());
    }

    //Create one instance of Bird and two instances of Cat
    //run method giveVoice() on each created object
    private static void ex_3_1() {

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
                new Bird("Sparrow", Set.of(new Person("Adam", "CXZ", 40)), 50),
                new Cat("Persik",
                        Set.of(new Person("Dik", "HGF", 23),
                                new Person("Den", " kjhgfd", 42))),
                new Cat("Cat", Set.of(new Person("Ewa", "Kowalski", 41))));
        return animals.stream()
                .map(Animal::getOwners)
                .map(people -> getOldOfPerson(people))
                .collect(Collectors.toSet());

    }

    private static Person getOldOfPerson(Set<Person> peoples) {
        return peoples.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .get();// NOT DO THAT
    }


//                .flatMap(Set::stream)
//                .collect(Collectors.groupingBy(Person::getAge, Collectors.toSet()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByKey())
//                .orElseThrow();
//        return max.getValue();


    //Create one instance of Bird and two instances of Cat together with owners
    //One of animals should be homeless (without owners)
    //Write method returning List of string (owner names) - if Animal doesn't have the owner it should return "UNKNOWN" instead of owner name
    private static List<List<String>> ex_3_3() {
        List<Animal> animals = Arrays.asList(
                new Bird("Sparrow", Set.of(new Person("Adam", "CXZ", 25)), 50),
                new Cat("Persik", Set.of(new Person("Dik", "HGF", 42),
                        new Person("Max", "HGF", 23))),
                new Cat("Cat", Set.of()));
        return animals.stream()
                .map(Animal::getOwners)
                .map(people -> getNamesOrUnknown(people))
                .collect(Collectors.toList());
    }

    private static List<String> getNamesOrUnknown(Set<Person> people) {
        if (people.isEmpty()) {
            return List.of("UNKNOWN");
        }
        return people.stream()
                .map(person -> person.getFirstName())
                .toList();
    }

    //Create one instance of Bird and two instances of Cat together with owners
    //One of animals should be homeless (without owners)
    //Write method returning Set of objects - AnimalId - it should contain Animal name and the oldest person fullName
    private static Set<AnimalId> ex_3_4() {
        List<Animal> animals = Arrays.asList(
                new Bird("Sparrow", Set.of(new Person("Adam", "CXZ", 25)), 50),
                new Cat("Persik", Set.of(new Person("Dik", "HGF", 42),
                        new Person("Max", "HGF", 23))),
                new Cat("Cat", Set.of()));
        Set<AnimalId> animalIdSet = animals.stream()
                .map(animal -> new AnimalId(animal.getName(),
                        getFullName(getOldOfPersonOptional(animal.getOwners()))))
                .collect(Collectors.toSet());
        return animalIdSet;
    }

    private static Optional<Person> getOldOfPersonOptional(Set<Person> peoples) {
        return peoples.stream()
                .max(Comparator.comparingInt(Person::getAge));
    }
    private static String getFullName(Optional<Person> person){
        if (person.isEmpty()){
            return "UNKNOWN";
        }
        return person.get().getFirstName() + " " + person.get().getLastName();
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

    private static List<AnimalId> ex_3_5() {
        List<Animal> animals = Arrays.asList(
                new Bird("Sparrow1", Set.of(new Person("Adam", "CXZ", 25),
                        new Person("Adam", "CXZ", 23)), 1),
                new Bird("Sparrow2", Set.of(new Person("Adam", "CXZ", 12)), 2),
                new Bird("Sparrow4", Set.of(new Person("Adam", "CXZ", 15)), 4),
                new Bird("Sparrow5", Set.of(new Person("Adam", "CXZ", 20)), 5),
                new Cat("Persik3", Set.of(new Person("Dik", "HGF", 42),
                        new Person("Max", "HGF", 23)), 3),
                new Cat("Cat5", Set.of(),5),
                new Cat("Persik7", Set.of(new Person("Dik", "HGF", 42)),7),
                new Cat("Persik13", Set.of(new Person("Dik", "HGF", 42)),13));

        return animals.stream().sorted(Comparator.comparingInt(Animal::getSortValue))
                .map(animal -> new AnimalId(animal.getName(),
                        getFullName(getOldOfPersonOptional(animal.getOwners()))))
                .collect(Collectors.toList());

    }


}
