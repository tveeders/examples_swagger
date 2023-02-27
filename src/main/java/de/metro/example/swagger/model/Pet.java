package de.metro.example.swagger.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Jacksonized
@Value
public class Pet {
    String name;
    int age;
    List<String> preferredFood;
    List<Color> color;
    Color eyeColor;
    boolean hungry;
    boolean thirsty;
    String owner;
    AnimalType animalType;
}
