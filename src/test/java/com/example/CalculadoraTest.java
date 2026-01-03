package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    void sumaTest() {
        int resultado = 2 + 3;
        assertEquals(5, resultado);
    }

    @Test
    void restaTest() {
        int resultado = 5 - 2;
        assertEquals(3, resultado);
    }
}
