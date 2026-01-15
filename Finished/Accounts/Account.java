public class Account {
    private String name;
    private String passwd;

    private double balance = 0;

    private static String admin_password = "1234";

    public static boolean setAdminPasswd(String oldpasswd, String newpasswd) {
        if (Account.admin_password.equals(oldpasswd)) {
            Account.admin_password = newpasswd;
            return true;
        } else {
            return false;
        }
    }


    public Account(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public boolean setName(String name, String passwd) {
        if (this.passwd.equals(passwd) || Account.admin_password.equals(passwd)) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean setBalance(double balance, String passwd) {
        if (Account.admin_password.equals(passwd)) {
            this.balance = balance;
            return true;
        } else {
            return false;
        }
    }

    public boolean changePasswd(String oldpasswd, String newpasswd) {
        if (this.passwd.equals(oldpasswd) || Account.admin_password.equals(oldpasswd)) {
            this.passwd = newpasswd;
            return true;
        } else {
            return false;
        }
    }
}