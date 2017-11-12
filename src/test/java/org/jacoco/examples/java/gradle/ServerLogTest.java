/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.sql.Timestamp;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Никита
 */
public class ServerLogTest {

    private final ServerLog instance = new ServerLog("test","0.0.0.1",new Timestamp(111), 111);

    /**
     * Test of getFieldUrl method, of class ServerLog.
     */
    @Test
    public void testGetFieldUrl() {
        System.out.println("getFieldUrl");
        String expResult = "test";
        String result = instance.getFieldUrl();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFieldUrl method, of class ServerLog.
     */
    @Test
    public void testSetFieldUrl() {
        System.out.println("setFieldUrl");
        String fieldUrl = "test";
        instance.setFieldUrl(fieldUrl);
        assertEquals(fieldUrl, instance.getFieldUrl());
    }

    /**
     * Test of getFieldIP method, of class ServerLog.
     */
    @Test
    public void testGetFieldIP() {
        System.out.println("getFieldIP");
        String expResult = "0.0.0.1";
        String result = instance.getFieldIP();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFieldIP method, of class ServerLog.
     */
    @Test
    public void testSetFieldIP() {
        System.out.println("setFieldIP");
        String fieldIP = "1.1.1.0";
        instance.setFieldIP(fieldIP);
        assertEquals(fieldIP, instance.getFieldIP());
    }

    /**
     * Test of getFieldTimeStamp method, of class ServerLog.
     */
    @Test
    public void testGetFieldTimeStamp() {
        System.out.println("getFieldTimeStamp");
        Timestamp expResult = new Timestamp(111);
        Timestamp result = instance.getFieldTimeStamp();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFieldTimeStamp method, of class ServerLog.
     */
    @Test
    public void testSetFieldTimeStamp() {
        System.out.println("setFieldTimeStamp");
        Timestamp fieldTimeStamp = new Timestamp(222);
        instance.setFieldTimeStamp(fieldTimeStamp);
        assertEquals(fieldTimeStamp, instance.getFieldTimeStamp());
    }

    /**
     * Test of getFieldTimeSpent method, of class ServerLog.
     */
    @Test
    public void testGetFieldTimeSpent() {
        System.out.println("getFieldTimeSpent");
        long expResult = 111L;
        long result = instance.getFieldTimeSpent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFieldTimeSpent method, of class ServerLog.
     */
    @Test
    public void testSetFieldTimeSpent() {
        System.out.println("setFieldTimeSpent");
        long fieldTimeSpent = 222L;
        instance.setFieldTimeSpent(fieldTimeSpent);
        assertEquals(fieldTimeSpent, instance.getFieldTimeSpent());
    }

    /**
     * Test of toString method, of class ServerLog.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "{\n\t\"url\": "+"test"
              +",\n\t\"ip\": "+ "0.0.0.1"
              +",\n\t\"timestamp\": "+new Timestamp(111)
              +",\n\t\"timespent\": "+111
              +"\n}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
