package carsharing.util;

import java.util.List;

public class CarSharingConstants {

    // Menu items
    public static final String BACK_TXT = "0. Back";
    public static final String BACK_OPTION = "Back";
    public static final String EXIT_OPTION = "Exit";
    public static List<String> mainMenuOptions = List.of(
            "Log in as a manager",
            "Log in as a customer",
            "Create a customer",
            EXIT_OPTION);

    public static List<String> managerMenuOptions = List.of(
            "Company list",
            "Create a company",
            BACK_OPTION);

    public static List<String> carMenuOptions = List.of(
            "Car list",
            "Create a car",
            BACK_OPTION);

    public static List<String> customerMenuOptions = List.of(
            "Rent a car",
            "Return a rented car",
            "My rented car",
            BACK_OPTION);

    // Outputs messages
    public static final String COMPANY_LIST_EMPTY_INFO = "\nThe company list is empty!";
    public static final String COMPANY_CHOICE_COMMAND = "\nChoose the company:";
    public static final String COMPANY_NAME_LABEL = "\n'%s' company:\n";
    public static final String COMPANY_LABEL = "Company:";
    public static final String COMPANY_CREATION_SUCCEED_MSG = "The company was created!";
    public static final String COMPANY_NAME_INPUT_COMMAND = "\nEnter the company name: ";

    public static final String CUSTOMER_CREATION_SUCCEED_MSG = "The customer was add!\n";
    public static final String CUSTOMER_LIST_EMPTY_INFO = "\nThe customer list is empty!\n";
    public static final String CUSTOMER_LIST_LABEL = "\nCustomer list:";
    public static final String CUSTOMER_NAME_INPUT_COMMAND = "\nEnter the customer name: ";
    public static final String CUSTOMER_RENT_CAR_INFO = "\nYour rented car:";
    public static final String CUSTOMER_CAR_NOT_RENT_INFO = "\nYou didn't rent a car!";
    public static final String CUSTOMER_CAR_ALREADY_RENT_INFO = "\nYou've already rented a car!";
    public static final String CUSTOMER_RENT_CAR_NAME_INFO = "\nYou rented '%s'\n";
    public static final String CUSTOMER_RENT_CAR_RETURN_SUCCEED_MSG = "\nYou've returned a rented car!";
    public static final String CUSTOMER_CAR_CHOICE_COMMAND = "\nChoose a car:";

    public static final String CAR_NAME_INPUT_COMMAND = "\nEnter the car name: ";
    public static final String CAR_CREATION_SUCCEED_MSG = "The car was add!\n";
    public static final String CAR_LIST_EMPTY_INFO = "\nThe car list is empty!\n";
    public static final String CAR_LIST_OVERVIEW_LABEL = "\nCar list:";
    public static final String CAR_IN_COMPANY_NO_AVAILABLE_INFO = "\nNo available cars in the %s company\n";


}
