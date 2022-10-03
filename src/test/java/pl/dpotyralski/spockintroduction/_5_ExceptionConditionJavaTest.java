package pl.dpotyralski.spockintroduction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class _5_ExceptionConditionJavaTest {

    ExceptionProvider exceptionProvider = new ExceptionProvider();

    @Test
    public void testExceptionHandling() {
        //when
        UnsupportedOperationException e = assertThrows(UnsupportedOperationException.class, () -> exceptionProvider.operationUnsupported());
        //then
        assertEquals("Operation is not supported!", e.getMessage());
    }

}
