package session_seven_topics.class_problems;

public class PrintableDemo {
    public static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }
}
