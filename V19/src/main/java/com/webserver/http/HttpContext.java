package com.webserver.http;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.Map;

public class HttpContext {
    private static Map<String,String>mimeMapping=new HashMap<>();

    static {

    }

    private static void initmimeMapping(){
        SAXReader reader=new SAXReader();
        //Document doc=reader.read("config/web.xml");
    }
}
