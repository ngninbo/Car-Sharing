import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int numberOfOptions = 3;
        int[] amountList = new int[numberOfOptions];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numberOfOptions; i++) {
            amountList[i] = scanner.nextInt();
        }

        Broker broker = new Broker();
        for (int i = 0; i < numberOfOptions; i++) {
            Option option = new Option(amountList[i]);
            Command command = amountList[i] > 0 ? new BuyCommand(option) : new SellCommand(option);
            broker.setCommand(command);
            broker.executeCommand();
        }
    }
}

class Option {
    private final int amount;

    Option(int amount) {
        this.amount = amount;
    }

    void buy() {
        System.out.println(amount + " was bought");
    }

    void sell() {
        System.out.printf("%s was sold\n", amount);
    }
}

interface Command {
    void execute();
}

class BuyCommand implements Command {
    private final Option option;

    BuyCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.buy();
    }

}

class SellCommand implements Command {
    private final Option option;

    SellCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.sell();
    }
}

class Broker {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand() {
        command.execute();
    }
}