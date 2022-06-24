package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Animal animal;

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualList = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualList);

    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);

    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getKittensWithKittensCountTest() {
        Feline feline = new Feline();
        int expectedKittensCount = 5;
        int actualKittensCount = feline.getKittens(expectedKittensCount);
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}