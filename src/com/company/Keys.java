package com.company;

public class Keys {
    private String key;
    private String value;

    public String getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }
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
    @Override
    public String toString() {
        return "Keys {" +
                "key = '" + key + '\'' +
                ", value = '" + value + '\'' +
                '}';
    }
}
