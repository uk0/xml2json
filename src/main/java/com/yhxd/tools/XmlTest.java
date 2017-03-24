package com.yhxd.tools;

/**
 * Created by zhangjianxin on 2017/3/25.
 */

public class XmlTest extends XmlExercise {

    public static void main(String[] args) {
       String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
               "<note>\n" +
               "<to>George</to>\n" +
               "<from>John</from>\n" +
               "<heading>Reminder</heading>\n" +
               "<body>Don't forget the meeting!</body>\n" +
               "</note>";
        String str = xml2json(xml);
        System.out.println("to_json" + str);

    }
}