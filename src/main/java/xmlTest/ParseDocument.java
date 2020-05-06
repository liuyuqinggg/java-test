package xmlTest;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Document解析XML
 * @author ouyangjun
 */
public class ParseDocument {
 
    public static void main(String[] args){
        File file = new File("E:\\person.xml");
        if (!file.exists()) {
            System.out.println("xml文件不存在,请确认!");
        } else {
            parseDocument(file);
        }
    }
	
    public static void parseDocument(File file) {
        try{
            // 初始化一个XML解析工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
            // 创建一个DocumentBuilder实例
            DocumentBuilder builder = factory.newDocumentBuilder();
			
            // 创建一个解析XML的Document实例
            Document doc = builder.parse(file);
			
            // 获取根节点名称
            String rootName = doc.getDocumentElement().getTagName();
            System.out.println("根节点: " + rootName);
			
            System.out.println("递归解析--------------begin------------------");
            // 递归解析Element
            Element element = doc.getDocumentElement();
            parseElement(element);
            System.out.println("递归解析--------------end------------------");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    // 递归方法
    public static void parseElement(Element element) {
        System.out.print("<" + element.getTagName());
        NamedNodeMap attris = element.getAttributes();
        for (int i = 0; i < attris.getLength(); i++) {
            Attr attr = (Attr) attris.item(i);
            System.out.print(" " + attr.getName() + "=\"" + attr.getValue() + "\"");
        }
        System.out.println(">");
		
        NodeList nodeList = element.getChildNodes();
        Node childNode;
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            childNode = nodeList.item(temp);
			
            // 判断是否属于节点
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                // 判断是否还有子节点
                if(childNode.hasChildNodes()){
                    parseElement((Element) childNode);
                } else if (childNode.getNodeType() != Node.COMMENT_NODE) {
                    System.out.print(childNode.getTextContent());
                }
            }
        }
        System.out.println("</" + element.getTagName() + ">");
    }
}