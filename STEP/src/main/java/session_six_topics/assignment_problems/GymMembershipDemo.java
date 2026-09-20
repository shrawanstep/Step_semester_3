package session_six_topics.assignment_problems;

public class GymMembershipDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Validation and Batch Sign-Up ===");
        try {
            new GymMember("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("new GymMember(\"GM1\", 1000) construction rejected");
        }
        System.out.println(GymMember.signUpBatch(new String[]{"MEM1", "GM1", "MEM2", " ", "MEM3"}, 1000));

        System.out.println("\n=== Problem 2: Inheritance and Classification ===");
        GymMember standard = new GymMember("MEM1", 1000);
        PremiumMember premium = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember elite = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember group = new GroupClassMember("MEM4", 1500, "Zumba");

        System.out.println(standard.displayInfo());
        System.out.println(premium.displayInfo());
        System.out.println(elite.displayInfo());
        System.out.println(group.displayInfo());
        System.out.println(GymMember.classifyGeneration(elite));
        System.out.println(GymMember.classifyGeneration(group));
        System.out.println(GymMember.getTotalSessionsAttended(new GymMember[]{premium, elite, group}));

        System.out.println("\n=== Problem 3: Late Fees ===");
        premium.chargeLateFee(200);
        System.out.println(premium.getTotalLateFees());
        int[] history = premium.getLateFeeHistory();
        System.out.println(history.length);

        System.out.println("\n=== Problem 4: Batch Print ===");
        System.out.println(GymMember.batchPrint(new GymMember[]{standard, premium}));

        System.out.println("\n=== Problem 5: Membership Number, Referral Codes and Weekly Check-in ===");
        GymMember member1 = new GymMember(1000);
        System.out.println(member1.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());
        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(GymMember.isValidReferralCode("G4B"));
        System.out.println(GymMember.isValidReferralCode("X45B"));
        member1.payFee(500);
        member1.payFee(500, "UPI");
        System.out.println(member1.getFeesPaid());
        System.out.println(GymMember.processWeeklyCheckIn(new GymMember[]{new GroupClassMember(1500, "Zumba"), null, new GymMember(1000)}));
    }
}
