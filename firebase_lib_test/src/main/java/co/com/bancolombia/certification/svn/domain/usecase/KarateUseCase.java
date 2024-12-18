package co.com.bancolombia.certification.svn.domain.usecase;

import co.com.bancolombia.certification.svn.domain.model.DataTestCase;

import java.util.List;
import java.util.Map;

public class KarateUseCase  implements DataUseCase{
    @Override
    public void addData(String suitCase, String testCaseId, Map<String, Object> data) throws Exception {

    }

    @Override
    public List<DataTestCase> getAllData(String suitCase) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> getSpecificDataValue(String suitCase, String testCaseId, String key) throws Exception {
        return null;
    }

    @Override
    public DataTestCase getSpecificData(String suitCase, String testCaseId) throws Exception {
        return null;
    }
}
