package _8kyu;

public class XO {
    public static void main(String[] args) {
        int numO = 0;
        int numX = 0;
        String str = "xxxXooOo";
        String teststr = str.toLowerCase();
        for(int i = 0; i<str.length();i++){
            if(teststr.charAt(i)=='o'){
                numO++;
            }else if(teststr.charAt(i)=='x'){
                numX++;
            }
        }
        System.out.println(numO == numX);
    }
}
