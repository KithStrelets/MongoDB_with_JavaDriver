package org.jacoco.examples.java.gradle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;




public class Converter {
    private final ObjectMapper mapper = new ObjectMapper();
    
    public String orgJsonSerialize(ServerLog serObj){
        
             Map<String, Object> objectDataMap = new HashMap<String, Object>();
             objectDataMap.put("url", serObj.getFieldUrl());
             objectDataMap.put("ip", serObj.getFieldIP());
             objectDataMap.put("timestamp", serObj.getFieldTimeStamp());
             objectDataMap.put("timespent", serObj.getFieldTimeSpent());
             JSONObject root = new JSONObject(objectDataMap);

             System.out.println(root.toString());
             return root.toString();  
    } 
    
    public ServerLog orgJsonDeserialize(String targetJsonString){
        
             if(targetJsonString.length() == 0)return null;
             JSONObject jsonObj = new JSONObject(targetJsonString);
             ServerLog jsonParsed = new ServerLog(
                     jsonObj.getString("url"),
                     jsonObj.getString("ip"),
                     new Timestamp(jsonObj.getJSONObject("timestamp").getLong("$date")),
                     jsonObj.getJSONObject("timespent").getLong("$numberLong"));
             
             System.out.println(jsonParsed);
             return jsonParsed;
    } 
}


