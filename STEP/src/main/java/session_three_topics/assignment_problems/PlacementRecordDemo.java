public class PlacementRecordDemo {
    String studentName, company; double packageLpa;
    PlacementRecordDemo(String studentName,String company,double packageLpa){this.studentName=studentName;this.company=company;this.packageLpa=packageLpa;}
    void printRecord(){System.out.println(studentName+" | "+company+" | "+packageLpa+" LPA");}
    public static void main(String[] args){PlacementRecordDemo[] a={new PlacementRecordDemo("Ravi","TCS",4.5),new PlacementRecordDemo("Meera","Infosys",5.2),new PlacementRecordDemo("Karthik","Wipro",4.0)};for(int i=0;i<a.length;i++)a[i].printRecord();}
}
