package co.com.bancolombia.certification.svn.factory.firebase;

import co.com.bancolombia.certification.svn.application.exceptions.CustomException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static co.com.bancolombia.certification.svn.application.exceptions.CustomException.FIREBASE_ERROR_CONNECTION;
import static co.com.bancolombia.certification.svn.utils.LoggerMessage.SUCCESSFULLY_FIREBASE_CONNECTION;


public class FirebaseConnectionFactory {
    private static final Logger logger = LoggerFactory.getLogger(FirebaseConnectionFactory.class);
    private static final Map<String,FirebaseClientConnection> connections = new HashMap<>();

    private FirebaseConnectionFactory() {

    }

    //factory method to return connection
    public static FirebaseClientConnection getConnection(String privateKeyPath){
        return connections.computeIfAbsent(privateKeyPath, FirebaseConnectionFactory::createConnection);
    }

    //method to create connection
    public static FirebaseClientConnection createConnection(String privateKeyPath){
        try {
            FileInputStream serviceAccount = new FileInputStream(privateKeyPath);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp app = FirebaseApp.initializeApp(options, privateKeyPath);
            Firestore firestore = FirestoreClient.getFirestore(app);
            logger.info(SUCCESSFULLY_FIREBASE_CONNECTION);
            return new FirebaseClientConnection(firestore, app);
        } catch (IOException e) {
            throw new CustomException(FIREBASE_ERROR_CONNECTION,e);
        }
    }

}
