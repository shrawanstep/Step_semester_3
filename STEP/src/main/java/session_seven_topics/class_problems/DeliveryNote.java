package session_seven_topics.class_problems;

public abstract class DeliveryNote {
    private final String trackingId;

    protected DeliveryNote(String trackingId) {
        this.trackingId = trackingId;
    }

    protected String getTrackingId() {
        return trackingId;
    }

    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }
}
