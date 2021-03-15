package practiceFiles;
import org.json.*;

import methods.mainPackage;

public class userIp {
    public String name;

    public userIp(String name) {
        this.name = name;
    }
    public static void main(String[] args) throws Exception {
        mainPackage allFunctions = new mainPackage();
        String jsonFile = allFunctions.searchIPAddress("68.46.83.189");
        System.out.println(jsonFile);
        JSONObject obj = new JSONObject(jsonFile);
        System.out.println(obj.getString("city"));
        System.out.println(allFunctions.("10.0.0.32"));
    }

}
