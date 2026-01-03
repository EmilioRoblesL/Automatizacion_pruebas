package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void testSuma() {
        int resultado = 2 + 3;
        assertEquals(5, resultado);
    }

    @Test
    public void testResta() {
        int resultado = 5 - 2;
        assertEquals(3, resultado);
    }
}
