package co.com.bancolombia.certification.svn.factory.firestore;

import co.com.bancolombia.certification.svn.factory.firebase.FirebaseConnectionFactory;
import com.google.cloud.firestore.Firestore;



public class FireStoreConnection implements ObjectConnection{

    private final Firestore firestore;

    public FireStoreConnection(String keyPath) {
        this.firestore = FirebaseConnectionFactory.getConnection(keyPath).getFirestore();
    }

    @Override
    public Firestore getFirestore() {
        return firestore;
    }
}
