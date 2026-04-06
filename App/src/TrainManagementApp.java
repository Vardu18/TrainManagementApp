import java.util.*;

public class TrainManagementApp {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("========================================\n");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);
        System.out.println("\nSystem ready for operations...");
    }
}
class TrainConsistApp {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("========================================\n");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + passengerBogies);

        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper"));

        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nUC2 operations completed successfully...");
    }
}
class TrainConsistApp2 {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("========================================\n");

        Set<String> bogies = new HashSet<>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");
        bogies.add("BG101");
        bogies.add("BG102");

        System.out.println("Unique Bogie IDs:");
        System.out.println(bogies);

        System.out.println("\nUC3 operations completed successfully...");
    }
}
class UseCase4TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("========================================\n");

        List<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        trainConsist.add(2, "Pantry");

        System.out.println("\nAfter Inserting Pantry at position 2:");
        System.out.println(trainConsist);

        ((LinkedList<String>) trainConsist).removeFirst();
        ((LinkedList<String>) trainConsist).removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(trainConsist);

        System.out.println("\nUC4 operations completed successfully...");
    }
}
class UseCase5TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("========================================\n");

        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nUC5 operations completed successfully...");
    }
}
class UseCase6TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC6 - Map Bogie to Capacity ");
        System.out.println("========================================\n");

        Map<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        System.out.println("Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nUC6 operations completed successfully...");
    }
}
class UseCase7TrainConsistMgmt {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}
class UseCase8TrainConsistMgmt {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC8 operations completed successfully...");
    }
}
class UseCase9TrainConsistMgmt {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 58));

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("Grouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " :");
            for (Bogie b : entry.getValue()) {
                System.out.println("  " + b.name + " -> " + b.capacity);
            }
        }
        System.out.println("\nUC9 operations completed successfully...");
    }
}
class UseCase10TrainConsistMgmt {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity:");
        System.out.println(totalSeats);

        System.out.println("\nUC10 operations completed successfully...");
    }
}
class UseCase11TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Codes ");
        System.out.println("========================================\n");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        System.out.println("Train ID: " + trainId);
        if (trainMatcher.matches()) {
            System.out.println("Valid Train ID");
        } else {
            System.out.println("Invalid Train ID");
        }

        System.out.println("\nCargo Code: " + cargoCode);
        if (cargoMatcher.matches()) {
            System.out.println("Valid Cargo Code");
        } else {
            System.out.println("Invalid Cargo Code");
        }

        System.out.println("\nUC11 operations completed successfully...");
    }
}
class UseCase12TrainConsistMgmt {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC12 - Safety Compliance Check ");
        System.out.println("========================================\n");

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("Goods Bogies:");
        for (GoodsBogie b : bogies) {
            System.out.println(b.type + " -> " + b.cargo);
        }

        System.out.println("\nSafety Compliance Status:");
        System.out.println(isSafe ? "Train is SAFE for operation" : "Train is NOT SAFE for operation");

        System.out.println("\nUC12 operations completed successfully...");
    }
}
class UseCase13Peformance {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC13 - Performance Comparison ");
        System.out.println("========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 70 + (i % 50)));
        }

        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 90) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 90)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();

        System.out.println("Loop Execution Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Execution Time (ns): " + (endStream - startStream));

        System.out.println("\nUC13 performance comparison completed...");
    }
}