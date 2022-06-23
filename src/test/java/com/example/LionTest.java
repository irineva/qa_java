package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final String checkedSex;
    private final boolean expectedSex;

    public LionTest(String checkedSex, boolean expectedSex) {
        this.checkedSex = checkedSex;
        this.expectedSex = expectedSex;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

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
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(checkedSex, feline);
        boolean actualSex = lion.doesHaveMane();
        assertEquals(expectedSex, actualSex);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldCreatingLionThrowExceptionTest() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        new Lion("котёнок", feline);
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