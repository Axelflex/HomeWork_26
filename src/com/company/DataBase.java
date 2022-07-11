package com.company;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class DataBase implements Enumerationable{
    private boolean connection = true;

    @Override
    public void openConnection() {
        connection = true;
    }

    @Override
    public void closeConnection() {
        connection = false;
    }

    @Override
    public void checkDataBaseConnection() {
        if(connection){
            System.out.println("Connected");
        }else {
            System.out.println("please connect to DataBase");
        }
    }

    @Override
    public void readLineIndex(Keys[] keys) {
        if(connection){
            int index = (int)(Math.random() * 5);
            System.out.println(keys[index]);
        }else {
            System.out.println("please connect to DataBase");
        }
    }

    @Override
    public void checkKeyIndex(Keys[] keys, Keys key) {
        if(connection){
            try {
                int keyInd = new Scanner(System.in).nextInt()-1;
                if (keyInd < 5 && keyInd > -1){
                    if(key.getValue().isEmpty()){
                        System.out.println("Value of " + keys[keyInd] + " is empty");
                    }else {
                        System.out.println("Value of " + keys[keyInd] + " is not empty");
                    }
                }
            }catch (IllegalArgumentException e){
                System.out.println("pls enter number");
            }
        }else {
            System.out.println("please connect to DataBase");
        }
    }

    @Override
    public void readKey(Keys[] keys, Keys key) {
        if(connection){
            try {
                int keyInd = new Scanner(System.in).nextInt()-1;
                if (keyInd < 5 && keyInd > -1){
                    System.out.println("Value of " + keys[keyInd] + " is " + key.getValue());
                }
            }catch (IllegalArgumentException e){
                System.out.println("pls enter number");
            }
        }else {
            System.out.println("please connect to DataBase");
        }
    }

    @Override
    public String[] readKeyCollection(Keys[] keys) {
        if(connection){
            String[] values = new String[(int)(Math.random() * 6)];
            for (int i = 0; i < values.length; i++) {
                values[i] = keys[i].getValue();
            }
            return values;
        }else {
            System.out.println("please connect to DataBase");
        }
        return new String[0];
    }

    @Override
    public void getNumberOfRecords(Keys[] keys) {
        int count = 0;
        if(connection){
            for (int i = 0; i < keys.length; i++) {
                count++;
            }
            System.out.println(count);
        }else {
            System.out.println("please connect to DataBase");
        }
    }

    @Override
    public void addRecordToBase(Keys[] keys) {
        if(connection){
            Keys[] arr = new Keys[keys.length + 1];
            for (int i = 0; i < arr.length; i++) {
                if(i < arr.length - 1){
                    arr[i] = keys[i];
                }else {
                    Keys keys1 = new Keys();
                    System.out.println("Enter new key");
                    String key = new Scanner(System.in).nextLine();
                    keys1.writeDownKey(key);
                    System.out.println("Enter new value");
                    String value = new Scanner(System.in).nextLine();
                    keys1.writeDownValue(value);
                    arr[i] = keys1;
                }
            }
            System.out.println(Arrays.toString(arr));
        }else {
            System.out.println("please connect to DataBase");
        }
    }

    @Override
    public void renewValueIndex(Keys[] keys) {
        if(connection){
            System.out.println("Enter key number");
            try {
                int key = new Scanner(System.in).nextInt() - 1;
                if (key < 5 && key > -1){
                    System.out.println("Enter new value of " + keys[key].getKey() + " key");
                    String value = new Scanner(System.in).nextLine();
                    keys[key].writeDownValue(value);
                }else{
                    System.out.println("Enter a number pls");
                }
            }catch (IllegalArgumentException e){
                System.out.println("pls enter number");
            }
        }else {
            System.out.println("please connect to DataBase");
        }
    }

    @Override
    public void renewKeyValue(Keys[] keys) {
        if(connection){
            String keyName = new Scanner(System.in).nextLine();
            for (Keys key : keys) {
                if (Objects.equals(key.getKey(), keyName)) {
                    System.out.println("Value of key " + keyName + " equals " + key.getValue());
                } else {
                    System.out.println("No such key in base");
                }
            }
        }else {
            System.out.println("please connect to DataBase");
        }
    }
}
