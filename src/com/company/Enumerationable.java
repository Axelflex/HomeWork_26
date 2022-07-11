package com.company;

public interface Enumerationable {
    void openConnection();
    void closeConnection();
    void checkDataBaseConnection();
    void readLineIndex(Keys[] keys);
    void checkKeyIndex(Keys[] keys, Keys key);
    void readKey(Keys[] keys, Keys key);
    String[] readKeyCollection(Keys[] keys);
    void getNumberOfRecords(Keys[] keys);
    void addRecordToBase(Keys[] keys);
    void renewValueIndex(Keys[] keys);
    void renewKeyValue(Keys[] keys);
}
