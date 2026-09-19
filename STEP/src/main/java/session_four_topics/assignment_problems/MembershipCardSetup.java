public class MembershipCardSetup {
    static String libraryName;
    static String validUntil;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    String studentName;

    MembershipCardSetup(String studentName) {
        this.studentName = studentName;
    }

    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};
        for (int i = 0; i < names.length; i++) {
            MembershipCardSetup card = new MembershipCardSetup(names[i]);
            System.out.println("Membership card issued: " + card.studentName);
        }
    }
}
