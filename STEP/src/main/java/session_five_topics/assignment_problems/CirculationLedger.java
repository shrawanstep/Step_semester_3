package session_five_topics.assignment_problems;

public class CirculationLedger {
    private static final String SHARED_BRANCH_CODE;
    
    static {
        SHARED_BRANCH_CODE = "MAIN_BRANCH";
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int refOnly = 0;
        int regular = 0;
        for (LoanReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
            } else {
                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) {
                    refOnly++;
                } else {
                    regular++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + refOnly + " reference-only | " + regular + " regular";
    }
}
