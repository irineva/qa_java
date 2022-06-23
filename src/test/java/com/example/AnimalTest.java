package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {
    private final List<String> expectedList;
    private final String animalKind;

    public AnimalTest(List<String> expectedList, String animalKind) {
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


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getFoodExceptionTest() throws Exception {
        Animal animal = new Animal();
        String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        thrown.expect(Exception.class);
        thrown.expectMessage(expectedExceptionMessage);
        animal.getFood("котька");
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }
}