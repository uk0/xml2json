package com.yhxd.tools;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.jdom.Document;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


/**
 * Created by zhangjianxin on 2017/3/25.
 */
public class XmlExercise {
    public static int PRETTY_PRINT_INDENT_FACTOR = 4; //String 返回的空格数量，方便直接转换为 json
    /**
     * 将xml字符串<STRONG>转换</STRONG>为JSON字符串
     *
     * @param xmlString
     *            xml字符串
     * @return JSON<STRONG>对象</STRONG>
     */
    public static String xml2json(String xmlString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON json = xmlSerializer.read(xmlString);
        return json.toString(1);
    }

    /**
     * 将xmlDocument<STRONG>转换</STRONG>为JSON<STRONG>对象</STRONG>
     *
     * @param xmlDocument
     *            XML Document
     * @return JSON<STRONG>对象</STRONG>
     */
    public static String xml2json(Document xmlDocument) {
        return xml2json(xmlDocument.toString());
    }

    /**
     * JSON(数组)字符串<STRONG>转换</STRONG>成XML字符串
     *
     * @param jsonString
     * @return
     */
    public static String json2xml(String jsonString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        return xmlSerializer.write(JSONSerializer.toJSON(jsonString));
        // return xmlSerializer.write(JSONArray.fromObject(jsonString));//这种方式只支持JSON数组
    }


    /**
     * 将xml字符串<STRONG>转换</STRONG>为JSON字符串
     *
     * @param xmlString
     *            xml字符串
     * @return JSON<STRONG>对象</STRONG>
     *
     * @deprecated 方法默认会去掉<xml></xml>
     */
    public  static com.alibaba.fastjson.JSONObject xml2fastjson(String xmltostring){
        String jsonPrettyPrintString= "";
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xmltostring);
            jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
        return com.alibaba.fastjson.JSON.parseObject(jsonPrettyPrintString);
    }

}