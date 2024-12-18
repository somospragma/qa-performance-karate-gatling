package co.com.bancolombia.certification.svn.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuitTestCase {


    private String name;
    private List<DataTestCase> testCases;

    public Map<String, Object> toMap(){
        return Map.of(
                "name",name,
                "testCases", testCases.stream().map(
                        DataTestCase::toMap).collect(Collectors.toList())
                );
    }

    public static SuitTestCase fromMap(Map<String,Object> map){
        String name = (String) map.get("name");
        List<Map<String,Object>> testCasesMap = (List<Map<String, Object>>) map.get("testCases");
        List<DataTestCase> testCases = testCasesMap.stream()
                .map(DataTestCase::fromMap)
                .collect(Collectors.toList());
        return new SuitTestCase(name, testCases);
    }




}
