import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HorseTest {

    @Test
    void nameNullThrowException () {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, 1, 1));
            Assertions.assertEquals(exception.getMessage(),"Name cannot be null.");
    }

    @Test
    void shouldGetStringName() {


    }


    void getSpeed() {
    }


    void getDistance() {
    }


    void move() {
    }
}