import java.util.ArrayList;
import java.util.List;

public class ResultsLog {
    private static final List<String> ENTRIES = new ArrayList<>();

    public static void add(String entry) { ENTRIES.add(entry); }

    public static void displayAll() {
        System.out.println("\n=============================================");
        System.out.println("ALL RESULTS (this session)");
        System.out.println("=============================================");
        if (ENTRIES.isEmpty()) System.out.println("No results recorded yet. Run some operations first.");
        for (int i = 0; i < ENTRIES.size(); i++) System.out.printf("%3d. %s%n", i + 1, ENTRIES.get(i));
        System.out.println("=============================================");
    }
}
