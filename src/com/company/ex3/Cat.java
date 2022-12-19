package com.company.ex3;

import com.company.ex2.Person;

import java.util.Collections;
import java.util.Set;

public class Cat extends Animal {

    private int tailLength;

    public Cat(String name, Set<Person> owners) {
        super(name, owners);
    }

    public Cat(String name, int tailLength) {
        super(name, Collections.emptySet());
        this.tailLength = tailLength;
    }

    @Override
    void giveVoice() {
        System.out.println(super.getName() + " - Miau");
    }

}
