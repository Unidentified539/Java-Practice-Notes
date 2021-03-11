package practiceFiles;

import methods.*;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws UnknownHostException {
        banUser function = new banUser();
        ipScanner ip = new ipScanner();
        String userIp = ip.getIP();
        if (function.checkBan(userIp) == true) {
            System.out.println("You have been banned");
            System.exit(0);
        }
        else {
            System.out.println("You have been checked you may continue");
        }


        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to be banned? y/n");
        String answer = sc.nextLine();
        if (answer.equals("y")) {
            function.createBan(userIp);
        }
        else {
            System.out.println("Okay");
        }
    }
}