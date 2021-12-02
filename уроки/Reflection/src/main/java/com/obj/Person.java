package com;

@Good
public class Person {
    String name;
    int age;
    String adres;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, String addres) {
        this.name = name;
        this.age = age;
        this.adres = addres;
    }

    public void jump() {
        System.out.println("Меня зовут " + name + " и я прыгаю");
    }

    @Good
    private void sing() {
        System.out.println("Меня зовут " + name + " и я лблю петь ");
    }
}
