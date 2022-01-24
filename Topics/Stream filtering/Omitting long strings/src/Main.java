import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static final int MAX_CHARACTER_LENGTH = 4;

    private static Stream<String> omitLongStrings(List<String> strings) {
        // write your code here
        return strings.stream().filter(s -> s.length() < MAX_CHARACTER_LENGTH);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        List<String> list = new ArrayList<>(Arrays.asList(str.split(" ")));
        omitLongStrings(list).forEach(System.out::println);
    }
}