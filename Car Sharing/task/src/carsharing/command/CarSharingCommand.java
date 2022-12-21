package carsharing.command;

import java.io.IOException;

public interface CarSharingCommand {

    void process() throws IOException;
}
