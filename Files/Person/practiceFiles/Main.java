package practiceFiles;
import io.github.eliux.mega.Mega;
import io.github.eliux.mega.MegaSession;
import io.github.eliux.mega.auth.MegaAuthCredentials;
import io.kvstore.sdk.KVStore;
import io.kvstore.sdk.clients.CollectionsClient;
import io.kvstore.sdk.clients.ItemsClient;
import io.kvstore.sdk.clients.KVStoreClient;
import io.kvstore.sdk.exceptions.KVStoreException;
import methods.mainPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws IOException {
        mainPackage a = new mainPackage();
        a.toDatabase(a.getGithubProfileData("Unidentified539"), "/Database", "/home/dev/Unidentified539.txt");

    }
}