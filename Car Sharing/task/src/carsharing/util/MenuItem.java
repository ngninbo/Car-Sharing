package carsharing.util;

import java.util.List;
import java.util.stream.Collectors;

public enum MenuItem {

    LOG_IN_AS_A_MANAGER,
    LOG_IN_AS_A_CUSTOMER,
    CREATE_A_CUSTOMER,
    RENT_A_CAR,
    RETURN_A_RENTED_CAR,
    MY_RENTED_CAR,
    COMPANY_LIST,
    CREATE_A_COMPANY,
    CAR_LIST,
    CREATE_A_CAR,
    EXIT,
    BACK,
    UNKNOWN;

    public static final List<MenuItem> MAIN_MENU_OPTIONS = List.of(LOG_IN_AS_A_MANAGER, LOG_IN_AS_A_CUSTOMER, CREATE_A_CUSTOMER, EXIT);
    public static final List<MenuItem> CUSTOMER_MENU_OPTIONS = List.of(RENT_A_CAR, RETURN_A_RENTED_CAR, MY_RENTED_CAR, BACK);
    public static final List<MenuItem> COMPANY_MENU_OPTIONS = List.of(CAR_LIST, CREATE_A_CAR, BACK);
    public static final List<MenuItem> MANAGER_OPTIONS = List.of(COMPANY_LIST, CREATE_A_COMPANY, BACK);

    public static List<String> main() {
        return toList(MAIN_MENU_OPTIONS);
    }

    public static List<String> customer() {
        return toList(CUSTOMER_MENU_OPTIONS);
    }

    public static List<String> company() {
        return toList(COMPANY_MENU_OPTIONS);
    }

    public String getName() {
        return capitalize();
    }

    public String capitalize() {
        String name = replaceUnderscore();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }

    private static List<String> toList(List<MenuItem> items) {
        return items.stream()
                .map(menuItem -> String.format("%d. %s\n", (items.indexOf(menuItem) + 1) % items.size(), menuItem.getName()))
                .collect(Collectors.toList());
    }

    private String replaceUnderscore() {
        return name().replace("_", " ");
    }
}
