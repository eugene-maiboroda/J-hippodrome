
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        List<Horse> horses = List.of(
                new Horse("Thunder", 2.4),
                new Horse("Blackjack", 2.5),
                new Horse("Zephyr", 2.6),
                new Horse("Blaze", 2.7),
                new Horse("Storm", 2.8),
                new Horse("Pegasus", 2.9),
                new Horse("Cherry", 3.0)
        );
        Hippodrome hippodrome = new Hippodrome(horses);
        logger.info("Race started. Number of participants: {}", horses.size());
        for (int i = 0; i < 4; i++) {
            hippodrome.move();
            watch(hippodrome);
            TimeUnit.MILLISECONDS.sleep(200);
        }


        String winnerName = hippodrome.getWinner().getName();
        logger.info("Race finished. Winner: {}", winnerName);
        System.out.println("Winner is " + winnerName + "!");
    }

    private static void watch(Hippodrome hippodrome) throws Exception {
        hippodrome.getHorses().stream()
                .map(horse -> ".".repeat((int) horse.getDistance()) + horse.getName())
                .forEach(System.out::println);
        System.out.println("\n".repeat(10));
    }
}
