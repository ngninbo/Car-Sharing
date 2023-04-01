package carsharing.model;

import java.util.Objects;

/**
 * This class represents a simple POJO containing get/set methods to store data retrieved using DAO class
 * @author Beauclair Dongmo Ngnintedem
 */
public class Car extends Entity {

    private int companyId;

    public Car(int id, String name) {
        super(id, name);
    }

    public Car(int id, String name, int companyId) {
        this(id, name);
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getId() == car.getId() && getCompanyId() == car.getCompanyId() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCompanyId());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
