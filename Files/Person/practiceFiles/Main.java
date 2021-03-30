package practiceFiles;

import io.github.eliux.mega.Mega;
import io.github.eliux.mega.MegaSession;
import io.github.eliux.mega.cmd.MegaCmdGet;
import methods.mainPackage;

import java.io.IOException;

public class Main {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws IOException {
        mainPackage a = new mainPackage();

        String encryptedStr = a.readFile("/home/dev/MEGA/Database/s.txt");
        String decrypted = a.decryptThis(encryptedStr, "Azielsolomon123");
        System.out.println(decrypted);
    }

}