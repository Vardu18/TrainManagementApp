import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;

class UseCase8TrainConsistMgmtTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    List<Bogie> filter(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 80),
                new Bogie("B", 60)
        );

        List<Bogie> result = filter(bogies, 70);

        assertEquals(1, result.size());
        assertTrue(result.get(0).capacity > 70);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 70)
        );

        List<Bogie> result = filter(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 60)
        );

        List<Bogie> result = filter(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 80),
                new Bogie("B", 90),
                new Bogie("C", 60)
        );

        List<Bogie> result = filter(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 60)
        );

        List<Bogie> result = filter(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 80),
                new Bogie("B", 90)
        );

        List<Bogie> result = filter(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filter(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("A", 80));
        bogies.add(new Bogie("B", 60));

        int sizeBefore = bogies.size();

        filter(bogies, 70);

        assertEquals(sizeBefore, bogies.size());
        assertEquals(80, bogies.get(0).capacity);
        assertEquals(60, bogies.get(1).capacity);
    }
}