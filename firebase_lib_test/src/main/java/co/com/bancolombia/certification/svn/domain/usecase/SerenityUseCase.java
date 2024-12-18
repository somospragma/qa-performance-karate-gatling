package co.com.bancolombia.certification.svn.domain.usecase;

import co.com.bancolombia.certification.svn.domain.model.DataTestCase;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SerenityUseCase implements DataUseCase {

    private static final Logger logger = LoggerFactory.getLogger(SerenityUseCase.class);

    private final Firestore dataBase;

    public SerenityUseCase(Firestore dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void addData(String suitCase, String testCaseId, Map<String, Object> data) throws Exception {
        DocumentReference docRef = dataBase.collection(suitCase).document(testCaseId);
        ApiFuture<WriteResult> result = docRef.set(data);
        String message = "Update time : " + result.get().getUpdateTime();
        logger.info(message);
    }

    @Override
    public List<DataTestCase> getAllData(String suitCase) throws Exception {
        ApiFuture<QuerySnapshot> query = dataBase.collection(suitCase).get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> testCase = querySnapshot.getDocuments();
        return testCase.stream()
                .map(test -> DataTestCase.fromMap(test.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String,Object> getSpecificDataValue(String suitCase, String testCaseId, String key) throws Exception {
        DocumentSnapshot query = dataBase.collection(suitCase).document(testCaseId).get().get();
        if(query.get(key)!=null){
            return (Map<String, Object>) query.get(key);
        }else {
            String message = "The Key: " + key +" may not exist in data test case";
            logger.error(message);
            return (Map<String, Object>) Collections.emptyList();
        }
    }

    @Override
    public DataTestCase getSpecificData(String suitCase,String testCaseId) throws Exception {
        ApiFuture<DocumentSnapshot> query = dataBase.collection(suitCase).document(testCaseId).get();
        DocumentSnapshot queryTestCase = query.get();
        if(queryTestCase.exists() && queryTestCase.getData()!=null) {
            return DataTestCase.fromMap(queryTestCase.getData());
        }else{
            String message = "The testCase data does not exist";
            logger.error(message);
            return null;
        }
    }



}
