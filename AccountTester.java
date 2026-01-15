import java.util.Scanner;
import java.util.ArrayList;

public class AccountTester {
    public AccountTester() {}

    public static void main(String[] args) {

        ArrayList<Account> accounts = new ArrayList<Account>();

        accounts.add(new Account("Jane Green", "Password1!"));
        accounts.add(new Account("John Blue", "ThisIsAnExamplePassword"));

        Scanner stdin = new Scanner(System.in);

        String in = "";

        String unused;
        int account = -1;
        
        do {
            do {
                System.out.printf("Which account are you looking for? (number): ");
            } while (!stdin.hasNextInt() && !(unused = stdin.next()).equals("0"));
            account = stdin.nextInt();

        } while (account < 0 || account >= accounts.size());


        while (!in.toLowerCase().equals("exit")) {
            System.out.printf("What would you like to do?\n");
            System.out.printf(" 1. Change Password\n");
            System.out.printf(" 2. Read Balance\n");
            System.out.printf(" 3. Set Balance (requires admin)\n");
            System.out.printf(" 4. Read Name\n");
            System.out.printf(" 5. Set Name\n");
            System.out.printf(" Exit\n");
            System.out.printf("(1-5|exit): ");
            in = stdin.next();

            if (in.equals("1")) {
                System.out.printf("What is your old password?: ");
                String oldpasswd = stdin.next();
                System.out.printf("What is your new password?: ");
                String newpasswd = stdin.next();

                if (accounts.get(account).changePasswd(oldpasswd, newpasswd))
                    System.out.printf("Success\n");
                else
                    System.out.printf("Failure\n");

            } else if (in.equals("2")) {
                System.out.printf("Your balance is %s\n", accounts.get(account).getBalance());
            } else if (in.equals("3")) {
                System.out.printf("What is the admin password?: ");
                String adminpasswd = stdin.next();
                do {
                    System.out.printf("What would you like to set the balance to? The current balance is %s (number): ", accounts.get(account).getBalance());
                } while (!stdin.hasNextDouble() && !(unused = stdin.next()).equals("0"));
                double ammount = stdin.nextDouble();
                if (accounts.get(account).setBalance(ammount, adminpasswd))
                    System.out.printf("Success\n");
                else
                    System.out.printf("Failure\n");

            } else if (in.equals("4")) {
                System.out.printf("Your name is %s\n", accounts.get(account).getName());
            } else if (in.equals("5")) {
                System.out.printf("What is your password?: ");
                String passwd = stdin.next();
                System.out.printf("What is your new name?: ");
                String name = stdin.next();
                if (accounts.get(account).setName(name, passwd))
                    System.out.printf("Success\n");
                else
                    System.out.printf("Failure\n");

            }
        }
        stdin.close();
    }
}