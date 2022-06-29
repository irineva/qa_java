package com.example;

import org.junit.Test;


import static org.junit.Assert.*;


public class AnimalTest {

    @Test
    public void getFoodExceptionTest() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class,
                () -> animal.getFood("коть"));
        assertTrue(exception.getMessage().contains("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }
}