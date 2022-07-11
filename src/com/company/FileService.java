package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Path path = Paths.get("./Keys.json");

    public static Keys[] readFile(){
        String json;
        try {
            json = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gson.fromJson(json, Keys[].class);
    }

    public static void writeFile(Keys[] tracks){
        String json = gson.toJson(tracks);
        byte[] arr = json.getBytes();
        try {
            Files.write(path, arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
