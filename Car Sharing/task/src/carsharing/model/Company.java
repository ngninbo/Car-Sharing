package carsharing.model;

import java.util.Objects;

/**
 * This class represents a simple POJO containing get/set methods to store data retrieved using DAO class
 * @author Beauclair Dongmo Ngnintedem
 */
public class Company extends Entity {

    public Company(int id, String name) {
        super(id, name);
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
