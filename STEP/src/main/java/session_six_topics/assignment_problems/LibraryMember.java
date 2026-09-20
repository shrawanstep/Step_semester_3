package session_six_topics.assignment_problems;

import java.util.Arrays;

public class LibraryMember {
    private static int nextMemberNumber = 100;

    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;
    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    public final String memberNumber;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("memberId must be at least 4 characters.");
        }
        if (borrowLimit <= 0) {
            throw new IllegalArgumentException("borrowLimit must be positive.");
        }

        this.memberId = memberId.trim();
        this.borrowLimit = borrowLimit;
        this.memberNumber = generateMemberNumber();
    }

    public LibraryMember(int borrowLimit) {
        if (borrowLimit <= 0) {
            throw new IllegalArgumentException("borrowLimit must be positive.");
        }

        this.memberId = "AUTO";
        this.borrowLimit = borrowLimit;
        this.memberNumber = generateMemberNumber();
    }

    private static String generateMemberNumber() {
        nextMemberNumber++;
        return "LIB-" + nextMemberNumber;
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public void borrowBook(String genre) {
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }

    protected void chargeFine(int amount) {
        if (fineCount >= fineHistory.length) {
            fineHistory = Arrays.copyOf(fineHistory, fineHistory.length + 10);
        }
        fineHistory[fineCount++] = amount;
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }
        return total;
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;

        for (String memberId : memberIds) {
            try {
                new LibraryMember(memberId, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(LibraryMember member) {
        if (member == null) {
            return "Unknown";
        }
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof StudentMember) {
            return "Student generation";
        }
        return "General generation";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        if (members == null) {
            return total;
        }
        for (LibraryMember member : members) {
            if (member != null) {
                total += member.getBooksBorrowed();
            }
        }
        return total;
    }

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder builder = new StringBuilder();
        for (LibraryMember member : members) {
            if (member == null) {
                continue;
            }
            builder.append(member.displayInfo());
            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;
                builder.append(" [Course via downcast: ")
                       .append(student.getCourse())
                       .append("]");
            }
            builder.append(" | ");
        }
        return builder.toString();
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'R') {
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

    public static int getMembersEnrolled() {
        return nextMemberNumber - 100;
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        if (members == null) {
            return "0 processed | 0 null skipped | 0 faculty | 0 regular";
        }

        for (LibraryMember member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (member instanceof FacultyMember) {
                faculty++;
            } else {
                regular++;
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
    }

    public String getMemberId() {
        return memberId;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }
}
