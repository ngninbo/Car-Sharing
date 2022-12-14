import java.util.*;
import java.util.stream.Collectors;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {

        List<Integer> values = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Collections.rotate(values, steps);

        //arr = values.stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < values.size(); i++) {
            arr[i] = values.get(i);
        }
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}