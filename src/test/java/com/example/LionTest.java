package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittensCount = lion.getKittens();
        assertEquals(1, actualKittensCount);
    }

    @Test
    public void shouldCreatingLionThrowExceptionTest() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("котёнок", feline));
        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного - самец или самка"));
    }


    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualList = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualList);
    }

    @Test(expected = Exception.class)
    public void shouldGettingLionThrowExceptionTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenThrow(Exception.class);
        lion.getFood();
    }

}