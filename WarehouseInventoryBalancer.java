public class WarehouseInventoryBalancer {
    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length || sectionA.length == 0) {
            System.out.println("Both sections must have the same non-zero number of items.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int highest = sectionA[0];
        String section = "A";
        int item = 1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                section = "A";
                item = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                section = "B";
                item = i + 1;
            }
        }

        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status + " | Highest Quantity: " + highest
                + " (Section " + section + ", Item " + item + ")");
    }
}
