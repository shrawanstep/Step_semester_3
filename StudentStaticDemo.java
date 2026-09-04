public class StudentStaticDemo {
    String name;double attendance;static String collegeName="SRM Institute of Science and Technology";static int studentCount;
    StudentStaticDemo(String name,double attendance){this.name=name;this.attendance=attendance;studentCount++;}
    static void printCollegeInfo(){System.out.println(collegeName);System.out.println("Students created: "+studentCount);}
    public static void main(String[] args){new StudentStaticDemo("Ravi",90);new StudentStaticDemo("Meera",95);printCollegeInfo();}
}
