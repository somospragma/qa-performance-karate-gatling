package co.com.bancolombia.certification.svn;


import co.com.bancolombia.certification.svn.application.entrypoint.DataManagement;
import co.com.bancolombia.certification.svn.domain.model.DataTestCase;
import co.com.bancolombia.certification.svn.domain.usecase.SerenityUseCase;
import co.com.bancolombia.certification.svn.factory.firestore.FireStoreConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {


//        FireStoreConnection dataBaseBackEndToEndTest = new FireStoreConnection("src/main/resources/firebase-key.json");
//        SerenityUseCase testCases = new SerenityUseCase(dataBaseBackEndToEndTest.getFirestore());
//
//        // add data using the implementation
//        Map<String, Object> data = new HashMap<>();
//        data.put("data1", "value1");
//        data.put("data2", "value2");
//        data.put("data3", "value3");
//        System.out.println("Adding data to document...");
//        testCases.addData("acceptance_test","CP006",data);
//
//        //get all data in collection
//        System.out.println("Getting all documents from collection...");
//        List<DataTestCase> testCaseInfo = testCases.getAllData("acceptance_test");
//        for(DataTestCase dataInfo: testCaseInfo){
//            System.out.println(dataInfo);
//        }
//
//        //get specific case info
//        String caseId = "CP001";
//        System.out.println("Getting single document with ID "+ caseId +" ...");
//        DataTestCase dataTestCase = testCases.getSpecificData("acceptance_test",caseId);
//        System.out.println(dataTestCase);
//
//        // get a test case field info
//        String field = "header";
//        System.out.println("Getting " + field + " value that exist into " + caseId + " ...");
//        Map<String, Object> header = testCases.getSpecificDataValue("acceptance_test",caseId,field);
//        System.out.println("the field value is: " + header);


//        DataManagement.overWriteFeature("src/main/resources/example.feature","src/main/resources/firebase-key.json");

    }

}