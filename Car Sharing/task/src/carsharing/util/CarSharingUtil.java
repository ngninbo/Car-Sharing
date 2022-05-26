package carsharing.util;

import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.model.Customer;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import static carsharing.util.CarSharingConstants.*;

public class CarSharingUtil {

    public static final String FORMATTED_OPTION = "%d. %s\n";

    public static <T> void printOptions(String key, List<T> list, boolean showBackOption) throws IOException {
        System.out.println(getText(key));
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

                    System.out.printf(FORMATTED_OPTION, i + 1, name);
                });

        if (showBackOption) {
            System.out.printf("%s. %s%n", 0, BACK_OPTION);
        }
    }

    public static void printOptions(List<String> options) {
        IntStream.range(0, options.size())
                .forEach(i -> System.out.printf(FORMATTED_OPTION,
                        BACK_OPTION.equals(options.get(i)) ? 0 : i + 1,
                        options.get(i))
                );
    }

    public static void displayMainMenu() {

        List<String> mainMenuOptions = List.of(
                "Log in as a manager",
                "Log in as a customer",
                "Create a customer",
                "Ext");

        IntStream.range(0, mainMenuOptions.size())
                .forEach(i -> System.out.printf(FORMATTED_OPTION,
                        "Exit".equals(mainMenuOptions.get(i)) ? 0 : i + 1,
                        mainMenuOptions.get(i)));
    }

    public static void println(String messageKey) throws IOException {
        System.out.println(getText(messageKey));
    }

    public static void printf(String textWithPlaceholder, String secondText, String lastText) throws IOException {
        System.out.printf(getText(textWithPlaceholder), secondText, lastText);
    }

    public static void printf(String textWithPlaceholder, String text) throws IOException {
        System.out.printf(getText(textWithPlaceholder), text);
    }

    public static boolean println() {
        System.out.println();
        return true;
    }

    public static String getText(String key) throws IOException {
        return PropertiesLoader.loadProperties("messages.properties").getProperty(key);
    }
}
