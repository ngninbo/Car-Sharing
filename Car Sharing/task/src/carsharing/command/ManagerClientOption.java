package carsharing.command;

import carsharing.controller.CompanyController;
import carsharing.controller.ControllerFactory;
import carsharing.menu.CompanyMenu;
import carsharing.menu.ListView;
import carsharing.model.Company;
import carsharing.util.CarSharingUtil;
import carsharing.util.MenuItem;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ManagerClientOption {

    private final CompanyController companyController;
    private final ControllerFactory factory;

    public ManagerClientOption(ControllerFactory factory) {
        this.factory = factory;
        this.companyController = factory.getCompanyController();
    }

    public void createCompany() throws IOException {
        CarSharingUtil.println("COMPANY_NAME_INPUT_COMMAND");
        String name = new Scanner(System.in).nextLine();
        this.companyController.save(name);
        CarSharingUtil.println("COMPANY_CREATION_SUCCEED_MSG");
        System.out.println();
    }

    public void manage() throws IOException {
        List<Company> companies = this.companyController.findAll();

        if (companies.isEmpty()) {
            CarSharingUtil.println("COMPANY_LIST_EMPTY_INFO");
        } else {

            CompanyMenu companyMenu = new CompanyMenu(factory);
            MenuItem item = MenuItem.UNKNOWN;

            while (!companyMenu.process(item)) {
                int companyIndex = new ListView<>(companies).choice("COMPANY_CHOICE_COMMAND") - 1;

                if (companyIndex == -1) {
                    System.out.println();
                    return;
                } else {
                    Company company = companies.get(companyIndex);
                    CarSharingUtil.printf("COMPANY_NAME_LABEL", company.getName());
                    companyMenu.setCompany(company);
                    while (!companyMenu.process(item)) {
                        item = companyMenu.getMenuItemFromInput(companyMenu.display());
                    }
                }
            }
        }
    }
}
