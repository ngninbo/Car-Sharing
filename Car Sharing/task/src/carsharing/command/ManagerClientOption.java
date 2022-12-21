package carsharing.command;

import carsharing.client.CompanyManager;
import carsharing.controller.CarController;
import carsharing.controller.CompanyController;
import carsharing.model.Company;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static carsharing.util.CarSharingConstants.BACK_OPTION;

public class ManagerClientOption {

    private final CompanyController companyController;

    public ManagerClientOption(CompanyController companyController) {
        this.companyController = companyController;
    }

    public void createCompany() throws IOException {
        CarSharingUtil.println("COMPANY_NAME_INPUT_COMMAND");
        String name = new Scanner(System.in).nextLine();
        this.companyController.save(name);
        CarSharingUtil.println("COMPANY_CREATION_SUCCEED_MSG");
    }

    public void manage(CarController carController) throws IOException {
        List<Company> companies = this.companyController.findAll();

        if (companies.isEmpty()) {
            CarSharingUtil.println("COMPANY_LIST_EMPTY_INFO");
        } else {

            CompanyManager companyManager = new CompanyManager(companies, carController);

            while (!companyManager.isExit()) {
                CarSharingUtil.printOptions("COMPANY_CHOICE_COMMAND", companies);
                System.out.printf("%s. %s%n", 0, BACK_OPTION);
                int companyIndex = new Scanner(System.in).nextInt() - 1;

                if (companyIndex == -1) {
                    companyManager.exit();
                } else {
                    companyManager.manage(companyIndex);
                }
            }
        }
    }
}
