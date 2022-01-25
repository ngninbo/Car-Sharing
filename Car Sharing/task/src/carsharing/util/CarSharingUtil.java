package carsharing.util;

import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.model.Customer;

import java.util.List;
import java.util.stream.IntStream;

import static carsharing.util.CarSharingConstants.*;

public class CarSharingUtil {

    public static <T> void printOptions(String command, List<T> list, boolean showBackOption) {
        System.out.println(command);
        IntStream
                .range(0, list.size())
                .forEach(i -> {
                    String name;
                    if (list.get(i) instanceof Customer) {
                        name = ((Customer) list.get(i)).getName();
                    } else if (list.get(i) instanceof Car) {
                        name = ((Car) list.get(i)).getName();
                    } else if (list.get(i) instanceof Company) {
                        name = ((Company) list.get(i)).getName();
                    } else {
                        name = (String) list.get(i);
                    }

                    System.out.printf("%d. %s\n", i + 1, name);
                });

        if (showBackOption) {
            System.out.println(BACK_TXT);
        }
    }

    public static void printOptions(List<String> options) {
        IntStream.range(0, options.size())
                .forEach(i -> System.out.printf("%d. %s\n",
                        BACK_OPTION.equals(options.get(i)) ? 0 : i + 1,
                        options.get(i))
                );
    }


    public static void displayMainMenu() {

        IntStream.range(0, mainMenuOptions.size())
                .forEach(i -> System.out.printf("%d. %s\n",
                        EXIT_OPTION.equals(mainMenuOptions.get(i)) ? 0 : i + 1,
                        mainMenuOptions.get(i)));
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void printf(String textWithPlaceholder, String secondText, String lastText) {
        System.out.printf(textWithPlaceholder, secondText, lastText);
    }

    public static void printf(String textWithPlaceholder, String text) {
        System.out.printf(textWithPlaceholder, text);
    }

    public static boolean println() {
        System.out.println();
        return true;
    }
}
