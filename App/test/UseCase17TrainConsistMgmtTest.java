import static org.junit.jupiter.api.Assertions.*;

class UseCase17TrainConsistMgmtTest {


    void sort(String[] arr) {
        Arrays.sort(arr);
    }

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        sort(input);

        assertArrayEquals(expected, input);
    }
}