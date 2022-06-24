package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;

public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        Assert.assertEquals("Мяу", actualSound);
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> actualFoodList = cat.getFood();
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFoodList, actualFoodList);
    }
}