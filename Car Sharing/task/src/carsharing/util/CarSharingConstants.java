package carsharing.util;

import java.util.List;

public class CarSharingConstants {

    // Database properties
    public static final String DB_PATH = "./src/carsharing/db/";
    public static final String JDBC_DRIVER = "org.h2.Driver";

    // Menu items
    public static final String BACK_TXT = "0. Back";
    public static final String BACK_OPTION = "Back";
    public static List<String> mainMenuOptions = List.of(
            "Log in as a manager",
            "Log in as a customer",
            "Create a customer",
            "Exit");

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

    // SQL Statements
    public static final String TABLE_COMPANY_CREATION_WHEN_NOT_EXISTS_QUERY =
            "CREATE TABLE IF NOT EXISTS COMPANY " +
            "(ID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
            "NAME VARCHAR(30) UNIQUE NOT NULL" +
            ");";

    public static final String INSERT_INTO_COMPANY_NAME_VALUES_QUERY = "INSERT INTO COMPANY (NAME) VALUES (?);";
    public static final String FIND_ALL_COMPANIES_QUERY = "SELECT * FROM COMPANY ORDER BY ID ASC;";
    public static final String FIND_COMPANY_BY_ID_QUERY = "SELECT * FROM COMPANY WHERE ID = ?";

    public static final String TABLE_CUSTOMER_CREATION_WHEN_NOT_EXISTS_QUERY =
            "CREATE TABLE IF NOT EXISTS CUSTOMER (" +
            "   ID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
            "   NAME VARCHAR(30) UNIQUE NOT NULL," +
            "   RENTED_CAR_ID INTEGER DEFAULT NULL," +
            "   CONSTRAINT FK_CUSTOMER FOREIGN KEY (RENTED_CAR_ID) REFERENCES CAR(ID) " +
            "   ON UPDATE CASCADE " +
            "   ON DELETE SET NULL" +
            ");";

    public static final String INSERT_INTO_CUSTOMER_QUERY = "INSERT INTO CUSTOMER (NAME) VALUES (?);";
    public static final String FIND_CUSTOMER_BY_ID_QUERY = "SELECT * FROM CUSTOMER WHERE ID = ?";

    public static final String FIND_ALL_CUSTOMER_QUERY = "SELECT * FROM CUSTOMER ORDER BY ID ASC;";
    public static final String UPDATE_CUSTOMER_WHEN_CAR_RENT_QUERY = "UPDATE CUSTOMER " +
            "SET RENTED_CAR_ID = ? WHERE ID = ?";
    public static final String UPDATE_CUSTOMER_WHEN_RENT_CAR_RETURN_QUERY = "UPDATE CUSTOMER " +
            "SET RENTED_CAR_ID = NULL WHERE ID = ?";

    public static final String TABLE_CAR_CREATION_WHEN_NOT_EXITS_QUERY =
            "CREATE TABLE IF NOT EXISTS CAR (" +
            "ID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
            "NAME VARCHAR(30) UNIQUE NOT NULL, " +
            "COMPANY_ID INTEGER NOT NULL, " +
            "CONSTRAINT FK_CAR FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY(ID) " +
            "ON UPDATE CASCADE " +
            "ON DELETE SET NULL" +
            ");";

    public static final String INSERT_INTO_CAR_QUERY = "INSERT INTO CAR (NAME, COMPANY_ID) VALUES (?, ?);";
    public static final String FIND_ALL_CARD_BY_COMPANY_ID_QUERY = "SELECT * FROM CAR WHERE COMPANY_ID = ? ORDER BY ID";

    public static final String FIND_CAR_BY_ID_QUERY = "SELECT * FROM CAR WHERE ID = ?";
}
