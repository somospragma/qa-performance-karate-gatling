package co.com.bancolombia.certification.svn.factory.firebase;

import co.com.bancolombia.certification.svn.application.exceptions.CustomException;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static co.com.bancolombia.certification.svn.utils.LoggerMessage.*;


public class FirebaseClientConnection {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseClientConnection.class);
    @Getter
    private final Firestore firestore;
    private final FirebaseApp firebaseApp;

    public FirebaseClientConnection(Firestore firestore, FirebaseApp firebaseApp) {
        this.firestore = firestore;
        this.firebaseApp = firebaseApp;
    }

    public void closeConnection() {
        try {
            firebaseApp.delete();
            logger.info(SUCCESSFULLY_FIREBASE_CLOSE_CONNECTION);
        } catch (Exception e) {
            throw new CustomException(ERROR_FIREBASE_CLOSE_CONNECTION, e);
        }
    }
}
