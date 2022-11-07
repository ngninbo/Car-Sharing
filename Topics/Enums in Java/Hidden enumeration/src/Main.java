import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // write your code here
        long counter = Arrays.stream(Secret.values())
                .filter(secret -> secret.name().startsWith("STAR"))
                .count();
        System.out.println(counter);
    }
}

/* sample enum for inspiration
enum Secret {
    STAR, CRASH, START, // ...
}
*/