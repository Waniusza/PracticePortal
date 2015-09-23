/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.helpers;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author janusz
 */
public class JsonHelper {
    
    Logger log = LoggerFactory.getLogger(JsonHelper.class);
            

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonObecjFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    
        public static JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
        
     public static String readFile(String name) {
        try {
            Path path = Paths.get(name);
            String fileData = new String(Files.readAllBytes(path));
            System.out.println("readFile fileData" + fileData);
            return fileData;
        } catch (FileSystemNotFoundException | NoSuchFileException ex) {
            return ex.getMessage();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
     public static String readFromResource(String name) {
        System.out.println("[readFromResource] -> " + name);
        InputStream is = JsonHelper.class.getClassLoader().getResourceAsStream(name);
        if (is != null) {
            try {
                String jsonData = new String(IOUtils.toByteArray(is));
                System.out.println("[readFromResource] file read");
                return jsonData;
            } catch (IOException ex) {
                System.err.println("[readFromResource] NSome error when searching real file." + ex.getMessage());
                return ex.getMessage();
            }
        } else {
            System.err.println("[readFromResource] input stream jest nullem");
        }
        return("ERROR");
    };
}
