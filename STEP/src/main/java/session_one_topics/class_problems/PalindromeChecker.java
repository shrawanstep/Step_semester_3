public class PalindromeChecker {
    public static void main(String[] args) {
        printResult("madam");
        printResult("hello");
    }

    static void printResult(String text) {
        System.out.println("Text: " + text);
        System.out.println("Iterative: " + result(isPalindromeIterative(text)));
        System.out.println("Recursive: " + result(isPalindromeRecursive(text)));
        System.out.println("Array Reversal: " + result(isPalindromeArrayReversal(text)));
    }

    static boolean isPalindromeIterative(String text) {
        for (int i = 0, j = text.length() - 1; i < j; i++, j--) {
            if (text.charAt(i) != text.charAt(j)) return false;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return checkRecursive(text, 0, text.length() - 1);
    }

    static boolean checkRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return checkRecursive(text, left + 1, right - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] letters = text.toCharArray();
        for (int i = 0, j = letters.length - 1; i < j; i++, j--) {
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return text.equals(new String(letters));
    }

    static String result(boolean value) {
        return value ? "Palindrome" : "Not Palindrome";
    }
}
