package carsharing.menu;

import carsharing.controller.CarController;
import carsharing.controller.ControllerFactory;
import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.util.CarSharingUtil;
import carsharing.util.MenuItem;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CompanyMenu extends Menu {

    private final ControllerFactory factory;
    private CarController controller;

    private int companyIndex;

    public CompanyMenu(ControllerFactory factory) {
        super(MenuItem.COMPANY_MENU_OPTIONS);
        this.factory = factory;
        this.controller = factory.getCarController();
    }

    @Override
    protected int display() {
        System.out.println();
        return choice();
    }

    @Override
    protected boolean process(MenuItem item) throws IOException {

        switch (item) {
            case CAR_LIST:
                showCarList(companyIndex);
                break;
            case CREATE_A_CAR:
                createCar(companyIndex);
                break;
            case BACK:
                menuItem = MenuItem.UNKNOWN;
                return false;
        }

        return true;
    }

    @Override
    public void process() throws IOException {

        Company company = factory.getCompanyController().findAll().get(companyIndex);
        CarSharingUtil.printf("COMPANY_NAME_LABEL", company.getName());

        super.process();
    }

    public Menu setCompanyIndex(int companyIndex) {
        this.companyIndex = companyIndex;
        return this;
    }

    private void createCar(int companyId) throws IOException {
        CarSharingUtil.println("CAR_NAME_INPUT_COMMAND");
        String name = new Scanner(System.in).nextLine();
        boolean saveSucceed = this.controller.save(name, companyId);
        if (saveSucceed) {
            CarSharingUtil.println("CAR_CREATION_SUCCEED_MSG");
            System.out.println();
        }
    }

    private void showCarList(int companyId) throws IOException {
        List<Car> cars = this.controller.findCarByCompanyId(companyId);
        if (cars.isEmpty()) {
            CarSharingUtil.println("CAR_LIST_EMPTY_INFO");
        } else {
            new ListMenu<>(cars).display("CAR_LIST_OVERVIEW_LABEL");
        }
    }
}
