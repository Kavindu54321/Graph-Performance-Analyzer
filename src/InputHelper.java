import java.util.Scanner;

public class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    public static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = readLine();
            try {
                int v = Integer.parseInt(line.trim());
                if (v < min || v > max) {
                    System.out.println("  [!] Please enter a number between " + min + " and " + max + ".");
                } else {
                    return v;
                }
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input. Please enter a whole number.");
            }
        }
    }

    public static int readInt(String prompt) {
        return readInt(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static String readLabel(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = readLine().trim();
            if (s.isEmpty() || s.contains(" ")) {
                System.out.println("  [!] Label must be non-empty and contain no spaces.");
            } else {
                return s.toUpperCase();
            }
        }
    }

    private static String readLine() {
        if (!SC.hasNextLine()) {           
            System.out.println("\nInput closed. Exiting.");
            System.exit(0);
        }
        return SC.nextLine();
    }

    public static void pause() {
        System.out.print("\nPress Enter to continue...");
        readLine();
    }
}
