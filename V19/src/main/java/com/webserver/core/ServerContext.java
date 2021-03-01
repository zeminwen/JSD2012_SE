package com.webserver.core;

import com.webserver.servlet.HttpServlet;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerContext {
    private static Map<String,HttpServlet>servletMapping=new HashMap<>();

    static {
        initServletMapping();
    }

    private static void initServletMapping(){
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read("config/servlet.xml");
            Element root = doc.getRootElement();
            List<Element> list = root.elements("servlet");
            System.out.println("一共有" + list.size() + "个<servlet>标签");
            for (Element servletEle : list) {
                String path = servletEle.attributeValue("path");
                String className = servletEle.attributeValue("className");
                System.out.println(path + "," + className);
                Class cls = Class.forName(className);
                HttpServlet servlet = (HttpServlet) cls.newInstance();
                servletMapping.put(path, servlet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HttpServlet getServlet(String path){
        return servletMapping.get(path);
    }
}
