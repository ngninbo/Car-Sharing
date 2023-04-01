package carsharing.menu;

import carsharing.controller.CarController;
import carsharing.controller.ControllerFactory;
import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.List;

import static carsharing.util.CarSharingUtil.enter;

public class CompanyMenu extends Menu {

    private final CarController controller;
    private Company company;

    public CompanyMenu(ControllerFactory factory) {
        super(MenuItem.companyMenuItems());
        this.controller = factory.getCarController();
    }

    @Override
    public int display() {
        System.out.println();
        return choice();
    }

    @Override
    public boolean process(MenuItem item) throws IOException {

        switch (item) {
            case CAR_LIST:
                showCarList(company.getId());
                break;
            case CREATE_A_CAR:
                createCar(company.getId());
                break;
            case BACK:
                menuItem = MenuItem.UNKNOWN;
                System.out.println();
                return true;
        }

        return false;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    private void createCar(int companyId) throws IOException {
        String name = enter("CAR_NAME_INPUT_COMMAND");
        if (this.controller.save(name, companyId)) {
            CarSharingUtil.println("CAR_CREATION_SUCCEED_MSG");
        }
    }

    private void showCarList(int companyId) throws IOException {
        List<Car> cars = this.controller.findCarByCompanyId(companyId);
        if (cars.isEmpty()) {
            CarSharingUtil.println("CAR_LIST_EMPTY_INFO");
        } else {
            new ListView<>(cars).display("CAR_LIST_OVERVIEW_LABEL");
        }
    }
}
