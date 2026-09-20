package session_seven_topics.class_problems;

public class ParcelNote extends DeliveryNote {
    public ParcelNote(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Parcel " + getTrackingId() + " delivered";
    }
}
