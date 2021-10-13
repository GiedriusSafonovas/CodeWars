package _6kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class ValidBraces {
    public boolean isValidother(String braces) {
        boolean valid = true;
        String[] bracesLst = braces.split("");
        String[] braceType = {"(", "[", "{"};
        ArrayList<Integer> prOpPos = new ArrayList<>();
        ArrayList<Integer> prClPos = new ArrayList<>();
        ArrayList<Integer> brkOpPos = new ArrayList<>();
        ArrayList<Integer> brkClPos = new ArrayList<>();
        ArrayList<Integer> brcOpPos = new ArrayList<>();
        ArrayList<Integer> brcClPos = new ArrayList<>();
        String brace = "";

        for (int i = 0; i < bracesLst.length; i++) {
            brace = bracesLst[i];
            switch (brace){
                case "(":
                    prOpPos.add(i);
                    break;
                case ")":
                    prClPos.add(i);
                    break;
                case "[":
                    brkOpPos.add(i);
                    break;
                case "]":
                    brkClPos.add(i);
                    break;
                case "{":
                    brcOpPos.add(i);
                    break;
                case "}":
                    brcClPos.add(i);
                    break;
            }
        }

        if(prOpPos.size() != prClPos.size() || brkOpPos.size() != brkClPos.size() || brcOpPos.size() != brcClPos.size()) return false;

        for (int i = 0; i < prOpPos.size(); i++) {
            if(prOpPos.get(i)>prClPos.get(i)){
                return false;
            }
        }
        for (int i = 0; i < brkOpPos.size(); i++) {
            if(brkOpPos.get(i)>brkClPos.get(i)){
                return false;
            }
        }
        for (int i = 0; i < brcOpPos.size(); i++) {
            if(brcOpPos.get(i)>brcClPos.get(i)){
                return false;
            }
        }
        return true;
    }

    public boolean isValid(String braces) {
        LinkedList<Character> openingBraces = new LinkedList<>(Arrays.asList('(','[','{'));
        LinkedList<Character> closingBraces = new LinkedList<>(Arrays.asList(')',']','}'));
        LinkedList<Character> openedBraces = new LinkedList<>();
        for (int i = 0; i < braces.length(); i++) {
            if(openingBraces.contains(braces.charAt(i))){
                openedBraces.add(braces.charAt(i));
            }else{
                if (openedBraces.size() == 0) return false;
                if(openingBraces.indexOf(openedBraces.getLast()) == closingBraces.indexOf(braces.charAt(i))){
                    openedBraces.removeLast();
                }else{
                    return false;
                }
            }
        }
        if(openedBraces.size()>0) return false;
        return true;

//        String b = braces;
//        System.out.println(braces);
//        for(int i=0;i<braces.length()/2;i++)
//        {
//            b = b.replaceAll("\\(\\)", "");
//            b = b.replaceAll("\\[\\]", "");
//            b = b.replaceAll("\\{\\}", "");
//            if(b.length() == 0)
//                return true;
//        }
//        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidBraces().isValid("(){}[]" ));
        System.out.println(new ValidBraces().isValid("([{}])" ));
        System.out.println(new ValidBraces().isValid("(}"));
        System.out.println(new ValidBraces().isValid("[(])" ));
        System.out.println(new ValidBraces().isValid("[({})](]" ));
        System.out.println(new ValidBraces().isValid("(((("));

    }
}

//    Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.
//
//        This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!
//
//        All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
//        What is considered Valid?
//
//        A string of braces is considered valid if all braces are matched with the correct brace.
//        Examples
//
//        "(){}[]"   =>  True
//        "([{}])"   =>  True
//        "(}"       =>  False
//        "[(])"     =>  False
//        "[({})](]" =>  False

