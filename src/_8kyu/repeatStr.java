package _8kyu;

public class repeatStr {
    public static String repeatStr(final int repeat, final String string) {
        String repeating = "";
        for (int i = 0; i < repeat; i++) {
            repeating += string;
        }
        return repeating;

//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < repeat; i++) {
//            sb.append(string);
//        }
//
//        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(repeatStr(6,"I"));
        System.out.println(repeatStr(5,"Hello"));
    }
}
