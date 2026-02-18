import java.util.Scanner;

public class LCD {
    static int gcd(int a, int b) {
        // Find Minimum of a and b
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        System.out.println("num1");
        int num1 = stdin.nextInt();
        System.out.println("den1");
        int den1 = stdin.nextInt();
        System.out.println("num2");
        int num2 = stdin.nextInt();
        System.out.println("den2");
        int den2 = stdin.nextInt();

        int den3 = den1 * den2;
        int num3 = num1 * den2 + num2 * den1;
        int gcd3 = gcd(den3, num3);
        den3 /= gcd3;
        num3 /= gcd3;
        System.out.printf("result: %d/%d\n", num3, den3);
    }
}