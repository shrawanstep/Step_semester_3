public class IdCardReferenceDemo {
    String name;int booksIssued;
    IdCardReferenceDemo(String name,int booksIssued){this.name=name;this.booksIssued=booksIssued;}
    public static void main(String[] args){IdCardReferenceDemo ravi=new IdCardReferenceDemo("Ravi",0),duplicate=ravi,separate=new IdCardReferenceDemo("Ravi",3);duplicate.booksIssued=3;System.out.println("Ravi's booksIssued (via first variable): "+ravi.booksIssued);System.out.println("duplicate == ravi: "+(duplicate==ravi));System.out.println("separate == ravi: "+(separate==ravi));}
}
