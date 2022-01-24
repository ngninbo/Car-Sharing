import java.util.List;
import java.util.function.BiFunction;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Utils {

    public static void sortUsers(List<User> users) {
        // your code here
        BiFunction<User, User, Boolean> isEqualName = (u1, u2) -> u1.getName().equals(u2.getName());
        BiFunction<User, User, Integer> compareAge = (u1, u2) -> Integer.compare(u2.getAge(), u1.getAge());
        BiFunction<User, User, Integer> compareName = (u1, u2) ->  u1.getName().compareTo(u2.getName());

        //users.sort(Comparator.comparing(User::getName).thenComparing(Comparator.comparing(User::getAge).reversed()));
        users.sort((u1, u2) -> isEqualName.apply(u1, u2) ?  compareAge.apply(u1, u2) : compareName.apply(u1, u2));
    }
}