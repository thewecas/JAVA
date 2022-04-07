
import java.util.Scanner;

public class Vendorid {
    
    static String name="", status="", id="";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name : ");
        name = sc.nextLine();
        System.out.print("Enter status : ");
        status = sc.nextLine();

        while (true) {
            System.out.print("Enter the Vendor id : ");
            id = sc.nextLine();
            checkid(id);
        }

    }

    
    static void checkid(String id) {
        String[] op = new String[8];
        int k = -1;
        if (id.length() != 10)
            op[++k] = "Character Length Mismatch";

        else {
            for (int i = 0; i < 3; i++)
                if (!(id.charAt(i) >= 65 && id.charAt(i) <= 90))
                    op[++k] = "Either the first 3 character not an alphabet";

            char c = id.charAt(3);
            if (!(c == status.charAt(0) || (c == 'P' && 'I' == status.charAt(0)))) {
                if ((c == 'P' || c == 'F' || c == 'C' || c == 'H' || c == 'A' || c == 'T'))
                    op[++k] = "Status missmatch";
                else
                    op[++k] = "4th Character is not a valid status";
            }

            String lname = lastname(name);
            if (!(id.charAt(4) == lname.charAt(0)))
                op[++k] = "5th character mismatch";

            int num = toInt(id.substring(5, 8));
            if (!(num >= 0001 && num <= 9999))
                op[++k] = "Either of 6th to 9th character is not a digit";

            if (!(id.charAt(9) >= 65 && id.charAt(9) <= 90))
                op[++k] = "Last character not an alphabet";
        }

        System.out.print(id+" - ");
        if (k == -1)
            System.out.println("Valid Vendor ID");
        else {
            System.out.print("Invalid Vendor ID | ");
            System.out.print(op[0]);
            if (k >0)
                for (int i = 1; i <= k; i++)
                    System.out.print(" & " + op[i]);
            System.out.println();
        }
    }
    
    
    static String lastname(String name) {
        String[] a = name.split(" ");
        return a[a.length - 1];
    }


    static int toInt(String num) {
        int number=0;
        for(int i=0;i<num.length();i++)
            if(num.charAt(i)>=48 && num.charAt(i)<=57)
                number = number * 10 + (num.charAt(i) - 48);
            else
                return 0000;
        return number;
    }
}
