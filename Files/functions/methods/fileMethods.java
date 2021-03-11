package methods;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class

public class fileMethods {

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



}
