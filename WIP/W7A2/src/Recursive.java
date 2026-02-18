import java.math.BigInteger;
import java.util.Scanner;

public class Recursive {

    static BigInteger[] _fib_cache;
    static final int MAX_INDEX = 1000;

    static BigInteger fibonacci(int num) {
        if (num == 0) {
            _fib_cache[0] = BigInteger.valueOf(0);
            return BigInteger.valueOf(0);
        }
        if (num == 1) {
            _fib_cache[1] = BigInteger.valueOf(1);
            return BigInteger.valueOf(1);
        }
        if (!_fib_cache[num].equals(BigInteger.valueOf(-1))) {
            return _fib_cache[num];
        }
        _fib_cache[num - 1] = fibonacci(num - 1);
        _fib_cache[num - 2] = fibonacci(num - 2);
        return _fib_cache[num - 1].add(_fib_cache[num - 2]);
    }

    public static void main(String[] args) {
        _fib_cache = new BigInteger[MAX_INDEX];
        for (int i = 0; i < MAX_INDEX; i++) {
            _fib_cache[i] = BigInteger.valueOf(-1);
        }
        Scanner stdin = new Scanner(System.in);

        System.out.println("num:");
        int num = stdin.nextInt();
        if (num >= MAX_INDEX) {
            System.out.println("too big number");
            System.exit(1);
        }

        System.out.println(fibonacci(num));
        stdin.close();
    }
}