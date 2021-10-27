package _4kyu;

//Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.
//
//        Example:
//
//        Given an input string of:
//
//        apples, pears # and bananas
//        grapes
//        bananas !apples
//
//        The output expected would be:
//
//        apples, pears
//        grapes
//        bananas
//
//        The code would be called like so:
//
//        var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
// result should == "apples, pears\ngrapes\nbananas"


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        for (int i = 0; i < commentSymbols.length; i++) {
            if(commentSymbols[i].equals("$")){
                commentSymbols[i] = "\\$";
            }
        }
        StringBuilder result = new StringBuilder();
        List<String> lines = new ArrayList<>();
        String toAppend = "";
        lines.addAll(Arrays.asList(text.split("\n")));
        for (int i = 0; i < lines.size(); i++) {
            toAppend = lines.get(i);
            for (int j = 0; j < commentSymbols.length; j++) {
                try {
                    toAppend = toAppend.split(commentSymbols[j])[0].stripTrailing();
                }catch (ArrayIndexOutOfBoundsException e){
                    toAppend = "";
                    break;
                }
            }
            result.append(toAppend + "\n");
        }
        return result.deleteCharAt(result.length()-1).toString();
    }


    public static void main(String[] args) {
        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" }));
        System.out.println(stripComments("a #b\nc   c\nd $e f g", new String[] { "#", "$" }));
        System.out.println(stripComments("a", new String[] {"a"}));


    }
}
