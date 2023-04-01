package carsharing.menu;

import carsharing.model.Entity;
import carsharing.util.PropertiesLoader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static carsharing.util.CarSharingUtil.FORMATTED_OPTION;

public class ListView<T extends Entity> {

    private final List<T> items;

    public ListView(List<T> items) {
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
                .forEach(i ->
                    System.out.printf(FORMATTED_OPTION, i + 1, list.get(i).getName())
                );
    }

    public void display(String label) throws IOException {
        display(label, items);
    }

    public String getText(String key) throws IOException {
        return PropertiesLoader.getInstance().messages().getProperty(key);
    }
}
