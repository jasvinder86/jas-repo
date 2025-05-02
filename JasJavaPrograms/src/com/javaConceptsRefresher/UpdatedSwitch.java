package com.javaConceptsRefresher;

public class UpdatedSwitch {

    public static void oldSwitch(String day) {
        switch (day) {
            case "Monday", "Friday":
                System.out.println("Weekday");
                break;
            case "Saturday", "Sunday":
                System.out.println("Weekend");
                break;
            default:
                System.out.println("not possible");
        }
    }

    /*
     * In this implementation, the break keyword is not required.
     * */
    public static void newSwitchReturnsNothing(String day) {
        switch (day) {
            case "Monday", "Friday" -> System.out.println("Weekday");
            case "Saturday", "Sunday" -> System.out.println("Weekend");
            default -> System.out.println("not possible");
        }
    }

    /*
     * This is the new behaviour along with the return type of the method.
     * */
    public static String newSwitchThatReturns(String day) {
        return switch (day) {
            case "Monday", "Friday" -> "Weekday";

            case "Saturday", "Sunday" -> "Weekend";

            default -> "not possible";

        };
    }

    public static void main(String[] args) {
        UpdatedSwitch.oldSwitch("Monday");
        UpdatedSwitch.oldSwitch("Saturday");

        UpdatedSwitch.newSwitchReturnsNothing("Saturday");
        UpdatedSwitch.newSwitchReturnsNothing("Monday");
        UpdatedSwitch.newSwitchReturnsNothing("");

        System.out.println(UpdatedSwitch.newSwitchThatReturns(""));
        System.out.println(UpdatedSwitch.newSwitchThatReturns("Monday"));
        System.out.println(UpdatedSwitch.newSwitchThatReturns("Saturday"));

    }
}
