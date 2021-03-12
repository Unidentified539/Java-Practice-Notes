package methods;
import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainPackage {

    public void newFile(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("Success");
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

    public String getFileInfo(String filePath) {
        File myObj = new File(filePath);
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

    public void writeToFile(String filepath, String writeThis) {
        try {
            FileWriter myWriter = new FileWriter(filepath);
            myWriter.write(writeThis);
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
    public String getIP() throws UnknownHostException {
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
        return localhost.getHostAddress();
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

    public ArrayList<String> bans = new ArrayList<>();

    /* MODERATION: BAN FUNCTIONS
     _________________________________________________________________________________________________________

     */



    public void createBan(String userIp) {
        bans.add(userIp);
    }

    public boolean checkBan(String ipAddress) {
        if (bans.contains(ipAddress)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void clearAllBans() {
        bans.clear();
    }

    public void unban(String ipToUnban) {
        bans.remove(ipToUnban);
    }

    public String printAllBans() {
        return bans.toString();
    }



}
