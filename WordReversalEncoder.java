public class WordReversalEncoder {
    public static void main(String[] args) { System.out.println(reverseEachWord("hello club")); }
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" "); StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length; i++) { StringBuilder word = new StringBuilder(); for (int j = words[i].length()-1; j >= 0; j--) word.append(words[i].charAt(j)); if (i > 0) answer.append(' '); answer.append(word); }
        return answer.toString();
    }
}
