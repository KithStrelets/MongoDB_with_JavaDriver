/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Никита
 */
public class MongoDBConnectionTest {
    
    private final MongoDBConnection instance = new MongoDBConnection();
    private static ArrayList<String> tested = new ArrayList<>();
    private ArrayList<ServerLog> expectedLogs;
    private ArrayList<ServerLog> testLogs;
    /**
     * Test of insertLog method, of class MongoDBConnection.
     */
    @BeforeClass
    public static void setUp(){
        MongoDBConnection setUpInstance = new MongoDBConnection();
                System.out.println("insertLog");
        ServerLog sl = new ServerLog("https://docs.oracle.com", "1.1.1.1", new Timestamp(10000), 100);
        setUpInstance.insertLog(sl);
        sl = new ServerLog("https://docs.oracle.com", "2.2.2.2", new Timestamp(10000), 150);
        setUpInstance.insertLog(sl);
        sl = new ServerLog("https://docs.oracle.com", "3.3.3.3", new Timestamp(11000), 100);
        setUpInstance.insertLog(sl);
        sl = new ServerLog("https://javadevblog.com", "4.4.4.4", new Timestamp(9000), 500);
        setUpInstance.insertLog(sl);
        sl = new ServerLog("https://javadevblog.com", "3.3.3.3", new Timestamp(11000), 500);
        setUpInstance.insertLog(sl);
        sl = new ServerLog("https://docs.jboss.org", "1.1.1.1", new Timestamp(15000), 777);
        setUpInstance.insertLog(sl);
        tested = setUpInstance.getAllData();
    }
    
    @AfterClass
    public static void clear(){
        MongoDBConnection instance = new MongoDBConnection();
        instance.clearAll();
    }
    
    @Test
    public void testInsertLog() {
        // TODO review the generated test code and remove the default call to fail.
        //tested = instance.getAllData();
        expectedLogs = new ArrayList<>();
        testLogs = new ArrayList<>();
        TestingValues.getInsertion().forEach((st) -> {
            expectedLogs.add(new Converter().orgJsonDeserialize(st));
        });
        tested.forEach((st) -> {
            testLogs.add(new Converter().orgJsonDeserialize(st));
        });
        for(int i = 0; i < expectedLogs.size(); i++){
            assertEquals("Insert is wrong", testLogs.get(i).getFieldUrl(), expectedLogs.get(i).getFieldUrl());
            assertEquals("Insert is wrong", testLogs.get(i).getFieldIP(), expectedLogs.get(i).getFieldIP());
            assertEquals("Insert is wrong", testLogs.get(i).getFieldTimeStamp(), expectedLogs.get(i).getFieldTimeStamp());
            assertEquals("Insert is wrong", testLogs.get(i).getFieldTimeSpent(), expectedLogs.get(i).getFieldTimeSpent());
        }
        
    }

    /**
     * Test of updateLog method, of class MongoDBConnection.
     */
    @Test
    public void testUpdateLog() {
        System.out.println("updateLog");
        ServerLog target = new ServerLog("https://docs.oracle.com", "3.3.3.3", new Timestamp(11000), 100);
        ServerLog newLog = new ServerLog("https://stackowerflow.com", "3.3.3.3", new Timestamp(11000), 666);
        instance.updateLog(target, newLog);
        expectedLogs = new ArrayList<>();
        testLogs = new ArrayList<>();
        TestingValues.getUpdating().forEach((st) -> {
            expectedLogs.add(new Converter().orgJsonDeserialize(st));
        });
        instance.getAllData().forEach((st) -> {
            testLogs.add(new Converter().orgJsonDeserialize(st));
        });
        for(int i = 0; i < expectedLogs.size(); i++){
            assertEquals("Update is wrong", testLogs.get(i).getFieldUrl(), expectedLogs.get(i).getFieldUrl());
            assertEquals("Update is wrong", testLogs.get(i).getFieldIP(), expectedLogs.get(i).getFieldIP());
            assertEquals("Update is wrong", testLogs.get(i).getFieldTimeStamp(), expectedLogs.get(i).getFieldTimeStamp());
            assertEquals("Update is wrong", testLogs.get(i).getFieldTimeSpent(), expectedLogs.get(i).getFieldTimeSpent());
        }
    }

    /**
     * Test of deleteLog method, of class MongoDBConnection.
     */
    @Test
    public void testDeleteLog() {
        System.out.println("deleteLog");
        ServerLog deleteLog = new ServerLog("https://stackowerflow.com", "3.3.3.3", new Timestamp(11000), 666);
        instance.deleteLog(deleteLog);
        expectedLogs = new ArrayList<>();
        testLogs = new ArrayList<>();
        TestingValues.getDeleting().forEach((st) -> {
            expectedLogs.add(new Converter().orgJsonDeserialize(st));
        });
        instance.getAllData().forEach((st) -> {
            testLogs.add(new Converter().orgJsonDeserialize(st));
        });
        for(int i = 0; i < expectedLogs.size(); i++){
            assertEquals("Delete is wrong", testLogs.get(i).getFieldUrl(), expectedLogs.get(i).getFieldUrl());
            assertEquals("Delete is wrong", testLogs.get(i).getFieldIP(), expectedLogs.get(i).getFieldIP());
            assertEquals("Delete is wrong", testLogs.get(i).getFieldTimeStamp(), expectedLogs.get(i).getFieldTimeStamp());
            assertEquals("Delete is wrong", testLogs.get(i).getFieldTimeSpent(), expectedLogs.get(i).getFieldTimeSpent());
        }
    }

    /**
     * Test of getIpByUrl method, of class MongoDBConnection.
     */
    @Test
    public void testGetIpByUrl() {
        System.out.println("getIpByUrl");
        String urlString = "https://docs.oracle.com";
        ArrayList<String> testedStrings = instance.getIpByUrl(urlString);
        assertEquals("Ip by url is wrong", testedStrings, TestingValues.getGettingIPbyUrl());
    }

    /**
     * Test of getUrlByPeriod method, of class MongoDBConnection.
     */
    @Test
    public void testGetUrlByPeriod() {
        System.out.println("getUrlByPeriod");
        Timestamp fromTime = new Timestamp(9000);
        Timestamp toTime = new Timestamp(10500);
        ArrayList<String> testedStrings = instance.getUrlByPeriod(fromTime, toTime);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Url by period error", testedStrings, TestingValues.getGettingURLinPeriod());
    }

    /**
     * Test of getUrlByIp method, of class MongoDBConnection.
     */
    @Test
    public void testGetUrlByIp() {
        System.out.println("getUrlByIp");
        String ipString = "1.1.1.1";
        ArrayList<String> testedStrings = instance.getUrlByIp(ipString);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Url by ip error", testedStrings, TestingValues.getGettingURLbyIp());
    }

    /**
     * Test of getMapReducedUrlTime method, of class MongoDBConnection.
     */
    @Test
    public void testGetMapReducedUrlTime() {
        System.out.println("getMapReducedUrlTime");
        ArrayList<String> testedStrings = instance.getMapReducedUrlTime();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("MapReduce timespent on url error", testedStrings, TestingValues.getGettingMRurlTime());
    }

    /**
     * Test of getMapReducedUrlCount method, of class MongoDBConnection.
     */
    @Test
    public void testGetMapReducedUrlCount() {
        System.out.println("getMapReducedUrlCount");
        ArrayList<String> testedStrings = instance.getMapReducedUrlCount();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("MapReduce count of urls error", testedStrings, TestingValues.getGettingMRurlCount());
    }

    /**
     * Test of getMapReducedUrlCountByPeriod method, of class MongoDBConnection.
     */
    @Test
    public void testGetMapReducedUrlCountByPeriod() {
        System.out.println("getMapReducedUrlCountByPeriod");
        Timestamp fromTime = new Timestamp(9000);
        Timestamp toTime = new Timestamp(10500);
        ArrayList<String> testedStrings = instance.getMapReducedUrlCountByPeriod(fromTime, toTime);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("MapReduce count of urls by period error", testedStrings, TestingValues.getGettingMRurlCountInPeriod());
    }

    /**
     * Test of getMapReducedIpCountAndTime method, of class MongoDBConnection.
     */
    @Test
    public void testGetMapReducedIpCountAndTime() {
        System.out.println("getMapReducedIpCountAndTime");
        ArrayList<String> testedStrings = instance.getMapReducedIpCountAndTime();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("MapReduce count of url and their sum of time error", testedStrings, TestingValues.getGettingMRipCountTime());
    }
}

