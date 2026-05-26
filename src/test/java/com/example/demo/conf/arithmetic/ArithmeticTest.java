package com.example.demo.conf.arithmetic;

import com.example.demo.endpoint.service.arithmetic.ArithmeticService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.junit.jupiter.api.Test;
@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class ArithmeticTest {
    private final ArithmeticService arithmeticService;
    public ArithmeticTest(ArithmeticService arithmeticService) {
        this.arithmeticService = arithmeticService;
    }
    @Test
    public void testArithmeticAdd() {
        assertEquals(5, arithmeticService.add(2, 3));
        assertEquals(-1, arithmeticService.add(2, -3));
    }

    @Test
    public void testArithmeticSubtract() {
        assertEquals(3, arithmeticService.subtract(5, 2));
        assertEquals(-5, arithmeticService.subtract(-2, 3));
    }

    @Test
    public void testArithmeticMultiply() {
        assertEquals(10, arithmeticService.multiply(2, 5));
    }

    @Test
    public void testArithmeticDivide() {
        assertEquals(2.5, arithmeticService.divide(5, 2));
    }

    @Test
    public void testArithmeticDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> arithmeticService.divide(5, 0));
        assertThrows(IllegalArgumentException.class, () -> arithmeticService.divide(5, 0));
    }

    @Test
    public void testArithmeticAddOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            arithmeticService.add(Integer.MAX_VALUE, 1);
        });
    }

    @Test
    public void testArithmeticDividePrecision() {
        assertEquals(0.3333, arithmeticService.divide(1, 3), 0.0001);
    }

}
