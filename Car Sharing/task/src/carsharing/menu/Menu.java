package carsharing.menu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static carsharing.util.CarSharingUtil.FORMATTED_OPTION;
import static carsharing.util.CarSharingUtil.modulo;

public abstract class Menu {

    public abstract int display();
    public abstract boolean process(MenuItem item);

    private final List<MenuItem> menuItems;
    protected MenuItem menuItem = MenuItem.UNKNOWN;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void process() {
        while (process(menuItem)) {
            menuItem = getMenuItemFromInput(display());
        }
    }

    public MenuItem getMenuItemFromInput(int input) {
        int index = findIndex(input);
        return index < 0 ? MenuItem.UNKNOWN : menuItems.get(findIndex(input));
    }

    public int choice() {
        menuItems.stream()
                .map(menuItem -> String.format(FORMATTED_OPTION, modulo(menuItems.indexOf(menuItem) + 1, menuItems.size()), menuItem.getName()))
                .forEach(System.out::print);
        return new Scanner(System.in).nextInt();
    }

    private int findIndex(int reminder) {
        final int size = menuItems.size();
        return reminder == 0 ? size - 1 : reminder - 1;
    }
}
