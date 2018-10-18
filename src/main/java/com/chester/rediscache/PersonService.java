package com.chester.rediscache;

import com.google.common.collect.ImmutableMap;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PersonService {
    Map<String, Person> people = ImmutableMap.of(
            "Chester", Person.of("Chester", 47, "Sr SWE", true),
            "Liz", Person.of("Liz", 37, "Teacher", false),
            "Isaac", Person.of("Isaac", 29, "PM", true),
            "Jamie", Person.of("Jamie", 25, "SWE", false),
            "Mike", Person.of("Mike", 24, "SWE", true)
    );

    @Cacheable(value="people", key="#name")
    public Person getPerson(String name) {
        return people.get(name);
    }
}
