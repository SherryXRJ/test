package edu.sherry.gof.factory;

/**
 * 1.简单工厂(静态工厂)设计模式   <p>
 *
 * 包含三个角色   <p>
 * 1.LoggerFactory(工厂角色)  <p>
 * 2.Product(抽象产品角色)    <p>
 * 3.ConcreteProduct(具体产品角色)
 */
public class SimpleFactoryPattern {

    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("Rectangle", 3, 4, 5);
        shape.display();
    }

    /**
     * LoggerFactory(工厂角色)
     */
    public static class ShapeFactory{
        private ShapeFactory() {}

        static Shape getShape(String shapeName, float... args){
            Shape shape;
            switch (shapeName) {
                case "Circle":
                    shape = new Circle(args);break;
                case "Rectangle":
                    shape = new Rectangle(args);break;
                case "Triangle":
                    shape = new Triangle(args);break;
                default:
                    throw new RuntimeException("Ops... Undefined Shape...");
            }
            return shape;
        }
    }
    /**
     * Product(抽象产品角色)
     */
    static abstract class Shape{
        protected abstract void display();
    }

    /**
     * ConcreteProduct(具体产品角色)
     */
    static class Circle extends Shape {

        private float radius;

        Circle(float... args){
            this.radius = args[0];
        }

        protected void display() {
            System.out.println("im Circle, radius = " + radius);
        }
    }

    /**
     * ConcreteProduct(具体产品角色)
     */
    static class Rectangle extends Shape {

        private float width;
        private float length;

        Rectangle(float... args) {
            this.width = args[0];
            this.length = args[1];
        }

        protected void display() {
            System.out.println("im Rectangle, width = " + width + " length = " + length);
        }
    }

    /**
     * ConcreteProduct(具体产品角色)
     */
    static class Triangle extends Shape {

        private float side1;

        private float side2;

        private float side3;

        Triangle(float... args) {
            //  check 3 sides ...

            this.side1 = args[0];
            this.side2 = args[1];
            this.side3 = args[2];
        }

        protected void display() {
            System.out.println("im Triangle, side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3);
        }
    }
}
