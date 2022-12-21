package carsharing.util;

import java.util.List;

public class CarSharingConstants {

    public static final String BACK_OPTION = "Back";
    public static final String EXIT_OPTION = "Exit";

    public static final List<String> CUSTOMER_OPTIONS = List.of(
            "Rent a car",
            "Return a rented car",
            "My rented car",
            BACK_OPTION);

    public static final List<String> MANAGER_OPTIONS = List.of(
            "Company list",
            "Create a company",
            BACK_OPTION);

    public static final List<String> MAIN_OPTIONS = List.of(
            "Log in as a manager",
            "Log in as a customer",
            "Create a customer",
            "Exit");

    public static final List<String> COMPANY_OPTIONS = List.of(
            "Car list",
            "Create a car",
            BACK_OPTION);
}
