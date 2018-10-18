package com.chester.rediscache;

import lombok.Value;

import java.io.Serializable;

@Value(staticConstructor = "of")
public class Person implements Serializable {
    String name;
    int age;
    String title;
    boolean male;
}
