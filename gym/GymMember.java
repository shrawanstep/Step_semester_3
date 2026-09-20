package gym;

import java.util.Arrays;

// Problem 1: Validation and batch sign-up
// Problem 2: Inheritance hierarchy and session totals
// Problem 3: Late-fee logic and history tracking
// Problem 4: Polymorphic batch printing
// Problem 5: Membership numbers, referral validation, fee payment and weekly check-ins
public class GymMember {
    private static int nextMembershipNumber = 2000;

    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;
    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;
    private int feesPaid = 0;

    public final String membershipNumber;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("memberId must be at least 4 characters.");
        }
        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("monthlyFee must be positive.");
        }

        this.memberId = memberId.trim();
        this.monthlyFee = monthlyFee;
        this.membershipNumber = generateMembershipNumber();
    }

    public GymMember(int monthlyFee) {
        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("monthlyFee must be positive.");
        }

        this.memberId = "AUTO";
        this.monthlyFee = monthlyFee;
        this.membershipNumber = generateMembershipNumber();
    }

    private static String generateMembershipNumber() {
        nextMembershipNumber++;
        return "GYM-" + nextMembershipNumber;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String memberId : memberIds) {
            try {
                new GymMember(memberId, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    protected void chargeLateFee(int amount) {
        if (lateFeeCount >= lateFeeHistory.length) {
            lateFeeHistory = Arrays.copyOf(lateFeeHistory, lateFeeHistory.length + 10);
        }
        lateFeeHistory[lateFeeCount++] = amount;
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'G') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }
        return true;
    }

    public static String classifyGeneration(GymMember member) {
        if (member == null) {
            return "Unknown";
        }
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof PremiumMember) {
            return "Premium generation";
        }
        return "Standard generation";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        if (members == null) {
            return total;
        }
        for (GymMember member : members) {
            if (member != null) {
                total += member.getSessionsAttended();
            }
        }
        return total;
    }

    public static String batchPrint(GymMember[] members) {
        StringBuilder builder = new StringBuilder();
        for (GymMember member : members) {
            if (member == null) {
                continue;
            }
            builder.append(member.displayInfo());
            if (member instanceof PremiumMember premiumMember) {
                builder.append(" [Trainer via downcast: ")
                       .append(premiumMember.getTrainerName())
                       .append("]");
            }
            builder.append(" | ");
        }
        return builder.toString();
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        if (members == null) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }

        for (GymMember member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }

    public static int getMembersEnrolled() {
        return nextMembershipNumber - 2000;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }
}
