public class CountLetters {
    public static void main(String[] args) {
        String line = args[0];
        int[] numCount = new int[27];
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
    }
}