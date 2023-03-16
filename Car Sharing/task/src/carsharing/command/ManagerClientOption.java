package carsharing.command;

import carsharing.controller.CompanyController;
import carsharing.controller.ControllerFactory;
import carsharing.menu.CompanyMenu;
import carsharing.menu.ListMenu;
import carsharing.model.Company;
import carsharing.util.CarSharingUtil;

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
    }

    public void manage() throws IOException {
        List<Company> companies = this.companyController.findAll();

        if (companies.isEmpty()) {
            CarSharingUtil.println("COMPANY_LIST_EMPTY_INFO");
        } else {

            CompanyMenu companyMenu = new CompanyMenu(factory);

            while (true) {
                int companyIndex = new ListMenu<>(companies).choice("COMPANY_CHOICE_COMMAND") - 1;

                if (companyIndex == -1) {
                    System.out.println();
                    return;
                } else {
                    companyMenu.setCompanyIndex(companyIndex).process();
                }
            }
        }
    }
}
