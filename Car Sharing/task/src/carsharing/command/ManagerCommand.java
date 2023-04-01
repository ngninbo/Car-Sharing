package carsharing.command;

import carsharing.controller.CompanyController;
import carsharing.controller.ControllerFactory;
import carsharing.menu.CompanyMenu;
import carsharing.menu.ListView;
import carsharing.model.Company;
import carsharing.util.CarSharingUtil;
import carsharing.menu.MenuItem;

import java.io.IOException;
import java.util.List;

import static carsharing.util.CarSharingUtil.enter;

public class ManagerCommand implements Command {

    private final CompanyController companyController;
    private final ControllerFactory factory;

    public ManagerCommand(ControllerFactory factory) {
        this.factory = factory;
        this.companyController = factory.getCompanyController();
    }

    protected void createCompany() throws IOException {
        String name = enter("COMPANY_NAME_INPUT_COMMAND");
        this.companyController.save(name);
        CarSharingUtil.println("COMPANY_CREATION_SUCCEED_MSG");
        System.out.println();
    }

    protected void showCompanyList() throws IOException {
        List<Company> companies = this.companyController.findAll();

        if (companies.isEmpty()) {
            CarSharingUtil.println("COMPANY_LIST_EMPTY_INFO");
            System.out.println();
        } else {
            process(companies);
        }
    }

    private void process(List<Company> companies) throws IOException {
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

    @Override
    public boolean execute(MenuItem item) throws IOException {
        switch (item) {
            case COMPANY_LIST:
                showCompanyList();
                break;
            case CREATE_A_COMPANY:
                createCompany();
                break;
            case BACK:
                System.out.println();
                return false;
        }

        return true;
    }
}
