package _6kyu;


public class SpinWords {
    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversedWord = new StringBuilder();
        StringBuilder spunSentence = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                reversedWord.append(words[i]);
                reversedWord.reverse();
                words[i] = reversedWord.toString();
                reversedWord.setLength(0);
            }
            spunSentence.append(words[i]);
            if (i != (words.length - 1)) {
                spunSentence.append(" ");
            }
        }
        return spunSentence.toString();
    }

//    public String spinWords(String sentence) {
//        String[] words = sentence.split(" ");
//        for (int i=0; i<words.length; i++) {
//            if (words[i].length() >= 5) {
//                words[i] = new StringBuilder(words[i]).reverse().toString();
//            }
//        }
//        return String.join(" ",words);
//    }

    public static void main(String[] args) {
        SpinWords s = new SpinWords();
        System.out.println(s.spinWords("Hey fellow warriors"));
        System.out.println(s.spinWords("This is a test"));
        System.out.println(s.spinWords("This is another test"));
    }
}
