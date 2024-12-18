package co.com.bancolombia.certification.svn.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static co.com.bancolombia.certification.svn.utils.SystemConstants.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataTestCase {

    private String id; //obligatory field
    private String description; //obligatory field
    private Map<String,Object> fields = new HashMap<>(); //another fields

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(ID, id);
        map.put(DESCRIPTION, description);
        map.putAll(fields);
        return map;
    }

    public static DataTestCase fromMap(Map<String,Object> map){
        String id  = (String) map.getOrDefault("id","");
        String description = (String) map.getOrDefault("description","");
        Map<String, Object> fields = new HashMap<>(map);
        Map<String,Object> orderedFields = new TreeMap<>(fields);
        orderedFields.remove(ID);
        orderedFields.remove(DESCRIPTION);
        return new DataTestCase(id, description,  orderedFields);

    }


}
