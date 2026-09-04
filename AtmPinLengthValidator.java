public class AtmPinLengthValidator {
    public static void main(String[] args) { checkPinLength("482"); checkPinLength("4820"); }
    static void checkPinLength(String pin) { System.out.println(pin.length() == 4 ? "PIN length OK." : "Invalid PIN - must be exactly 4 digits."); }
}
