package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String checkedSex;
    private final boolean expectedSex;

    public LionParametrizedTest(String checkedSex, boolean expectedSex) {
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
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(checkedSex, feline);
        boolean actualSex = lion.doesHaveMane();
        assertEquals(expectedSex, actualSex);
    }

}