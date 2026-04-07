import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UseCase14TrainConsistMgmtTest {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String name;
        int capacity;

        PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        PassengerBogie b = new PassengerBogie("Sleeper", 72);
        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception e = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", e.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception e = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC Chair", 0);
        });
        assertEquals("Capacity must be greater than zero", e.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception e = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("First Class", 0);
        });
        assertEquals("Capacity must be greater than zero", e.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        PassengerBogie b = new PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", b.name);
        assertEquals(72, b.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("AC Chair", 56);
        PassengerBogie b3 = new PassengerBogie("First Class", 24);

        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
    }
}