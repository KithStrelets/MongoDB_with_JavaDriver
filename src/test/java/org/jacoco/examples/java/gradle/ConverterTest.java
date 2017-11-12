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
public class ConverterTest {
    /**
     * Test of orgJsonDeserialize method, of class Converter.
     */
    @Test
    public void testOrgJsonDeserialize() {
        
        System.out.println("orgJsonDeserialize");
        String targetJsonString = "";
        Converter instance = new Converter();
        ServerLog expResult = null;
        ServerLog result = instance.orgJsonDeserialize(targetJsonString);
        assertEquals(expResult, result);
        
        targetJsonString = "{ \"_id\" : { \"$oid\" : \"5a070d6edf1f471c1c57f9ab\" }, \"url\" : \"https://docs.jboss.org\", \"ip\" : \"1.1.1.1\", \"timestamp\" : { \"$date\" : 15000 }, \"timespent\" : { \"$numberLong\" : \"777\" } }";
        expResult = new ServerLog("https://docs.jboss.org", "1.1.1.1", new Timestamp(15000), 777);
        result = instance.orgJsonDeserialize(targetJsonString);
        assertEquals(expResult.getFieldIP(), result.getFieldIP());
        assertEquals(expResult.getFieldUrl(), result.getFieldUrl());
        assertEquals(expResult.getFieldTimeSpent(), result.getFieldTimeSpent());
        assertEquals(expResult.getFieldTimeStamp(), result.getFieldTimeStamp());
    }
    
}
