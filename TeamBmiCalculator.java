public class TeamBmiCalculator {
    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.82, 1.68, 1.72};
        double[] weights = {70, 90, 62, 75, 50};
        printWellnessReport(heights, weights);
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-6d | %-10.2f | %-11.1f | %-5.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }
}
