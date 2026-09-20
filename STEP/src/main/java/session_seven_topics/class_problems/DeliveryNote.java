package session_seven_topics.class_problems;

public abstract class DeliveryNote {
    protected String trackingId;

    public DeliveryNote(String trackingId) {
        this.trackingId = trackingId;
    }

    public abstract String confirmDelivery();

    public String confirmDelivery(String recipient) {
        return "Delivery confirmed for " + recipient + " (tracking: " + trackingId + ")";
    }
}
