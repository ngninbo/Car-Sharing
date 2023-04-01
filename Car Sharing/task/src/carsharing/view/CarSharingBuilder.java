package carsharing.view;

import carsharing.controller.ControllerFactory;
import carsharing.repository.RepositoryFactory;

public class CarSharingBuilder {

    private final String databaseFilename;
    private ControllerFactory factory;

    private CarSharingBuilder(String databaseFilename) {
        this.databaseFilename = databaseFilename != null ? databaseFilename : "carSharing";
    }

    public static CarSharingBuilder init(String databaseFilename) {
        return new CarSharingBuilder(databaseFilename);
    }

    public CarSharingBuilder withControllerFactory() {
        this.factory = new ControllerFactory(new RepositoryFactory(databaseFilename));
        return this;
    }

    public CarSharingBuilder withDatabase() {
        factory.createDatabaseTable();
        return this;
    }

    public CarSharing build() {
        return new CarSharing(factory);
    }
}