package session_five_topics.class_problems;

public final class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers != null ? java.util.Arrays.copyOf(seatNumbers, seatNumbers.length) : new String[0];
    }

    public String[] getSeatNumbers() {
        return java.util.Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] newSeats = getSeatNumbers();
        newSeats[index] = newSeat;
        return new BookingReceipt(this.bookingId, newSeats);
    }
}
