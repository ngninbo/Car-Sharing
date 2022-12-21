package carsharing.client;

import carsharing.command.CarSharingCommand;
import carsharing.controller.CarController;
import carsharing.controller.CompanyController;

import java.io.IOException;


public abstract class Client implements CarSharingCommand {

    private boolean loggedIn;

    protected CompanyController companyController;
    protected CarController carController;

    Client(CompanyController companyController, CarController carController) {
        this.companyController = companyController;
        this.carController = carController;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean exit() {
        return true;
    }

    public void login() {
        setLoggedIn(true);
    }

    public void logout() {
        setLoggedIn(false);
    }

    public Client run() throws IOException {
        login();
        process();
        return this;
    }
}
