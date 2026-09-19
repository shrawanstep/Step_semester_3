package session_five_topics.assignment_problems;

public final class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds != null ? java.util.Arrays.copyOf(bookIds, bookIds.length) : new String[0];
    }

    public String[] getBookIds() {
        return java.util.Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] newIds = getBookIds();
        newIds[index] = newId;
        return new LoanReceipt(this.memberId, newIds);
    }
}
