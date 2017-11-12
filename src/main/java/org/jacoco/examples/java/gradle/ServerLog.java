/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.sql.Timestamp;

/**
 *
 * @author Никита
 */
   //@JsonIgnoreProperties({"_id"})
class ServerLog {

    //@JsonSubTypes({
        //@JsonSubTypes.Type(value = FieldObject.class, name = "field_object"),
        //@JsonSubTypes.Type(value = FieldMap.class, name = "field_map")
    //})
   private String fieldUrl;
   private String fieldIP;  
   private Timestamp fieldTimeStamp;
   private long fieldTimeSpent;
    
       
   //@JsonCreator
   public ServerLog(
      //@JsonProperty("url") 
           String fUrl, 
      //@JsonProperty("ip") 
           String fIP,
      //@JsonProperty("timestamp") 
           Timestamp fTimeStamp,
      //@JsonProperty("timespent") 
           long fTimeSpent){
       fieldUrl = fUrl;
       fieldIP = fIP;
       fieldTimeStamp = fTimeStamp;
       fieldTimeSpent = fTimeSpent; 
   }
   
   //@JsonProperty("url")
   public String getFieldUrl() {
        return fieldUrl;
    }

    public void setFieldUrl(String fieldUrl) {
        this.fieldUrl = fieldUrl;
    }

    //@JsonProperty("ip")
    public String getFieldIP() {
        return fieldIP;
    }

    public void setFieldIP(String fieldIP) {
        this.fieldIP = fieldIP;
    }
    
    //@JsonProperty("timestamp")    
    public Timestamp getFieldTimeStamp() {
        return fieldTimeStamp;
    }

    public void setFieldTimeStamp(Timestamp fieldTimeStamp) {
        this.fieldTimeStamp = fieldTimeStamp;
    }
    
    //@JsonProperty("timespent")
    public long getFieldTimeSpent() {
        return fieldTimeSpent;
    }

    public void setFieldTimeSpent(long fieldTimeSpent) {
        this.fieldTimeSpent = fieldTimeSpent;
    }
   
   @Override
   public String toString(){
      return "{\n\t\"url\": "+fieldUrl
              +",\n\t\"ip\": "+ fieldIP
              +",\n\t\"timestamp\": "+fieldTimeStamp
              +",\n\t\"timespent\": "+fieldTimeSpent
              +"\n}";
   }
}
