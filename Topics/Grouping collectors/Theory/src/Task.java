// You can experiment here, it won’t be checked

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    // put your code here
    Map<Boolean, Long> map = Stream.of(5, 1, 9, -2, -5, 1)
            .collect(Collectors.partitioningBy(n -> n > 0, Collectors.summingLong(x -> x)));

    System.out.println(map);

    List<Account> accounts = List.of(
            new Account(3333L, "530012", Status.ACTIVE),
            new Account(15000L, "771843", Status.BLOCKED),
            new Account(15000L, "234465", Status.ACTIVE),
            new Account(8800L, "110011", Status.ACTIVE),
            new Account(45000L, "462181", Status.BLOCKED),
            new Account(0L, "681891", Status.REMOVED)
    );

    Report report = accounts
            .stream()
            .collect(Collectors.teeing(
                    Collectors.filtering(Account::isBlocked,
                            Collectors.mapping(Account::getNumber,
                                    Collectors.toList())),
                    Collectors.filtering(Account::isActive,
                            Collectors.mapping(Account::getNumber,
                                    Collectors.toList())),
                    Report::new)
            );

    System.out.println(report);
  }
}


enum Status {ACTIVE, BLOCKED, REMOVED}

class Account {
  private long balance;
  private String number;
  private Status status;

  public Account(long balance, String number, Status status) {
    this.balance = balance;
    this.number = number;
    this.status = status;
  }

  public long getBalance() { return balance; }
  public String getNumber() { return number; }
  public Status getStatus() { return status; }
  public boolean isBlocked() { return status == Status.BLOCKED; }
  public boolean isActive() { return status == Status.ACTIVE; }
}

class Report {
  List<String> blocked;
  List<String> active;

  public Report(List<String> blocked, List<String> active) {
    this.blocked = blocked;
    this.active = active;
  }

  @Override
  public String toString() { return blocked + ", " + active; }
}