package edu.sherry.gof;

import java.util.Arrays;
import java.util.List;

/**
 * 3.创造者设计模式
 */
public class BuilderPattern {


    public static void main(String[] args) {
        HumanBuilder manBuilder = new HumanBuilder();
        Human human = manBuilder.setName("Tom")
                .setAge(12)
                .setHigh(1.80f)
                .setHobby(Arrays.asList("Sing", "Dance", "Drink"))
                .build();

        System.out.println(human);
    }

    interface IHumanBuilder {
        IHumanBuilder setName(String name);

        IHumanBuilder setAge(int age);

        IHumanBuilder setHigh(float high);

        IHumanBuilder setHobby(List<String> hobbies);

        Human build();
    }

    static class Human {

        private String name;

        private int age;

        private float high;

        private List<String> hobbies;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHigh(float high) {
            this.high = high;
        }

        public void setHobbies(List<String> hobbies) {
            this.hobbies = hobbies;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", high=" + high +
                    ", hobbies=" + hobbies +
                    '}';
        }
    }

    static class HumanBuilder implements IHumanBuilder {

        private Human human;

        public HumanBuilder() {
            human = new Human();
        }

        @Override
        public IHumanBuilder setName(String name) {
            human.setName(name);
            return this;
        }

        @Override
        public IHumanBuilder setAge(int age) {
            human.setAge(age);
            return this;
        }

        @Override
        public IHumanBuilder setHigh(float high) {
            human.setHigh(high);
            return this;
        }

        @Override
        public IHumanBuilder setHobby(List<String> hobbies) {
            human.setHobbies(hobbies);
            return this;
        }

        @Override
        public Human build() {
            return human;
        }
    }

}
