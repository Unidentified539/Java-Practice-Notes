package practiceFiles;
import methods.mainPackage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class ReadingWebPage {


    public static void main(String[] args) throws Exception {
        //Instantiating the URL class
        mainPackage allFunctions = new mainPackage();

        System.out.println(allFunctions.getStockStats("SYRS"));

    }
}