package pers.sherry.gof.factory;

import pers.sherry.gof.util.Dom4jUtil;
import org.dom4j.DocumentException;

/**
 * 2.工厂类设计模式(LoggerFactory Pattern)
 * <p>
 * 1.抽象工厂(LoggerFactory)  <p>
 * 2.具体工厂(ConcreteFactory)  <p>
 * 3.抽象对象(Product)  <p>
 * 4.具体对象(ConcreteFactory)  <p>
 *
 * 注:可通过反射机制
 */
public class FactoryPattern {

    public static void old(String[] args) {
        Logger logger;
        LoggerFactory loggerFactory = new DatabaseLoggerLoggerFactory();

        logger = loggerFactory.create();
        logger.debug("debug info");
    }

    /**
     * 使用配置文件动态加载
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, DocumentException, IllegalAccessException {
        Logger logger;
        LoggerFactory loggerFactory = (LoggerFactory) Dom4jUtil.getBean("loggerFactory");

        logger = loggerFactory.create();
        logger.error("error");
    }

    /**
     * 抽象工厂(Factory)
     */
    interface LoggerFactory {
        Logger create();
    }

    /**
     * 具体工厂(ConcreteFactory)
     */
    public static class DatabaseLoggerLoggerFactory implements LoggerFactory {

        @Override
        public Logger create() {
            return new DatabaseLogger();
        }
    }

    /**
     * 具体工厂(ConcreteFactory)
     */
    public static class FileLoggerLoggerFactory implements LoggerFactory {

        @Override
        public Logger create() {
            return new FileLogger();
        }
    }



    /**
     * 抽象对象(Product)
     */
    interface Logger {

        void error(String e);

        void debug(String d);

        // info warn ...
    }


    /**
     * 具体对象(ConcreteFactory)
     */
    static class DatabaseLogger implements Logger {
        @Override
        public void error(String e) {
            System.out.println("DatabaseLogger" + e);
        }

        @Override
        public void debug(String d) {
            System.out.println("DatabaseLogger" + d);
        }
    }

    /**
     * 具体对象(ConcreteFactory)
     */
    static class FileLogger implements Logger {
        @Override
        public void error(String e) {
            System.out.println("FileLogger" + e);
        }

        @Override
        public void debug(String d) {
            System.out.println("FileLogger" + d);
        }
    }


}
