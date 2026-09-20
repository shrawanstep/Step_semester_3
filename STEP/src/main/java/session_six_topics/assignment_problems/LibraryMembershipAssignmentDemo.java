package session_six_topics.assignment_problems;

public class LibraryMembershipAssignmentDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 1 ===");
        try {
            new LibraryMember("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("new LibraryMember(\"LB1\", 3) construction rejected");
        }

        StudentMember s = new StudentMember("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed());
        System.out.println(LibraryMember.enrollBatch(new String[]{"STU1", "LB1", "STU2", " ", "STU3"}, 3));

        System.out.println("\n=== Problem 2 ===");
        LibraryMember general = new LibraryMember("STU1", 3);
        StudentMember student = new StudentMember("STU2", 3, "CSE");
        HonorsStudentMember honors = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember faculty = new FacultyMember("STU4", 5, "Physics");

        student.borrowBook();
        student.borrowBook();
        honors.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();

        System.out.println(general.displayInfo());
        System.out.println(student.displayInfo());
        System.out.println(honors.displayInfo());
        System.out.println(faculty.displayInfo());
        System.out.println(LibraryMember.classifyGeneration(honors));
        System.out.println(LibraryMember.classifyGeneration(faculty));
        System.out.println(LibraryMember.getTotalBooksBorrowed(new LibraryMember[]{student, honors, faculty}));

        System.out.println("\n=== Problem 3 ===");
        StudentMember studentFine = new StudentMember("STU5", 3, "CSE");
        studentFine.chargeFine(100);
        System.out.println(studentFine.getTotalFine());
        int[] history = studentFine.getFineHistory();
        System.out.println(history.length);

        System.out.println("\n=== Problem 4 ===");
        System.out.println(LibraryMember.batchPrint(new LibraryMember[]{new LibraryMember("LB05", 3), new StudentMember("STU06", 3, "ECE")}));

        System.out.println("\n=== Problem 5 ===");
        LibraryMember member = new LibraryMember(3);
        System.out.println(member.memberNumber);
        System.out.println(LibraryMember.getMembersEnrolled());
        System.out.println(LibraryMember.isValidRenewalCode("R12A"));
        System.out.println(LibraryMember.isValidRenewalCode("R1A"));
        System.out.println(LibraryMember.isValidRenewalCode("X12A"));
        member.borrowBook();
        member.borrowBook("Fiction");
        System.out.println(member.getBooksBorrowed());
        System.out.println(LibraryMember.processNightlyAudit(new LibraryMember[]{new FacultyMember(5, "Physics"), null, new LibraryMember(3)}));
    }
}
