package com.company;

public class Keys {
    String key;
    String value;

    public void printKey(){
        System.out.println(key);
    }
    public void writeDownKey(String key){
        this.key = key;
    }
    public void printValue(){
        System.out.println(value);
    }
    public void writeDownValue(String value){
        this.value = value;
    }
}
