package carsharing.command;

import carsharing.menu.MenuItem;

import java.io.IOException;

public interface Command {

    boolean execute(MenuItem item) throws IOException;
}
