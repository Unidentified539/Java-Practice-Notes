package practiceFiles;

import methods.mainPackage;
import org.jasypt.util.text.BasicTextEncryptor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws IOException {
        mainPackage a = new mainPackage();
        a.decrypt_OR_encrypt();
    }



}