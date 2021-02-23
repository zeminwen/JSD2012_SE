package homework.day10;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpContext {
    private static Map<String,String>mimeMapping=new HashMap<>();
    static {
        initMimeMapping();
    }
    private static void initMimeMapping(){
        try {
            SAXReader reader=new SAXReader();
            Document doc=reader.read("config/web.xml");
            Element root=doc.getRootElement();
            List<Element>list=root.elements("mime-mapping");
            for (Element element:list){
                String key=element.elementText("extension");
                String value=element.elementText("mime-type");
                mimeMapping.put(key,value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getMimeType(String ext){
        return mimeMapping.get(ext);
    }
}
