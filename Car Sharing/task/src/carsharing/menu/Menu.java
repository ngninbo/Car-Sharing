package carsharing.menu;

import carsharing.util.MenuItem;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static carsharing.util.CarSharingUtil.FORMATTED_OPTION;
import static carsharing.util.CarSharingUtil.modulo;

public abstract class Menu {

    protected abstract int display();
    protected abstract boolean process(MenuItem item) throws IOException;

    private final List<MenuItem> menuItems;
    protected MenuItem menuItem = MenuItem.UNKNOWN;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void process() throws IOException {
        while (process(menuItem)) {
            menuItem = getMenuItemFromInput(display());
        }
    }

    protected MenuItem getMenuItemFromInput(int input) {
        int index = findIndex(input);
        return index < 0 ? MenuItem.UNKNOWN : menuItems.get(findIndex(input));
    }

    protected int choice() {
        menuItems.stream()
                .map(menuItem -> String.format(FORMATTED_OPTION, modulo(menuItems.indexOf(menuItem) + 1, menuItems.size()), menuItem.getName()))
                .forEach(System.out::print);
        return new Scanner(System.in).nextInt();
    }

    private int findIndex(int reminder) {
        final int size = menuItems.size();
        return IntStream.range(0, size)
                .filter(i -> modulo(i + 1, size) == reminder)
                .findFirst().orElse(-1);

    }
}
