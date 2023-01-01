package com.company.ex3;

import com.company.ex2.Person;

import java.util.Set;
import java.util.stream.Collectors;

public class Bird extends Animal{

    private int flySpeed;

    @Override
    void giveVoice() {
        System.out.println(super.getName() + " - ćwir ćwir");
    }

    @Override
    int getSortValue() {
        return flySpeed*2;
    }


    public Bird(String name, Set<Person> owners, int flySpeed) {
        super(name, owners);
        this.flySpeed = flySpeed;
    }
}
