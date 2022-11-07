import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        int count = 0;
        Random random = new Random(k);
        while (count <= n) {
            if (count == n) {
                break;
            }
            double gaussianNumber = random.nextGaussian();
            if (gaussianNumber <= m) {
                count++;
            } else {
                k++;
                count = 0;
                random.setSeed(k);
            }
        }
        System.out.println(k);
    }
}