package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        getter_setter getterSetter=new getter_setter();
        System.out.println(getterSetter.getOne());
        System.out.println(getterSetter.getTwo());
        getterSetter.setOne("666");
        getterSetter.setTwo("888");
        System.out.println(getterSetter.getOne());
        System.out.println(getterSetter.getTwo());
        getterSetter.setOne("89890");
        getterSetter.setTwo("90909");
        System.out.println(getterSetter.getOne());
        System.out.println(getterSetter.getTwo());
    }
}