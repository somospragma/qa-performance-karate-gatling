package co.com.bancolombia.certification.svn.domain.usecase;

import co.com.bancolombia.certification.svn.domain.model.DataTestCase;

import java.util.List;
import java.util.Map;

public interface DataUseCase {

    void addData(String suitCase,String testCaseId, Map<String, Object> data) throws Exception;

    List<DataTestCase> getAllData(String suitCase ) throws Exception;

    Map<String,Object> getSpecificDataValue(String suitCase,String testCaseId, String key) throws Exception;
    DataTestCase getSpecificData(String suitCase,String testCaseId) throws Exception;
}

