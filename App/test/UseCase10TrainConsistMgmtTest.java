import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;

class UseCase10TrainConsistMgmtTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    int totalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        assertEquals(152, totalCapacity(bogies));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 10),
                new Bogie("B", 20),
                new Bogie("C", 30)
        );

        assertEquals(60, totalCapacity(bogies));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Collections.singletonList(
                new Bogie("Sleeper", 72)
        );

        assertEquals(72, totalCapacity(bogies));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        assertEquals(0, totalCapacity(bogies));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("X", 5),
                new Bogie("Y", 15)
        );

        int result = totalCapacity(bogies);
        assertEquals(20, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 1),
                new Bogie("B", 2),
                new Bogie("C", 3),
                new Bogie("D", 4)
        );

        assertEquals(10, totalCapacity(bogies));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("A", 10));
        bogies.add(new Bogie("B", 20));

        int sizeBefore = bogies.size();

        totalCapacity(bogies);

        assertEquals(sizeBefore, bogies.size());
        assertEquals(10, bogies.get(0).capacity);
        assertEquals(20, bogies.get(1).capacity);
    }
}