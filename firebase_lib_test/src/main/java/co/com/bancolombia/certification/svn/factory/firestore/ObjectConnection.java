package co.com.bancolombia.certification.svn.factory.firestore;

import com.google.cloud.firestore.Firestore;

public interface ObjectConnection {

    public Firestore getFirestore();
}
