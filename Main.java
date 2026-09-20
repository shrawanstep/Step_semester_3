public class Main {
    public static void main(String[] args) {
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

        premium.chargeLateFee(200);
        System.out.println(premium.getTotalLateFees());

        System.out.println(GymMember.signUpBatch(new String[]{"MEM1", "GM1", "MEM2", " ", "MEM3"}, 1000));
        System.out.println(GymMember.batchPrint(new GymMember[]{standard, premium}));

        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(GymMember.isValidReferralCode("G4B"));
        System.out.println(GymMember.isValidReferralCode("X45B"));

        GymMember member1 = new GymMember(1000);
        member1.payFee(500);
        member1.payFee(500, "UPI");
        System.out.println(member1.getFeesPaid());
        System.out.println(member1.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());

        System.out.println(GymMember.processWeeklyCheckIn(new GymMember[]{new GroupClassMember(1500, "Zumba"), null, new GymMember(1000)}));
    }
}
