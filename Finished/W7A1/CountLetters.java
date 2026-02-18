import java.util.Scanner;

public class CountLetters {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        String line = "";

        
        if (args.length > 0) {
            line = args[0];
        } else {
            System.out.println("Line to be counted\n");
            line = stdin.nextLine();
        }


        int[] numCount = new int[27];
        for (int i = 0; i < 27; i++) {
            numCount[i] = 0;
        }
        for (int i = 0; i < line.length(); i++) {
            byte b = (byte) line.charAt(i);
            if (b >= 65 && b <= 90)
                numCount[b - 65]++;
            else if (b >= 97 && b <= 122)
                numCount[b - 97]++;
            else
                numCount[26]++;
        }
        for (int i = 0; i < 27; i++) {
            System.out.printf("%c: %d\n", i != 26 ? (char) (i + 97) : '_', numCount[i]);
        }

        stdin.close();
    }
}