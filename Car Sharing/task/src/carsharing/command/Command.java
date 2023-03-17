package carsharing.command;

import carsharing.util.MenuItem;

import java.io.IOException;

public interface Command {

    boolean execute(MenuItem item) throws IOException;
}
