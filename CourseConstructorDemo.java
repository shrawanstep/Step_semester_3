public class CourseConstructorDemo {
    String code,title;int credits,labCredits;
    CourseConstructorDemo(String code,String title,int credits,int labCredits){this.code=code;this.title=title;this.credits=credits;this.labCredits=labCredits;}
    CourseConstructorDemo(String code,String title,int credits){this(code,title,credits,0);}
    int totalCredits(){return credits+labCredits;}
    public static void main(String[] args){CourseConstructorDemo a=new CourseConstructorDemo("21CSC201J","Data Structures",4),b=new CourseConstructorDemo("21CSC205L","DSA Lab",3,1);System.out.println(a.code+" total credits: "+a.totalCredits());System.out.println(b.code+" total credits: "+b.totalCredits());}
}
