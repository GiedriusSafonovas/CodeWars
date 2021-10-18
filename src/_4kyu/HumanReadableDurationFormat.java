package _4kyu;

//Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.
//
//        The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
//
//        It is much easier to understand with an example:
//
//        TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
//        TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"
//
//        For the purpose of this Kata, a year is 365 days and a day is 24 hours.
//
//        Note that spaces are important.
//        Detailed rules
//
//        The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.
//
//        The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ", just like it would be written in English.
//
//        A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.
//
//        Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
//
//        A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.
//
//        A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanReadableDurationFormat {
    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        List<String> SList = Arrays.asList("seconds", "minutes", "hours", "days", "years");
        List<Integer> IList = Arrays.asList(0, 0, 0, 0, 0);
        ArrayList<String> components = new ArrayList<>();
        components.addAll(SList);
        ArrayList<Integer> time = new ArrayList<>();
        time.addAll(IList);
        time.set(0, seconds);
        for (int i = 0; i < time.size() - 1; i++) {
            int componentValue = time.get(i);
            switch (components.get(i)) {
                case "seconds":
                case "minutes":
                    time.set(i + 1, componentValue / 60);
                    time.set(i, componentValue % 60);
                    break;
                case "hours":
                    time.set(i + 1, componentValue / 24);
                    time.set(i, componentValue % 24);
                    break;
                case "days":
                    time.set(i + 1, componentValue / 365);
                    time.set(i, componentValue % 365);
                    break;
            }
        }

        while (time.contains(0)) {
            int indexToRemove = time.indexOf(0);
            components.remove(indexToRemove);
            time.remove(indexToRemove);
        }

        if (time.size() == 1) {
            return time.get(0) + " " + ((time.get(0) == 1) ? components.get(0).substring(0, components.get(0).length() - 1) : components.get(0));
        }

        StringBuilder result = new StringBuilder();

        for (int i = time.size() - 1; i >= 0; i--) {
            int componentValue = time.get(i);
            String componentName = components.get(i);
            if (i == 0) {
                result.deleteCharAt(result.length() - 2);
                if (componentValue == 1) {
                    result.append("and " + componentValue + " " + componentName.substring(0, componentName.length() - 1));
                } else {
                    result.append("and " + componentValue + " " + componentName);
                }
            } else {
                if (componentValue == 1) {
                    result.append(componentValue + " " + componentName.substring(0, componentName.length() - 1) + ", ");
                } else {
                    result.append(componentValue + " " + componentName + ", ");
                }
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(1));
        System.out.println(formatDuration(62));
        System.out.println(formatDuration(120));
        System.out.println(formatDuration(3600));
        System.out.println(formatDuration(3662));

    }
}
