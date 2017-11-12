/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Никита
 */
public class MongoDBConnection {

    private MongoClient mongo;
    private MongoDatabase db;
    private MongoCursor<Document> cursor;

    private void connectDB() {

        mongo = new MongoClient("localhost");
        db = mongo.getDatabase("serverlog");
    }

    public void insertLog(ServerLog sl) {
        connectDB();
        MongoCollection logs = db.getCollection("logs");
        Document doc = new Document();
        doc.append("url", sl.getFieldUrl());
        doc.append("ip", sl.getFieldIP());
        doc.append("timestamp", sl.getFieldTimeStamp());
        doc.append("timespent", sl.getFieldTimeSpent());
        logs.insertOne(doc);
        mongo.close();
    }

    public void updateLog(ServerLog target, ServerLog newLog) {
        connectDB();
        MongoCollection logs = db.getCollection("logs");
        Document old = new Document();
        old.append("url", target.getFieldUrl());
        old.append("ip", target.getFieldIP());
        old.append("timestamp", target.getFieldTimeStamp());
        old.append("timespent", target.getFieldTimeSpent());

        Document newObject = new Document();
        newObject.append("url", newLog.getFieldUrl());
        newObject.append("ip", newLog.getFieldIP());
        newObject.append("timestamp", newLog.getFieldTimeStamp());
        newObject.append("timespent", newLog.getFieldTimeSpent());
        logs.updateOne(old, new Document("$set", newObject));

        mongo.close();
    }

    public void deleteLog(ServerLog deleteLog) {
        connectDB();
        MongoCollection logs = db.getCollection("logs");
        BasicDBObject deleteObj = new BasicDBObject();
        deleteObj.put("url", deleteLog.getFieldUrl());
        deleteObj.put("ip", deleteLog.getFieldIP());
        deleteObj.put("timestamp", deleteLog.getFieldTimeStamp());
        deleteObj.put("timespent", deleteLog.getFieldTimeSpent());
        logs.deleteOne(deleteObj);
        mongo.close();
    }

    public void clearAll(){
        connectDB();
        MongoCollection logs = db.getCollection("logs");
        logs.drop();
        mongo.close();
    }
    
    public ArrayList<String> getIpByUrl(String urlString) {
        connectDB();
        ArrayList<String> res = new ArrayList<>();
        MongoCollection logs = db.getCollection("logs");
        cursor = logs
                .find(eq("url", urlString))
                .projection(fields(include("ip"), excludeId()))
                .sort(new Document("ip", 1)).iterator();
        String docJson = "";
        while (cursor.hasNext()) {
            docJson = cursor.next().toJson();
            res.add(docJson);
            System.out.println(docJson);
        }
        cursor.close();
        mongo.close();
        return res;
    }

    public ArrayList<String> getUrlByPeriod(Timestamp fromTime, Timestamp toTime) {
        connectDB();
        ArrayList<String> res = new ArrayList<>();
        MongoCollection logs = db.getCollection("logs");
        cursor = logs
                .find(and(gte("timestamp", fromTime), lte("timestamp", toTime)))
                .projection(fields(include("url"), excludeId()))
                .sort(new Document("url", 1)).iterator();
        String docJson = "";
        while (cursor.hasNext()) {
            docJson = cursor.next().toJson();
            res.add(docJson);
            System.out.println(docJson);
        }
        cursor.close();
        mongo.close();
        return res;
    }

    public ArrayList<String> getUrlByIp(String ipString) {
        connectDB();
        ArrayList<String> res = new ArrayList<>();
        MongoCollection logs = db.getCollection("logs");
        cursor = logs
                .find(eq("ip", ipString))
                .projection(fields(include("url"), excludeId()))
                .sort(new Document("url", 1)).iterator();
        String docJson = "";
        while (cursor.hasNext()) {
            docJson = cursor.next().toJson();
            res.add(docJson);
            System.out.println(docJson);
        }
        cursor.close();
        mongo.close();
        return res;
    }

    public ArrayList<String> getAllData(){
        connectDB();
        ArrayList<String> res = new ArrayList<>();
        MongoCollection logs = db.getCollection("logs");
        cursor = logs.find().iterator();
        String docJson = "";
        while (cursor.hasNext()) {
            docJson = cursor.next().toJson();
            res.add(docJson);
            System.out.println(docJson);
        }
        cursor.close();
        mongo.close();
        return res;
    }
    
    public ArrayList<String> getMapReducedUrlTime() {
        connectDB();
        ArrayList<String> res = new ArrayList<>();
        MongoCollection logs = db.getCollection("logs");
        String collectionName = "url_timespent";
        String mapFunc = "function (){emit(this.url, this.timespent);}";
        String reduceFunc = "function(keyUrl, valuesTime) {return Array.sum(valuesTime);}";
        logs.mapReduce(mapFunc, reduceFunc).collectionName(collectionName).toCollection();
        cursor = db.getCollection(collectionName).find()
                .sort(new Document("value", -1)).iterator();
        String docJson = "";
        while (cursor.hasNext()) {
            docJson = cursor.next().toJson()
                    .replace("_id", "url")
                    .replace("value", "timespent")
                    .replace("{ \"$numberLong\" : \"", "")
                    .replace("\" } }", " }");
            res.add(docJson);
            System.out.println(docJson);
        }
        cursor.close();
        mongo.close();
        return res;
    }

    public ArrayList<String> getMapReducedUrlCount() {
        connectDB();
        ArrayList<String> res = new ArrayList<>();
        MongoCollection logs = db.getCollection("logs");
        String collectionName = "url_count";
        String mapFunc = "function (){emit(this.url, 1);}";
        String reduceFunc = "function(keyUrl, valuesCount) {return Array.sum(valuesCount);}";
        logs.mapReduce(mapFunc, reduceFunc).collectionName(collectionName).toCollection();
        cursor = db.getCollection(collectionName).find()
                .sort(new Document("value", -1)).iterator();
        String docJson = "";
        while (cursor.hasNext()) {
            docJson = cursor.next().toJson()
                    .replace("_id", "url")
                    .replace("value", "count");
            res.add(docJson);
            System.out.println(docJson);
        }
        cursor.close();
        mongo.close();
        return res;
    }

    public ArrayList<String> getMapReducedUrlCountByPeriod(Timestamp fromTime, Timestamp toTime) {
        connectDB();
        ArrayList<String> res = new ArrayList<>();
        MongoCollection logs = db.getCollection("logs");
        String collectionName = "url_count_period";
        String mapFunc = "function (){var ticks = this.timestamp.getTime(); if((ticks >= " 
                + fromTime.getTime() + ") && (ticks <= " 
                + toTime.getTime() + "))emit(this.url, 1);}";
        String reduceFunc = "function(keyUrl, valuesCount) {return Array.sum(valuesCount);}";
        logs.mapReduce(mapFunc, reduceFunc).collectionName(collectionName).toCollection();
        cursor = db.getCollection(collectionName).find()
                .sort(new Document("_id", 1))
                .sort(new Document("value", -1)).iterator();
        String docJson = "";
        while (cursor.hasNext()) {
            docJson = cursor.next().toJson()
                    .replace("_id", "url")
                    .replace("value", "count");
            res.add(docJson);
            System.out.println(docJson);
        }
        cursor.close();
        mongo.close();
        return res;
    }

    public ArrayList<String> getMapReducedIpCountAndTime() {
        connectDB();
        ArrayList<String> res = new ArrayList<>();
        MongoCollection logs = db.getCollection("logs");
        String collectionName = "ip_by_urlCount_urlTime";
        String mapFunc = "function (){emit(this.ip, this.timespent);}";
        String reduceFunc = "function(keyUrl, values) "
                + "{return {count:values.length, timespent:Array.sum(values)}; }";
       logs.mapReduce(mapFunc, reduceFunc).collectionName(collectionName).toCollection();
        cursor = db.getCollection(collectionName).find()
                .sort(new Document("_id", 1))
                .sort(new Document("value", -1))
                .iterator();
        String docJson = "";
        while (cursor.hasNext()) {
            docJson = cursor.next().toJson()
                    .replace("_id", "ip")
                    .replace("$numberLong", "timespent")
                    .replace("\"timespent\" : \"", "\"timespent\" : ")
                    .replace("\" } }", " }");
            res.add(docJson);
            System.out.println(docJson);
        }
        cursor.close();
        mongo.close();
        return res;
    }

}
