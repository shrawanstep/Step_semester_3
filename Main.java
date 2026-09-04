import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

/**
 * Day 1 live-coding exercises. Each problem is isolated in a small, reusable type
 * so that the demonstrations in {@link #main(String[])} do not contain business logic.
 */
public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        demonstrateRockPaperScissors();
        demonstratePalindromes();
        demonstrateBmiReport();
        demonstrateFirstNonRepeatingCharacter();
        demonstrateNameReversal();
    }

    private static void demonstrateRockPaperScissors() {
        System.out.println("=== Rock-Paper-Scissors ===");
        RockPaperScissorsGame game = new RockPaperScissorsGame(new Random(7));
        for (Move playerMove : List.of(Move.ROCK, Move.PAPER, Move.SCISSORS, Move.ROCK)) {
            RoundResult result = game.playRound(playerMove);
            System.out.printf("Player: %-8s Computer: %-8s Result: %s%n",
                    result.playerMove(), result.computerMove(), result.outcome());
        }
        System.out.println(game.summary());
        System.out.println();
    }

    private static void demonstratePalindromes() {
        System.out.println("=== Palindrome Checker ===");
        String value = "A man, a plan, a canal: Panama";
        boolean iterative = PalindromeChecker.isPalindromeIterative(value);
        boolean recursive = PalindromeChecker.isPalindromeRecursive(value);
        boolean reversed = PalindromeChecker.isPalindromeByArrayReversal(value);
        require(iterative && recursive && reversed, "Palindrome sample should pass every approach.");
        System.out.printf("%-36s | Iterative | Recursive | Array reversal%n", "Input");
        System.out.printf("%-36s | %-9s | %-9s | %-14s%n", value, iterative, recursive, reversed);
        System.out.println();
    }

    private static void demonstrateBmiReport() {
        System.out.println("=== Team BMI Calculator ===");
        List<TeamMember> team = List.of(
                new TeamMember("Asha", 1.60, 50.0),
                new TeamMember("Ben", 1.80, 81.0),
                new TeamMember("Chen", 1.70, 95.0));
        System.out.println(BmiCalculator.formatReport(team));
    }

    private static void demonstrateFirstNonRepeatingCharacter() {
        System.out.println("=== First Non-Repeating Character ===");
        String input = "swiss";
        Optional<Character> result = FirstNonRepeatingCharacter.find(input);
        require(result.orElseThrow() == 'w', "Expected 'w' for swiss.");
        System.out.printf("Input: %-10s First non-repeating: %s%n%n", input,
                result.map(String::valueOf).orElse("<none>"));
    }

    private static void demonstrateNameReversal() {
        System.out.println("=== Reverse Customer Name ===");
        char[] customerName = "Grace Hopper".toCharArray();
        ReverseCustomerName.reverseInPlace(customerName);
        String reversed = new String(customerName);
        require("reppoH ecarG".equals(reversed), "Name reversal sample should pass.");
        System.out.printf("Reversed customer name: %s%n", reversed);
    }

    private static void require(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }

    public enum Move {
        ROCK, PAPER, SCISSORS;

        boolean defeats(Move other) {
            return (this == ROCK && other == SCISSORS)
                    || (this == PAPER && other == ROCK)
                    || (this == SCISSORS && other == PAPER);
        }
    }

    public enum Outcome {
        WIN, LOSS, DRAW
    }

    public record RoundResult(Move playerMove, Move computerMove, Outcome outcome) {
    }

    /** Stateful game service that tracks result statistics across rounds. */
    public static final class RockPaperScissorsGame {
        private final Random random;
        private int wins;
        private int losses;
        private int draws;

        public RockPaperScissorsGame(Random random) {
            this.random = Objects.requireNonNull(random, "random must not be null");
        }

        public RoundResult playRound(Move playerMove) {
            Objects.requireNonNull(playerMove, "playerMove must not be null");
            Move computerMove = Move.values()[random.nextInt(Move.values().length)];
            Outcome outcome = playerMove == computerMove ? Outcome.DRAW
                    : playerMove.defeats(computerMove) ? Outcome.WIN : Outcome.LOSS;
            record(outcome);
            return new RoundResult(playerMove, computerMove, outcome);
        }

        public GameSummary summary() {
            return new GameSummary(wins, losses, draws);
        }

        private void record(Outcome outcome) {
            switch (outcome) {
                case WIN -> wins++;
                case LOSS -> losses++;
                case DRAW -> draws++;
            }
        }
    }

    public record GameSummary(int wins, int losses, int draws) {
        public int totalRounds() {
            return wins + losses + draws;
        }

        @Override
        public String toString() {
            return String.format("Summary: %d rounds | %d wins | %d losses | %d draws",
                    totalRounds(), wins, losses, draws);
        }
    }

    public static final class PalindromeChecker {
        private PalindromeChecker() {
        }

        public static boolean isPalindromeIterative(String value) {
            String normalized = normalize(value);
            int left = 0;
            int right = normalized.length() - 1;
            while (left < right) {
                if (normalized.charAt(left++) != normalized.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isPalindromeRecursive(String value) {
            String normalized = normalize(value);
            return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
        }

        public static boolean isPalindromeByArrayReversal(String value) {
            String normalized = normalize(value);
            char[] characters = normalized.toCharArray();
            ReverseCustomerName.reverseInPlace(characters);
            return normalized.equals(new String(characters));
        }

        private static boolean isPalindromeRecursive(String value, int left, int right) {
            return left >= right || (value.charAt(left) == value.charAt(right)
                    && isPalindromeRecursive(value, left + 1, right - 1));
        }

        private static String normalize(String value) {
            Objects.requireNonNull(value, "value must not be null");
            return value.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
        }
    }

    public record TeamMember(String name, double heightMeters, double weightKilograms) {
        public TeamMember {
            Objects.requireNonNull(name, "name must not be null");
            if (name.isBlank() || heightMeters <= 0 || weightKilograms <= 0) {
                throw new IllegalArgumentException("Name, height, and weight must be valid positive values.");
            }
        }
    }

    public enum BmiStatus {
        UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESE
    }

    public static final class BmiCalculator {
        private BmiCalculator() {
        }

        public static double calculate(double weightKilograms, double heightMeters) {
            if (weightKilograms <= 0 || heightMeters <= 0) {
                throw new IllegalArgumentException("Weight and height must be positive.");
            }
            return weightKilograms / (heightMeters * heightMeters);
        }

        public static BmiStatus classify(double bmi) {
            if (bmi < 18.5) return BmiStatus.UNDERWEIGHT;
            if (bmi < 25.0) return BmiStatus.NORMAL;
            if (bmi < 30.0) return BmiStatus.OVERWEIGHT;
            return BmiStatus.OBESE;
        }

        public static String formatReport(List<TeamMember> team) {
            Objects.requireNonNull(team, "team must not be null");
            StringBuilder report = new StringBuilder("Name       | Height (m) | Weight (kg) | BMI   | Status\n")
                    .append("-----------+------------+-------------+-------+------------\n");
            for (TeamMember member : team) {
                double bmi = calculate(member.weightKilograms(), member.heightMeters());
                report.append(String.format(Locale.ROOT, "%-10s | %10.2f | %11.1f | %5.1f | %s%n",
                        member.name(), member.heightMeters(), member.weightKilograms(), bmi, classify(bmi)));
            }
            return report.toString();
        }
    }

    public static final class FirstNonRepeatingCharacter {
        private FirstNonRepeatingCharacter() {
        }

        /** Uses a frequency map followed by an ordered scan to preserve input order. */
        public static Optional<Character> find(String value) {
            Objects.requireNonNull(value, "value must not be null");
            Map<Character, Integer> frequencies = new LinkedHashMap<>();
            for (char character : value.toCharArray()) {
                frequencies.merge(character, 1, Integer::sum);
            }
            for (char character : value.toCharArray()) {
                if (frequencies.get(character) == 1) {
                    return Optional.of(character);
                }
            }
            return Optional.empty();
        }
    }

    public static final class ReverseCustomerName {
        private ReverseCustomerName() {
        }

        /** Reverses the supplied character array without allocating a second character array. */
        public static void reverseInPlace(char[] characters) {
            Objects.requireNonNull(characters, "characters must not be null");
            for (int left = 0, right = characters.length - 1; left < right; left++, right--) {
                char temporary = characters[left];
                characters[left] = characters[right];
                characters[right] = temporary;
            }
        }
    }
}
