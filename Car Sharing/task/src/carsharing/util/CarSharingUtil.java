package carsharing.util;

import java.io.IOException;
import java.util.Scanner;

public class CarSharingUtil {

    public static final String FORMATTED_OPTION = "%d. %s\n";

    public static String enter(String command) throws IOException {
        CarSharingUtil.println(command);
        return new Scanner(System.in).nextLine();
    }

    public static int modulo(int a, int b) {
        return a % b;
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
        return PropertiesLoader.getInstance().messages().getProperty(key);
    }
}
