public class LibraryIsbnValidator {
    public static void main(String[] args) { System.out.println(validateAndFormat(normalizeCode(" pen2026004251 "))); System.out.println(validateAndFormat(normalizeCode("12N2026004251"))); }
    static String normalizeCode(String raw) { String s=raw.trim(); return s.length()<3?s:s.substring(0,3).toUpperCase()+s.substring(3); }
    static String validateAndFormat(String s) {
        if(s.length()!=13) return "Invalid: wrong length";
        for(int i=0;i<3;i++) if(!Character.isLetter(s.charAt(i))) return "Invalid: publisher code must be 3 letters";
        for(int i=3;i<13;i++) if(!Character.isDigit(s.charAt(i))) return "Invalid: body must contain digits only";
        return "["+s.substring(0,3)+"] YEAR: "+s.substring(3,7)+" | CATALOG: "+s.substring(7);
    }
}
