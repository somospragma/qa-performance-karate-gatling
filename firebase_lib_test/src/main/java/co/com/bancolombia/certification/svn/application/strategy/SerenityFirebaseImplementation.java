package co.com.bancolombia.certification.svn.application.strategy;

import co.com.bancolombia.certification.svn.domain.model.DataTestCase;
import co.com.bancolombia.certification.svn.domain.usecase.SerenityUseCase;
import co.com.bancolombia.certification.svn.factory.firestore.FireStoreConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static co.com.bancolombia.certification.svn.utils.SystemConstants.*;


/***
 * Implementation class to use in Serenity BDD - Rest automation test projects
 * Strategy
 */
public class SerenityFirebaseImplementation {

    private static final Logger logger = LoggerFactory.getLogger(SerenityFirebaseImplementation.class);
    private final String firebasePrivateKeyPath;



    public SerenityFirebaseImplementation(String firebasePrivateKeyPath) {
        this.firebasePrivateKeyPath = firebasePrivateKeyPath;
    }


    private SerenityUseCase makeFireStoreConnection() {
        FireStoreConnection testDataBase = new FireStoreConnection(firebasePrivateKeyPath);
        return new SerenityUseCase(testDataBase.getFirestore());
    }

    public void updateDataCollection(String collection, String document , Map<String, Object> fields)  {
        SerenityUseCase testDataBaseInfo = makeFireStoreConnection();
        try {
            testDataBaseInfo.addData(collection,document,fields);
        } catch (Exception e) {
            logger.error("Error trying to update data base",e);
        }
    }

    public Map<String, Map<String, Object>> getAllDataFromCollection(String collection) {
        SerenityUseCase testDataBaseInfo = makeFireStoreConnection();
        Map<String, Map<String, Object>> mappedInfo = new HashMap<>();
        try {
            List<DataTestCase>  testCaseInfo = testDataBaseInfo.getAllData(collection);
            for (DataTestCase dataInfo: testCaseInfo){
                Map<String, Object> caseData = new HashMap<>();
                caseData.put(ID,dataInfo.getId());
                caseData.put(DESCRIPTION,dataInfo.getDescription());
                caseData.put(FIELDS,dataInfo.getFields());
                mappedInfo.put(dataInfo.getId()!=null?dataInfo.getId():"undefined_id",caseData);
            }
            return mappedInfo;

        } catch (Exception e) {
            String message = "Error trying to consult all data into: " + collection;
            logger.error(message,e);
            return Collections.emptyMap();
        }

    }

    public List<String> getAllDataFromDocument(String collection,String document){
        SerenityUseCase testDataBaseInfo = makeFireStoreConnection();
        List<String> results = new ArrayList<>();
        Map<String,String> mappedInfo = new HashMap<>();
        try {
            DataTestCase dataTestCase = testDataBaseInfo.getSpecificData(collection,document);
            String caseId = dataTestCase.getId();
            String caseDescription = dataTestCase.getDescription();
            Map<String,Object> fields = dataTestCase.getFields();
            results.add(caseId);
            results.add(caseDescription);
            for(Object value : fields.values()){
                results.add(value.toString());
            }
            return results;
        } catch (Exception e) {
            String message = "Error trying to consult all data into: " + collection + "and " +document;
            logger.error(message,e);
            return null;
        }
    }



}
