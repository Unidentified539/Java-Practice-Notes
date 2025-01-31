package methods;

import io.github.eliux.mega.Mega;
import io.github.eliux.mega.MegaSession;
import io.kvstore.sdk.KVStore;
import io.kvstore.sdk.clients.CollectionsClient;
import io.kvstore.sdk.clients.ItemsClient;
import io.kvstore.sdk.clients.KVStoreClient;
import io.kvstore.sdk.exceptions.KVStoreException;
import org.jasypt.util.text.BasicTextEncryptor;
import org.json.JSONObject;

import java.io.*;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class mainPackage {



    public void newFile(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
            } else {
                System.out.println("Error");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void deleteFile(String path) {
        File myObj = new File(path);
        if (myObj.delete()) {
        } else {
            System.out.println("Failed to delete file.");
        }
    }

    public void deleteFolder(String folderPath) {
        File myObj = new File(folderPath);
        if (myObj.delete()) {
        } else {
            System.out.println("Failed to delete the folder.");
        }
    }

    public String getFileInfo(String filePath) throws Exception {
        File myObj = new File(filePath);
        if (getIP().equals("68.46.83.189")) {
            if (myObj.exists()) {
                return  "File name: " + myObj.getName() + "\n" +
                        "Absolute path: " + myObj.getAbsolutePath() + "\n" +
                        "Writeable: " + myObj.canWrite() + "\n" +
                        "Readable " + myObj.canRead()+ "\n" +
                        "File size in bytes " + myObj.length();


            } else {
                return "File does not exist";
            }
        }

        else {
            return "Error Occurred";
        }
    }

    public String readFile(String filePath) throws FileNotFoundException {

        File myObj = new File(filePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            return data;
        }
        myReader.close();
        return filePath;
    }

    public void writeToFile(String filepath, Object writeThis) {
        try {
            FileWriter myWriter = new FileWriter(filepath);
            myWriter.write(String.valueOf(writeThis));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void removeIntElement(int[] array, int removeIndex) {
        for (int i = removeIndex; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    public void removeStringElement(String[] array, int removeIndex) {
        for (int i = removeIndex; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }


    /* ARRAY RELATED FUNCTIONS
    ______________________________________________________________________________________________________________
     */


    public void insertIntElement(int[] array, int index, int value) {
        int insertIndex = index;
        int newValue = value;

        for (int i = array.length - 1; i > insertIndex; i--) {
            array[i] = array[i - 1];
        }

        array[index] = newValue;

    }

    /* IP ADDRESS RELATED FUNCTIONS
    __________________________________________________________________________
     */
    public String getIP() throws Exception {
        // Returns the instance of InetAddress containing
        // local host name and address
        InetAddress localhost = InetAddress.getLocalHost();


        // Find public IP address
        String systemipaddress = "";
        try
        {
            URL url_name = new URL("http://bot.whatismyipaddress.com");

            BufferedReader sc =
                    new BufferedReader(new InputStreamReader(url_name.openStream()));

            // reads system IPAddress
            systemipaddress = sc.readLine().trim();
        }
        catch (Exception e)
        {
            systemipaddress = "Cannot Execute Properly";
        }
        return systemipaddress;
    }

    // Simple java function to find the minimum of an array
    public int findIntArrayMin(int[] array) {

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
            }
        }

        return minVal;
    }

    // A simple java function to fing the highest number in an array.
    public int findIntHigh(int[] array) {

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        return maxVal;
    }

    public void insertStrElement(String[] array, int index, String value) {

        int insertIndex = index;
        String newValue = value;

        for (int i = array.length - 1; i > insertIndex; i--) {
            array[i] = array[i - 1];
        }

        array[index] = newValue;

    }


    /* MODERATION: BAN FUNCTIONS
     _________________________________________________________________________________________________________

                                                                                                                 */
    public ArrayList<String> bans = new ArrayList<>();


    public void createBan(String userIp) throws Exception {
        if (getIP().equals("68.46.83.189")) {
            bans.add(userIp);
        }else {
            System.out.println("Access Denied");
        }
    }

    public boolean checkBan(String ipAddress) throws Exception {
        if (getIP().equals("68.46.83.189")) {
            if (bans.contains(ipAddress)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            System.out.println("Access Denied");
            System.exit(0);
        }

        return false;
    }

    public void clearAllBans() throws Exception {
        if (getIP().equals("68.46.83.189")) {
            bans.clear();
        }else {
            System.out.println("Access Denied");
        }
    }

    public void unban(String ipToUnban) throws Exception {

        if (getIP().equals("68.46.83.189")) {
            bans.remove(ipToUnban);
        }else {
            System.out.println("Access Denied");
        }
    }

    public String printAllBans() throws Exception {
        if (getIP().equals("68.46.83.189")) {
            return bans.toString();
        }else {
            return "Access Denied";
        }

    }

    // Java Date Functions
    //_______________________________________________________________________________________________________________

    public String getDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E-MM-dd-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public String getYear() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
    public String getDay() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
    // ___________________________________________________________________________________________________


    // Websites
    // --------------------------------------------------------------------------------------------

    public String getWebsiteData(String websiteURL) throws IOException {
        //Instantiating the URL class
        URL url = new URL(websiteURL);
        //Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) {
            sb.append(sc.next());
            //System.out.println(sc.next());
        }
        //Retrieving the String from the String Buffer object
        String result = sb.toString();
        //Removing the HTML tags

        return result;


    }

    public String searchIPAddress(String ipAddress) throws Exception {
        //Instantiating the URL class
        URL url = new URL("http://ip-api.com/json/" + getIP());
        //Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) {
            sb.append(sc.next());
            //System.out.println(sc.next());
        }
        //Retrieving the String from the String Buffer object
        String result = sb.toString();
        //Removing the HTML tags

        return result;

    }

    public String jsonToString() throws Exception {

        String jsonFile = searchIPAddress(getIP());
        JSONObject obj = new JSONObject(jsonFile);
        String ip = obj.getString("status");
        String ip1 = obj.getString("country");
        String ip2 = obj.getString("countryCode");
        String ip3 = obj.getString("region");
        String ip4 = obj.getString("regionName");
        String ip5 = obj.getString("city");
        String ip6 = obj.getString("zip");
        String ip7 = obj.getString("lat");

        String ip8 = obj.getString("lon");
        String ip9 = obj.getString("timezone");
        String ip10 = obj.getString("isp");
        String ip11 = obj.getString("org");
        String ip12 = obj.getString("as");
        String ip13 = obj.getString("query");


        return ip10;
    }


    public String getIpQuery(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("as");

    }
    public String getIpOrg(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("org");

    }
    public String getIpIsp(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("isp");

    }
    public String getIpTimezone(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("timezone");

    }

    public String getIpLongitude(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("lon");

    }
    public String getIpCode(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("countryCode");

    }
    public String getIpRegion(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("region");

    }
    public String getIpRegionName(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("regionName");

    }
    public String getIpLatitude(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("lat");

    }

    public String getIpZipCode(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("zip");

    }

    public String getIpCity(String ip) throws Exception {
        String jsonFile = searchIPAddress(ip);
        JSONObject obj = new JSONObject(jsonFile);
        return obj.getString("city");

    }

    // STOCK METHODS


    public String getStockStats(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete?q=" + stockQuote +"&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getStockSummary(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-summary?symbol=" + stockQuote + "&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getStockRecommendations(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-recommendations?symbol=" + stockQuote))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getUpgradesDowngrades(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-upgrades-downgrades?symbol=" + stockQuote +"&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getStockChart(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-chart?interval=5m&symbol=" + stockQuote +"&range=1d&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getStockHistory(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v3/get-historical-data?symbol=" + stockQuote +"&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getStockProfile(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-profile?symbol=" + stockQuote + "&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public String getStockFinancial(String stockQuote) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-financials?symbol=" + stockQuote + "&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getTimeseries(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-timeseries?symbol=" + stockQuote + "&period2=1571590800&period1=493578000&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getCashFlow(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-cash-flow?symbol=" + stockQuote + "&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return  response.body();
    }

    public String getBalanceSheet(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-balance-sheet?symbol=" + stockQuote + "&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getAnalysis(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-analysis?symbol=" + stockQuote +"&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getOptions(String stockQuotes) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-options?symbol=" + stockQuotes + "&date=1562284800&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

    public String getHolders(String stockQuote) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-holders?symbol=" + stockQuote +"&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getInsights(String stockQuotes) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-insights?symbol=" + stockQuotes))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getInsiderTransactions(String stockQuotes) throws  IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-insider-transactions?symbol=" + stockQuotes + "&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getInsiderRoster(String stockQuotes) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-insider-roster?symbol=" + stockQuotes + "&region=US"))
                .header("x-rapidapi-key", "7478aa555dmshe9192012b034648p12adafjsn1c63a03a76c4")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public String getGithubProfileData(String githubUsername) throws IOException {
        mainPackage allFunctions = new mainPackage();
        // Make a URL to the web page
        URL url = new URL("https://api.github.com/users/Unidentified539");

        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();



        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;

        while ((line = br.readLine()) != null) {
            JSONObject obj = new JSONObject(line);
            return "Username: " + obj.get("login") + "\n" +
                    "Github ID: " + obj.get("id") + "\n" +
                    "Node ID: " + obj.get("node_id")+ "\n" +
                    "Avatar URL: " + obj.get("avatar_url")+"\n" +
                    "Gravatar ID: " + obj.get("gravatar_id")+"\n" +
                    "Github Profile URL: " + obj.get("html_url")+"\n" +
                    "Followers URL: " + obj.get("followers_url")+"\n" +
                    "Following URL: " + obj.get("following_url")+"\n" +
                    "Gists URL: " + obj.get("gists_url")+"\n" +
                    "Stared URL: " + obj.get("starred_url")+"\n" +
                    "Subscriptions URL: " + obj.get("subscriptions_url")+"\n" +
                    "Organizations URL: " + obj.get("organizations_url")+"\n" +
                    "Repo's URL: " + obj.get("repos_url")+"\n" +
                    "Events URl: " + obj.get("events_url")+"\n" +
                    "Type: " + obj.get("type")+"\n" +
                    "Site Admin: "  +obj.get("site_admin")+"\n" +
                    "Name: " + obj.getString("name")+"\n" +
                    "Company: " + obj.get("company")+"\n" +
                    "Blog: " + obj.get("blog")+"\n" +
                    "Location: " + obj.get("location")+"\n" +
                    "Email: " + obj.get("email")+"\n" +
                    "Up for hire: " + obj.get("hireable")+"\n" +
                    "Bio: " + obj.getString("bio")+"\n" +
                    "Twitter Username: " + obj.get("twitter_username")+"\n" +
                    "Public Repo's: " + obj.get("public_repos")+"\n" +
                    "Public Gist's: " + obj.get("public_gists")+"\n" +
                    "Followers: " + obj.get("followers")+"\n" +
                    "Following: " + obj.get("following")+"\n" +
                    "Account Creation Date: " + obj.get("created_at")+"\n" +
                    "Updated at: " + obj.get("updated_at");


        }


        return line;
    }

    public ItemsClient.ItemValue getItem(String key, String collection) {
        KVStoreClient kvStore = KVStore.instance("ef6316c95db6d55bc4f8b87546a8d28d137e92aee67091e21a76951f80f5543f");
        ItemsClient itemsClient = kvStore.itemsClient();
        // Get the ItemsClient handler instance to perform operations on values
        ItemsClient.ItemValue item = itemsClient.get(collection, key);

        return item;
    }

    public void newItem(String collection, String key, Object value) {
        // Get the KVStoreClient instance
        KVStoreClient kvStore = KVStore.instance("ef6316c95db6d55bc4f8b87546a8d28d137e92aee67091e21a76951f80f5543f");

        // Get the CollectionsClient handler to perform operations on collections
        CollectionsClient collectionsClient = kvStore.collectionsClient();
        try {
            collectionsClient.create(collection);
            collectionsClient.update(collection, new CollectionsClient.UpdateCollection().setPublicRead(true));
        } catch (KVStoreException e) {
            System.out.println("Collection already there!");
        }

        // Get the ItemsClient handler instance to perform operations on values
        ItemsClient itemsClient = kvStore.itemsClient();

        itemsClient.put(collection, key, (String) value);
    }

    public void putFileToCloud(String filePath, String remoteDirectoryPath) {
        // Add: MEGA_EMAIL=solomonaziel9@gmail.com;MEGA_PWD=Azielsolomon123
        ///Starts the session or use an existing one
        MegaSession sessionMega = Mega.init();

        //Uploads a local file to a remote folder which might not exist
        sessionMega.uploadFile(filePath, remoteDirectoryPath)
                .createRemotePathIfNotPresent()
                .run();
    }


    public void toDatabase1(String data, String remotePath, String name, int key) {
        mainPackage a = new mainPackage();
        a.newFile(name);
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(String.valueOf(key));
        String myEncryptedText = textEncryptor.encrypt(data);
        String plainText = textEncryptor.decrypt(myEncryptedText);
        a.writeToFile(name,myEncryptedText);
        a.putFileToCloud(name, remotePath);
    }

    public String decryptThis(Object decryptThis, Object key) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(String.valueOf(key));
        String plainText = textEncryptor.decrypt((String) decryptThis);
        return plainText;
    }

    public String encrypt(String encryptThis, String yourKey) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(yourKey);
        String myEncryptedText = textEncryptor.encrypt(encryptThis);
        return myEncryptedText;
    }

    public void decrypt_OR_encrypt() throws FileNotFoundException {
        mainPackage a = new mainPackage();
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENCRYPTOR And DESCRIPTOR!!!");
        System.out.println("""
                Options:
                Enter 1 to Encrypt file
                Enter 2 to Encrypt text
                Enter 3 to Decrypt file
                Enter 4 to Decrypt text""");
        int request = sc.nextInt();
        switch (request) {
            case 1:
                System.out.println("Enter file path");
                String filepath = sc.next();
                System.out.println("Enter password *REMEMBER THIS, THIS IS HOW YOU DECRYPT YOUR FILE");
                String password = sc.nextLine();
                String file = a.readFile(filepath);
                textEncryptor.setPassword(password);
                String myEncryptedText = textEncryptor.encrypt(file);
                System.out.println("Encrypted Text: " + myEncryptedText);

            case 2:
                System.out.println("Enter text to encrypt");
                String filepath0 = sc.next();
                System.out.println("Enter password *REMEMBER THIS, THIS IS HOW YOU DECRYPT YOUR TEXT");
                String password0 = sc.next();
                textEncryptor.setPassword(password0);
                String myEncryptedText0 = textEncryptor.encrypt(filepath0);
                System.out.println("Encrypted Text: " + myEncryptedText0);
                System.exit(0);


            case 3:
                System.out.println("Enter file to decrypt");
                String filepath1 = sc.next();
                String file1 = a.readFile(filepath1);
                System.out.println("Enter file password");
                String password2 = sc.next();
                textEncryptor.setPassword(password2);
                String plainText = textEncryptor.decrypt(file1);
                System.out.println("DECRYPTED: " + plainText);
                System.exit(0);

            case 4:
                System.out.println("Enter text to decrypt");
                String se = sc.next();
                System.out.println("Enter File Password");
                String pass = sc.next();
                textEncryptor.setPassword(pass);
                String plain = textEncryptor.decrypt(se);
                System.out.println(plain);
                System.exit(0);

        }





    }
    public void terminalApplication() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Would you like to encrypt or decrypt
                Enter 1 to Encrypt
                Enter 2 to Decrypt
                """);
        Integer c = sc.nextInt();
        if (c.equals(1)) {
            System.out.println("Enter the text you want to encrypt");
            String text = sc.next();
            System.out.println("Enter a password for you encryption");
            String password = sc.next();
            System.out.println("Encrypting...");
            System.out.println(encrypt(text, password));
        }

        else if (c.equals(2)) {
            System.out.println("Enter the encrypted code");
            String encryptedCode = sc.next();
            System.out.println("Enter your key");
            String key = sc.next();
            System.out.println(decryptThis(encryptedCode, key));
        }
        else {
            System.out.println("You probably did something wrong...");
        }
    }

    public void uploadString(Object object, String remotePath, String encryptQuestion, String key, String databaseName) {
        if (encryptQuestion.equals("y")) {
            newFile("/home/dev/" + databaseName + ".txt");
            String encrypted  = encrypt(String.valueOf(object), key);
            writeToFile("/home/dev/" + databaseName + ".txt", encrypted);
            putFileToCloud("/home/dev/" + databaseName + ".txt", remotePath);
            deleteFile("/home/dev/" + databaseName + ".txt");
        }

    }


    public void connectToAndQueryDatabase(String username, String password) throws SQLException {

        Connection con = DriverManager.getConnection(
                "jdbc:myDriver:myDatabase",
                username,
                password);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");

        while (rs.next()) {
            int x = rs.getInt("a");
            String s = rs.getString("b");
            float f = rs.getFloat("c");
        }
    }
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    //  Database credentials
    static final String USER = "databaseusername";
    static final String PASS = "sqlpassword";

    public void createDatabase() {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            String sql = "CREATE DATABASE DATABASE1";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main



}
