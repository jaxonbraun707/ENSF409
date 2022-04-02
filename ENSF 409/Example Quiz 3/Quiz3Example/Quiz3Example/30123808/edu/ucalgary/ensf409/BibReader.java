package edu.ucalgary.ensf409;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BibReader {
    private File file;
    private String data;
    private String title;
    private String author;
    private String year;
    
    public BibReader(File file) {
        this.file = file;
        this.data = "";
    }

    public boolean readFile() {
        boolean result = true;

        try {
            Scanner reader = new Scanner(new FileReader(file));
            while (reader.hasNextLine()) {
                data += reader.nextLine() + '\n';
            }
            reader.close();
        } catch (IOException e) {
            result = false;
        }
        data.replace("null", "");
        return result;
    }

    public String getContents() {
        return this.data;
    }

    public void setContents(String data) {
        this.data = data;
    }

    public boolean parseContents() {
        String[] dataArray = data.split("\n");
        title = dataArray[1].substring(dataArray[1].indexOf('{')+1, dataArray[1].indexOf('}'));
        author = dataArray[2].substring(dataArray[2].indexOf('{')+1, dataArray[2].indexOf('}'));
        year = dataArray[4].substring(dataArray[4].indexOf('{')+1, dataArray[4].indexOf('}'));
        return true;
    }

    public String getAttribute(String attribute) {
        String output = "";
        attribute.toLowerCase();
        if (attribute.compareTo("title")==0) {
            output = title;
        }
        if (attribute.compareTo("author")==0) {
            output = author;
        }
        if (attribute.compareTo("year")==0) {
            output = year;
        }
        return output;
    }

    
}
