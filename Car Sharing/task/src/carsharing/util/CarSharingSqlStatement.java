package carsharing.util;

public class CarSharingSqlStatement {

    // Database properties
    public static final String DB_PATH = "./src/carsharing/db/";
    public static final String JDBC_DRIVER = "org.h2.Driver";

    // SQL Statements for table COMPANY
    public static final String TABLE_COMPANY_CREATION_WHEN_NOT_EXISTS_QUERY =
            "CREATE TABLE IF NOT EXISTS COMPANY " +
                    "(ID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    "NAME VARCHAR(30) UNIQUE NOT NULL" +
                    ");";

    public static final String INSERT_INTO_COMPANY_NAME_VALUES_QUERY = "INSERT INTO COMPANY (NAME) VALUES (?);";
    public static final String FIND_ALL_COMPANIES_QUERY = "SELECT * FROM COMPANY ORDER BY ID ASC;";
    public static final String FIND_COMPANY_BY_ID_QUERY = "SELECT * FROM COMPANY WHERE ID = ?";

    // SQL Statements for table CUSTOMER
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

    // SQL Statements for Table CAR
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
