package session_seven_topics.class_problems;

public class PrintableDemo {
    public static void main(String[] args) {
        ToyCar car = new ToyCar("Speedster");
        ToyRobot robot = new ToyRobot("Bolt");

        System.out.println(car.makeSound());
        System.out.println(robot.makeSound());
        System.out.println(car.getToyId());
        System.out.println(robot.getToyId());

        PackageBox box = new PackageBox("TRK-88");
        Invoice invoice = new Invoice("INV-42");
        System.out.println(box.printLabel());
        System.out.println(invoice.printLabel());
        printAll(new Printable[]{box, invoice});

        Instrument instrument = new StringInstrument();
        System.out.println(instrument.play());
        Violin violin = new Violin();
        System.out.println(violin.play());

        Blender blender = new Blender();
        blender.setSpeedLevel(3);
        System.out.println(blender.getSpeedLevel());
        blender.setSpeedLevel(9);
        System.out.println(blender.prepare());
        System.out.println(blender.clean());

        ParcelNote parcel = new ParcelNote("TRK-1");
        System.out.println(parcel.confirmDelivery());
        System.out.println(parcel.confirmDelivery("J. Smith"));
        logAll(new DeliveryNote[]{parcel, new LetterNote("TRK-2")});
    }

    static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }
}
