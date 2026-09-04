public class FilteredWordFrequencyReport {
    public static void main(String[] args) { printFilteredWordFrequency("The mentor was great, the session was great and clear."); }
    static void printFilteredWordFrequency(String feedback) {
        String[] words=feedback.toLowerCase().replace(",","").replace(".","").split("\\s+"); String[] unique=new String[words.length]; int[] counts=new int[words.length]; int size=0;
        for(int i=0;i<words.length;i++) { if(isStopWord(words[i])) continue; int p=-1; for(int j=0;j<size;j++) if(unique[j].equals(words[i])) p=j; if(p==-1) {unique[size]=words[i]; counts[size++]=1;} else counts[p]++; }
        for(int i=0;i<size-1;i++) for(int j=i+1;j<size;j++) if(counts[j]>counts[i]) {int c=counts[i];counts[i]=counts[j];counts[j]=c;String w=unique[i];unique[i]=unique[j];unique[j]=w;}
        for(int i=0;i<size;i++) System.out.println(unique[i]+": "+counts[i]);
    }
    static boolean isStopWord(String w) { String[] stop={"the","was","and","a","is","of","in"}; for(int i=0;i<stop.length;i++) if(w.equals(stop[i])) return true; return false; }
}
