package edu.sherry.gof.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dom4jUtil {

    private Dom4jUtil(){}

    private static Map<String, Object> beans = new HashMap<>();

    static {
        SAXReader saxReader = new SAXReader();
        Document document;
        try {
            document = saxReader.read(Dom4jUtil.class.getResource("/config/BeanConfig.xml"));
            Element config = document.getRootElement();
            Iterator iterator = config.elementIterator();
            while(iterator.hasNext()) {
                Element bean = (Element) iterator.next();
                String id = bean.attribute("id").getValue();
                String className = bean.attribute("class").getValue();
                Class<?> clazz = Class.forName(className);
                Object instance = clazz.newInstance();

                beans.put(id, instance);
            }
        } catch (DocumentException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Object getBean(String id){
        return beans.get(id);
    }
}
