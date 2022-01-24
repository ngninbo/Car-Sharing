package carsharing.model;

import java.util.Objects;

public class Customer {

    private int id;
    private String name;
    private int rentedCarId;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(int id, String name, int rentedCarId) {
        this(id, name);
        this.rentedCarId = rentedCarId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRentedCarId() {
        return rentedCarId;
    }

    public void setRentedCarId(int rentedCarId) {
        this.rentedCarId = rentedCarId;
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
