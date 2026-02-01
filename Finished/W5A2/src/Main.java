
public class Main {
    public static void main(String[] args) {
        SequenceGenerator fibs = new FibonacciNumbers();
        SequenceGenerator squares = new SquareNumbers();

        for (int i = 0; i < 100; i++) {
            System.out.println(fibs.next());
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(squares.next());
        }
    }
}