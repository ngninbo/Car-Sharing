package carsharing.model;

import java.util.Objects;

/**
 * This class represents a simple POJO containing get/set methods to store data retrieved using DAO class
 * @author Beauclair Dongmo Ngnintedem
 */
public class Company {

    private final int id;
    private String name;

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return getId() == company.getId() && Objects.equals(getName(), company.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
