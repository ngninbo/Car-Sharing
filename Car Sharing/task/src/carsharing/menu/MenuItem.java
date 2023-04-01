package carsharing.menu;

import java.util.List;

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

    public static List<MenuItem> mainMenuItems() {
        return List.of(LOG_IN_AS_A_MANAGER, LOG_IN_AS_A_CUSTOMER, CREATE_A_CUSTOMER, EXIT);
    }

    public static List<MenuItem> customerMenuItems() {
        return List.of(RENT_A_CAR, RETURN_A_RENTED_CAR, MY_RENTED_CAR, BACK);
    }

    public static List<MenuItem> companyMenuItems() {
        return List.of(CAR_LIST, CREATE_A_CAR, BACK);
    }

    public static List<MenuItem> managerMenuItems() {
        return List.of(COMPANY_LIST, CREATE_A_COMPANY, BACK);
    }

    public String getName() {
        return capitalize();
    }

    public String capitalize() {
        String name = replaceUnderscore();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }

    private String replaceUnderscore() {
        return name().replace("_", " ");
    }
}
