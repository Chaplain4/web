package main.homework;

import main.homework.model.Dog;

import java.util.Set;

public interface DogDAO {
    Dog findById(int id);

    Set<Dog> all();
}
