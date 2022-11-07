// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    // put your code here
    Role role1 = Role.ADMIN;
    Role role2 = Role.ADMIN;
    Role role3 = Role.USER;

    System.out.println(role1 == Role.ADMIN);  // (1)
    System.out.println(role1.equals(role2)); // (2)
    System.out.println(role1 == role2);    // (3)
    System.out.println(role1 == role3);    // (4)
  }
}

enum Role {
  ADMIN, USER
}
