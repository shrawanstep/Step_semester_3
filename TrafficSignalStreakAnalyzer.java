public class TrafficSignalStreakAnalyzer {
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }

    static void findLongestStreak(String signalLog) {
        if (signalLog.length() == 0) {
            System.out.println("Signal log is empty");
            return;
        }

        char longestColor = signalLog.charAt(0);
        char currentColor = longestColor;
        int longestLength = 1;
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentLength++;
            } else {
                currentColor = signalLog.charAt(i);
                currentLength = 1;
            }
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }
}
