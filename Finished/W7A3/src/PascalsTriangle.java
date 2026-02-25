import java.util.Scanner;
import java.util.ArrayList;

public class PascalsTriangle {

    /* cache of pascal triangle numbers */
    static ArrayList<ArrayList<Integer>> _pascal_triangle_cache = new ArrayList<ArrayList<Integer>>();

    public static void printTriangle(int lines) {

        /* if lines is less than 1, do nothing */
        if (lines < 1) {
            return;
        }

        /* print the previous line first */
        printTriangle(lines - 1);


        String buff = "";

        if (lines >= _pascal_triangle_cache.size()) {
            /* if not then generate it and put into cache */
            _pascal_triangle_cache.add(new ArrayList<Integer>());
            for (int i = 0; i < lines; i++) {
                /* first and last in the row are always 1 */
                if (i == 0) {
                    _pascal_triangle_cache.get(lines - 1).add(Integer.valueOf(1));
                } else if (i == lines - 1) {
                    _pascal_triangle_cache.get(lines - 1).add(Integer.valueOf(1));
                } else {
                    int a, b;

                    /* get the above 2 numbers */
                    a = _pascal_triangle_cache.get(lines - 2).get(i - 1);
                    b = _pascal_triangle_cache.get(lines - 2).get(i);

                    _pascal_triangle_cache.get(lines - 1).add(Integer.valueOf(a + b));
                }
            }
        }
        /* print the line */
        for (int i = 0; i < lines; i++) {
            buff += _pascal_triangle_cache.get(lines - 1).get(i);
            buff += " ";
        }


        System.out.println(buff);
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.println("how many lines: ");
        int lines = stdin.nextInt();
        System.out.println();

        printTriangle(lines);

        stdin.close();
    }
}
