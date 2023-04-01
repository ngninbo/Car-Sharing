package carsharing.model;

import java.util.Objects;

/**
 * This class represents a simple POJO containing get/set methods
 * to store Customer data retrieved using CustomerDAO class
 * @author Beauclair Dongmo Ngnintedem
 */
public class Customer extends Entity {

    private int rentedCarId;

    public Customer(int id, String name) {
        super(id, name);
    }

    public Customer(int id, String name, int rentedCarId) {
        this(id, name);
        this.rentedCarId = rentedCarId;
    }

    public int getRentedCarId() {
        return rentedCarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() && getRentedCarId() == customer.getRentedCarId() &&
                Objects.equals(getName(), customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRentedCarId());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rentedCarId=" + rentedCarId +
                '}';
    }
}
