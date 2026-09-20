package session_seven_topics.class_problems;

public class LetterNote extends DeliveryNote {
    public LetterNote(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Letter note confirmed for tracking ID: " + trackingId;
    }
}
