package practiceFiles;
import io.kvstore.sdk.KVStore;
import io.kvstore.sdk.clients.CollectionsClient;
import io.kvstore.sdk.clients.ItemsClient;
import io.kvstore.sdk.clients.KVStoreClient;
import io.kvstore.sdk.exceptions.KVStoreException;
import methods.mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        mainPackage allFunctions = new mainPackage();
        allFunctions.putFileToCloud("/home/dev/Simple-Bash-Scripts/Scripts/affect.sh", "/megacmd4j");
    }
}