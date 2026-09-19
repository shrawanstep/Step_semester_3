public class ReverseCustomerName {
    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversedName = reverseCustomerName(customerName);
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }

    static String reverseCustomerName(String customerName) {
        char[] letters = customerName.toCharArray();
        for (int i = 0, j = letters.length - 1; i < j; i++, j--) {
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }
}
