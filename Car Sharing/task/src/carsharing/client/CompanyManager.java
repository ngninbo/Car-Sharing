package carsharing.client;

import carsharing.command.CompanyManagerOption;
import carsharing.controller.CarController;
import carsharing.model.Company;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CompanyManager {

    private final List<Company> companies;

    private final CarController carController;

    private boolean exit;

    public CompanyManager(List<Company> companies, CarController controller) {
        this.companies = companies;
        this.carController = controller;
    }

    public boolean isExit() {
        return exit;
    }

    public void exit() {
        this.exit = true;
    }

    public void manage(int companyIndex) throws IOException {
        Company company = companies.get(companyIndex);
        CarSharingUtil.printf("COMPANY_NAME_LABEL", company.getName());
        System.out.println();

        CompanyManagerOption companyManagerOption = new CompanyManagerOption(carController);

        do {
            CarSharingUtil.printCompanyOptions();
            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    companyManagerOption.showCarList(companyIndex);
                    break;
                case 2:
                    companyManagerOption.createCar(companyIndex);
                    break;
                case 0:
                    companyManagerOption.setExit(true);
                    break;
            }
        } while (!companyManagerOption.close());
    }
}
