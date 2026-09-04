import java.util.Locale;
import java.util.Objects;

/** Demonstrates the five Week 1 array and string programming exercises. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        System.out.println("=== 1. Exam Hall Seat Duplication Checker ===");
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});

        System.out.println("\n=== 2. Typing Speed Test Accuracy Checker ===");
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");

        System.out.println("\n=== 3. Traffic Signal Streak Analyzer ===");
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");

        System.out.println("\n=== 4. Warehouse Inventory Balancer ===");
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});

        System.out.println("\n=== 5. Movie Review Word Length Profiler ===");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }

    /** Prints each distinct seat number that occurs more than once, using arrays and loops only. */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        Objects.requireNonNull(seatNumbers, "seatNumbers must not be null");
        boolean duplicateFound = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            if (appearsEarlier(seatNumbers, i)) continue;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }
        if (!duplicateFound) System.out.println("No Duplicate Seats Found");
    }

    private static boolean appearsEarlier(int[] values, int currentIndex) {
        for (int index = 0; index < currentIndex; index++) {
            if (values[index] == values[currentIndex]) return true;
        }
        return false;
    }

    /** Compares equal-length strings and prints accuracy plus the first mismatch, if any. */
    public static void checkTypingAccuracy(String original, String typed) {
        validateEqualLengthTexts(original, typed);
        int matches = 0;
        int firstMismatch = -1;
        for (int index = 0; index < original.length(); index++) {
            if (original.charAt(index) == typed.charAt(index)) {
                matches++;
            } else if (firstMismatch == -1) {
                firstMismatch = index;
            }
        }
        double accuracy = original.isEmpty() ? 100.0 : (matches * 100.0) / original.length();
        System.out.printf(Locale.ROOT, "Matched: %d/%d | Accuracy: %.2f%%", matches, original.length(), accuracy);
        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n",
                    firstMismatch + 1, original.charAt(firstMismatch), typed.charAt(firstMismatch));
        }
    }

    private static void validateEqualLengthTexts(String original, String typed) {
        Objects.requireNonNull(original, "original must not be null");
        Objects.requireNonNull(typed, "typed must not be null");
        if (original.length() != typed.length()) {
            throw new IllegalArgumentException("Original and typed text must have equal length.");
        }
    }

    /** Finds the color and length of the first longest continuous signal streak. */
    public static void findLongestStreak(String signalLog) {
        Objects.requireNonNull(signalLog, "signalLog must not be null");
        if (signalLog.isEmpty()) {
            System.out.println("Signal log is empty; no streak found.");
            return;
        }
        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        char currentColor = longestColor;
        int currentLength = 1;
        for (int index = 1; index < signalLog.length(); index++) {
            char reading = signalLog.charAt(index);
            if (reading == currentColor) currentLength++;
            else { currentColor = reading; currentLength = 1; }
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }
        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, longestLength);
    }

    /** Prints totals, balance state, and the earliest location of the highest quantity. */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        validateInventory(sectionA, sectionB);
        int totalA = 0, totalB = 0, highestQuantity = Integer.MIN_VALUE, highestIndex = -1;
        char highestSection = 'A';
        for (int index = 0; index < sectionA.length; index++) {
            totalA += sectionA[index];
            if (sectionA[index] > highestQuantity) {
                highestQuantity = sectionA[index]; highestSection = 'A'; highestIndex = index;
            }
        }
        for (int index = 0; index < sectionB.length; index++) {
            totalB += sectionB[index];
            if (sectionB[index] > highestQuantity) {
                highestQuantity = sectionB[index]; highestSection = 'B'; highestIndex = index;
            }
        }
        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (Section %c, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestIndex + 1);
    }

    private static void validateInventory(int[] sectionA, int[] sectionB) {
        Objects.requireNonNull(sectionA, "sectionA must not be null");
        Objects.requireNonNull(sectionB, "sectionB must not be null");
        if (sectionA.length != sectionB.length || sectionA.length == 0) {
            throw new IllegalArgumentException("Both sections must be non-empty arrays of equal length.");
        }
    }

    /** Counts short (1-4), medium (5-8), and long (9+) words in a review. */
    public static void classifyWordLengths(String review) {
        Objects.requireNonNull(review, "review must not be null");
        int shortWords = 0, mediumWords = 0, longWords = 0;
        String trimmedReview = review.trim();
        if (!trimmedReview.isEmpty()) {
            for (String word : trimmedReview.split("\\s+")) {
                int letterCount = countLetters(word);
                if (letterCount >= 1 && letterCount <= 4) shortWords++;
                else if (letterCount <= 8) mediumWords++;
                else longWords++;
            }
        }
        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortWords, mediumWords, longWords);
    }

    private static int countLetters(String word) {
        int count = 0;
        for (int index = 0; index < word.length(); index++) {
            if (Character.isLetter(word.charAt(index))) count++;
        }
        return count;
    }
}
