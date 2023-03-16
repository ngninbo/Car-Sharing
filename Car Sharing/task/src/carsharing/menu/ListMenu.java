package carsharing.menu;

import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.model.Customer;
import carsharing.util.MenuItem;
import carsharing.util.PropertiesLoader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static carsharing.util.CarSharingUtil.FORMATTED_OPTION;

public class ListMenu<T> {

    private final List<T> items;

    public ListMenu(List<T> items) {
        this.items = items;
    }

    public int choice(String label) throws IOException {
        display(label, items);
        System.out.printf(FORMATTED_OPTION, 0, MenuItem.BACK.capitalize());
        return new Scanner(System.in).nextInt();
    }

    public void display(String label, List<T> list) throws IOException {
        System.out.println(getText(label));
        IntStream
                .range(0, list.size())
                .forEach(i -> {
                    String name;
                    if (list.get(i) instanceof Customer) {
                        name = ((Customer) list.get(i)).getName();
                    } else if (list.get(i) instanceof Car) {
                        name = ((Car) list.get(i)).getName();
                    } else if (list.get(i) instanceof Company) {
                        name = ((Company) list.get(i)).getName();
                    } else {
                        name = (String) list.get(i);
                    }

                    System.out.printf(FORMATTED_OPTION, i + 1, name);
                });
    }

    public void display(String label) throws IOException {
        display(label, items);
    }

    public String getText(String key) throws IOException {
        return PropertiesLoader.loadProperties("messages.properties").getProperty(key);
    }
}
