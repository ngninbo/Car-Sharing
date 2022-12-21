package carsharing.client;

import carsharing.command.ManagerClientOption;
import carsharing.controller.CarController;
import carsharing.controller.CompanyController;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.Scanner;

public class ManagerClient extends Client {

    public ManagerClient(CompanyController companyController, CarController carController) {
        super(companyController, carController);
    }

    @Override
    public void process() throws IOException {

        ManagerClientOption managerClientOption = new ManagerClientOption(super.companyController);

        while (isLoggedIn()) {
            System.out.println();
            CarSharingUtil.printManagerOptions();

            int action = new Scanner(System.in).nextInt();

            switch (action) {
                case 1:
                    managerClientOption.manage(carController);
                    break;
                case 2:
                    managerClientOption.createCompany();
                    break;
                case 0:
                    System.out.println();
                    logout();
                    break;
                default:
                    // Implement me
            }
        }
    }
}
