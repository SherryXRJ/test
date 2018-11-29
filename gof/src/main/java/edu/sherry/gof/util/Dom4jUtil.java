package edu.sherry.gof.util;

import edu.sherry.gof.FactoryPattern;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

public class Dom4jUtil {

    private Dom4jUtil(){}

    public static Object getBean(String path) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(Dom4jUtil.class.getResource(path));
        Element config = document.getRootElement();
        Iterator iterator = config.elementIterator();
        if (iterator.hasNext()) {
            Element bean = (Element) iterator.next();
            String className = bean.attribute("class").getValue();
            Class<?> clazz = Class.forName(className);
            return clazz.newInstance();
        }
        return null;
    }
}
