import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Field;


class HorseTest {

    private Horse horse;

    @Test
    void nameNullThrowException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, 1, 1));
        Assertions.assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\t\t", "\n\n\n\n\n\n"})
    void ifNameEmptyThrowException(String s) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Horse(s, 1, 1));
        Assertions.assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void speedNegativeThrowException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Horse("Horse", -1, 1));
        Assertions.assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    void distanceNegativeThrowException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Horse("Horse", 1, -1));
        Assertions.assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void shouldGetName() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse("Барсік", 25, 1);
        Assertions.assertEquals("Барсік", horse.getName());
    }

    @Test
    void shouldGetSpeed() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse("Horse", 99, 1);
        Assertions.assertEquals(99, horse.getSpeed());
    }

    @Test
    void shouldGetDistance() {
        Horse horse = new Horse("Horse", 1, 1);
        Assertions.assertEquals(1, horse.getDistance());
    }

    @Test
    void distanceShouldGetNullIfConstructorTwoParameter() {
        Horse horse = new Horse("Horse", 1);
        Assertions.assertEquals(0, horse.getDistance());
    }

    @Test
    void moveShouldGetValuesMethodInsideYourself() {

        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            new Horse("Horse", 1, 1).move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2,0.9));
        }
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.2,0.4,0.9,0.99,1.0})
    void verifyFormulaMethodGetRandomDouble(double result) {
       try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
           Horse horse = new Horse("Horse", 20, 300);
           mockedStatic.when(() -> Horse.getRandomDouble(0.2,0.9)).thenReturn(result);

           horse.move();
           Assertions.assertEquals(300+20*result, horse.getDistance());
       }
    }
}