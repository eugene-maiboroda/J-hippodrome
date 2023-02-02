import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

    @Test
    void ifNullThrowException() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(null));
        Assertions.assertEquals("Horses cannot be null.", exception.getMessage());

    }
    @Test
    void ifListEmptyThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(new ArrayList<>()));
        Assertions.assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void shouldGetListHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30 ; i++) {
            horses.add(new Horse("Horse " + i, i + 2));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        Assertions.assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    void shouldInduceMove() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);

        hippodrome.move();

        for (Horse horse: horses) {
            verify(horse).move();
        }

    }

    @Test
    void getWinner() {
        Horse horse1 = new Horse("Horse1",1,2);
        Horse horse2 = new Horse("Horse1",1,5);
        Horse horse3 = new Horse("Horse1",1,3);
        Hippodrome hippodrome = new Hippodrome(List.of(horse1,horse2,horse3));
        Assertions.assertSame(horse2,hippodrome.getWinner());
    }
}