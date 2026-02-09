import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.printf("Please provide a file\n");
            System.exit(1);
        } else if (args.length > 1) {
            System.out.printf("Please provide only one file\n");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("Please provide a file which exists");
            System.exit(1);
        }

        if (!file.canRead()) {
            System.out.println("Cannot read file");
            System.exit(1);
        }

        if (file.isDirectory()) {
            System.out.println("Please provide a file, not a directory");
            System.exit(1);
        }

        if (file.length() > Integer.MAX_VALUE) {
            System.out.println("No");
            System.exit(1);
        }

        byte[] bytes = null;

        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Index     Value                    Ascii");

        for (int i = 0; i < bytes.length; i += 16) {
            System.out.print(String.format("%8X", i).replace(' ',     '0') + "  ");
            for (int j = i; j < i + 16; j++) {
                if (j >= bytes.length) {
                    System.out.print("   ");
                } else {
                    System.out.print(String.format("%2X", bytes[j]).replace(' ', '0') + " ");
                }
            }
            System.out.print(" ");
                
            for (int j = i; j < i + 16; j++) {
                if (j >= bytes.length) {
                    System.out.print(" ");
                    continue;
                }
                byte b = bytes[j];
                if (b < 32 || b > 126) {
                    System.out.print('.');
                } else {
                    System.out.print((char) b);
                }
            }
            System.out.printf("\n");
        }
    }
}
