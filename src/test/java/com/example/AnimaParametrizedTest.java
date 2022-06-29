package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimaParametrizedTest {
    private final List<String> expectedList;
    private final String animalKind;

    public AnimaParametrizedTest(List<String> expectedList, String animalKind) {
        this.expectedList = expectedList;
        this.animalKind = animalKind;
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][]{
                {List.of("Трава", "Различные растения"), "Травоядное"},
                {List.of("Животные", "Птицы", "Рыба"), "Хищник"},
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> actualList = animal.getFood(animalKind);
        assertEquals(expectedList, actualList);
    }

}