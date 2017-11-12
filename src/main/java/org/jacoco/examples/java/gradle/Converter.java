package org.jacoco.examples.java.gradle;

import java.sql.Timestamp;
import org.json.JSONObject;

public class Converter {
    
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


