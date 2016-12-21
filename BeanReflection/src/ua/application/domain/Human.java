package ua.application.domain;

public class Human {

    private int height;

    private String gender;//cast to enum?

    private int age;

    private int weight;

    public Human(int height, String gender, int age, int weight) {
        this.height = height;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }
}
