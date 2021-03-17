package practiceFiles;
import org.json.*;

import methods.mainPackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

public class userIp {

    public static void main(String[] args) throws Exception {
        mainPackage allFunctions = new mainPackage();
        String jsonFile = allFunctions.getStockStats("SYRS");
        System.out.println(jsonFile);
        JSONObject object = new JSONObject(jsonFile);
        System.out.println(allFunctions.getGithubProfileData("Unidentified539"));


    }

}
