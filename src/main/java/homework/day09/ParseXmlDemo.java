package homework.day09;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class ParseXmlDemo {
    public static void main(String[] args) {
        try {
            SAXReader reader=new SAXReader();
            Document doc=reader.read("emplist.xml");
            Element root=doc.getRootElement();
            List<Element>list=root.elements("emp");
            for (Element empEle:list){
                Element nameEle=empEle.element("name");
                String ename=nameEle.getText();
                Element ageEle=empEle.element("age");
                int age=Integer.parseInt(ageEle.getText());
                String gender=empEle.elementText("gender");
                int salary=Integer.parseInt(empEle.elementText("salary"));
                int id=Integer.parseInt(empEle.attributeValue("id"));
                System.out.println(id+","+ename+","+age+","+gender+","+salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}