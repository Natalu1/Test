package com.company.ex3;

import com.company.ex2.Person;

import java.util.Set;

public class Bird extends Animal{

    private int flySpeed;

    @Override
    void giveVoice() {
        System.out.println(super.getName() + " - ćwir ćwir");
    }

    public Bird(String name, Set<Person> owners, int flySpeed) {
        super(name, owners);
        this.flySpeed = flySpeed;
    }
}
