/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.util.ArrayList;

/**
 *
 * @author Никита
 */
public class TestingValues {
    
    public static ArrayList<String> getInsertion() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"_id\" : { \"$oid\" : \"5a070d6edf1f471c1c57f9a1\" }, \"url\" : \"https://docs.oracle.com\", \"ip\" : \"1.1.1.1\", \"timestamp\" : { \"$date\" : 10000 }, \"timespent\" : { \"$numberLong\" : \"100\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a070d6edf1f471c1c57f9a3\" }, \"url\" : \"https://docs.oracle.com\", \"ip\" : \"2.2.2.2\", \"timestamp\" : { \"$date\" : 10000 }, \"timespent\" : { \"$numberLong\" : \"150\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a070d6edf1f471c1c57f9a5\" }, \"url\" : \"https://docs.oracle.com\", \"ip\" : \"3.3.3.3\", \"timestamp\" : { \"$date\" : 11000 }, \"timespent\" : { \"$numberLong\" : \"100\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a070d6edf1f471c1c57f9a7\" }, \"url\" : \"https://javadevblog.com\", \"ip\" : \"4.4.4.4\", \"timestamp\" : { \"$date\" : 9000 }, \"timespent\" : { \"$numberLong\" : \"500\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a070d6edf1f471c1c57f9a9\" }, \"url\" : \"https://javadevblog.com\", \"ip\" : \"3.3.3.3\", \"timestamp\" : { \"$date\" : 11000 }, \"timespent\" : { \"$numberLong\" : \"500\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a070d6edf1f471c1c57f9ab\" }, \"url\" : \"https://docs.jboss.org\", \"ip\" : \"1.1.1.1\", \"timestamp\" : { \"$date\" : 15000 }, \"timespent\" : { \"$numberLong\" : \"777\" } }");
        
        return instance;
    }

    public static ArrayList<String> getUpdating() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082ac1b262ec26fc4ea838\" }, \"url\" : \"https://docs.oracle.com\", \"ip\" : \"1.1.1.1\", \"timestamp\" : { \"$date\" : 10000 }, \"timespent\" : { \"$numberLong\" : \"100\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082ac1b262ec26fc4ea83a\" }, \"url\" : \"https://docs.oracle.com\", \"ip\" : \"2.2.2.2\", \"timestamp\" : { \"$date\" : 10000 }, \"timespent\" : { \"$numberLong\" : \"150\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082ac1b262ec26fc4ea83c\" }, \"url\" : \"https://stackowerflow.com\", \"ip\" : \"3.3.3.3\", \"timestamp\" : { \"$date\" : 11000 }, \"timespent\" : { \"$numberLong\" : \"666\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082ac1b262ec26fc4ea83e\" }, \"url\" : \"https://javadevblog.com\", \"ip\" : \"4.4.4.4\", \"timestamp\" : { \"$date\" : 9000 }, \"timespent\" : { \"$numberLong\" : \"500\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082ac1b262ec26fc4ea840\" }, \"url\" : \"https://javadevblog.com\", \"ip\" : \"3.3.3.3\", \"timestamp\" : { \"$date\" : 11000 }, \"timespent\" : { \"$numberLong\" : \"500\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082ac1b262ec26fc4ea842\" }, \"url\" : \"https://docs.jboss.org\", \"ip\" : \"1.1.1.1\", \"timestamp\" : { \"$date\" : 15000 }, \"timespent\" : { \"$numberLong\" : \"777\" } }");

        return instance;
    }

    public static ArrayList<String> getDeleting() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082c86b262ec2244c6dd37\" }, \"url\" : \"https://docs.oracle.com\", \"ip\" : \"1.1.1.1\", \"timestamp\" : { \"$date\" : 10000 }, \"timespent\" : { \"$numberLong\" : \"100\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082c87b262ec2244c6dd39\" }, \"url\" : \"https://docs.oracle.com\", \"ip\" : \"2.2.2.2\", \"timestamp\" : { \"$date\" : 10000 }, \"timespent\" : { \"$numberLong\" : \"150\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082c87b262ec2244c6dd3d\" }, \"url\" : \"https://javadevblog.com\", \"ip\" : \"4.4.4.4\", \"timestamp\" : { \"$date\" : 9000 }, \"timespent\" : { \"$numberLong\" : \"500\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082c87b262ec2244c6dd3f\" }, \"url\" : \"https://javadevblog.com\", \"ip\" : \"3.3.3.3\", \"timestamp\" : { \"$date\" : 11000 }, \"timespent\" : { \"$numberLong\" : \"500\" } }");
        instance.add("{ \"_id\" : { \"$oid\" : \"5a082c87b262ec2244c6dd41\" }, \"url\" : \"https://docs.jboss.org\", \"ip\" : \"1.1.1.1\", \"timestamp\" : { \"$date\" : 15000 }, \"timespent\" : { \"$numberLong\" : \"777\" } }");

        return instance;
    }

    public static ArrayList<String> getGettingIPbyUrl() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"ip\" : \"1.1.1.1\" }");
        instance.add("{ \"ip\" : \"2.2.2.2\" }");
        instance.add("{ \"ip\" : \"3.3.3.3\" }");
        return instance;
    }

    public static ArrayList<String> getGettingURLbyIp() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"url\" : \"https://docs.jboss.org\" }");
        instance.add("{ \"url\" : \"https://docs.oracle.com\" }");
        return instance;
    }

    public static ArrayList<String> getGettingURLinPeriod() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"url\" : \"https://docs.oracle.com\" }");
        instance.add("{ \"url\" : \"https://docs.oracle.com\" }");
        instance.add("{ \"url\" : \"https://javadevblog.com\" }");
        return instance;
    }

    public static ArrayList<String> getGettingMRurlTime() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"url\" : \"https://javadevblog.com\", \"timespent\" : 1000.0 }");
        instance.add("{ \"url\" : \"https://docs.jboss.org\", \"timespent\" : 777 }");
        instance.add("{ \"url\" : \"https://docs.oracle.com\", \"timespent\" : 250.0 }");

        return instance;
    }

    public static ArrayList<String> getGettingMRurlCount() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"url\" : \"https://docs.oracle.com\", \"count\" : 2.0 }");
        instance.add("{ \"url\" : \"https://javadevblog.com\", \"count\" : 2.0 }");
        instance.add("{ \"url\" : \"https://docs.jboss.org\", \"count\" : 1.0 }");

        return instance;
    }

    public static ArrayList<String> getGettingMRurlCountInPeriod() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"url\" : \"https://docs.oracle.com\", \"count\" : 2.0 }");
        instance.add("{ \"url\" : \"https://javadevblog.com\", \"count\" : 1.0 }");

        return instance;
    }

    public static ArrayList<String> getGettingMRipCountTime() {
        ArrayList<String> instance = new ArrayList<>();
        instance.add("{ \"ip\" : \"1.1.1.1\", \"value\" : { \"count\" : 2.0, \"timespent\" : 877.0 } }");
        instance.add("{ \"ip\" : \"3.3.3.3\", \"value\" : { \"count\" : 2.0, \"timespent\" : 600.0 } }");
        instance.add("{ \"ip\" : \"4.4.4.4\", \"value\" : { \"timespent\" : 500 }");
        instance.add("{ \"ip\" : \"2.2.2.2\", \"value\" : { \"timespent\" : 150 }");
        
        return instance;
    }
}
