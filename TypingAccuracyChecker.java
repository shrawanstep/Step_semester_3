public class TypingAccuracyChecker {
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }

    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Both texts must have the same length.");
            return;
        }

        int matches = 0;
        int firstMismatch = -1;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = original.length() == 0 ? 100 : matches * 100.0 / original.length();
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matches, original.length(), accuracy);
        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n",
                    firstMismatch + 1, original.charAt(firstMismatch), typed.charAt(firstMismatch));
        }
    }
}
