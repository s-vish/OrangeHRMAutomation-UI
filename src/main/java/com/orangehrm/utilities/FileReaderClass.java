package com.orangehrm.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class FileReaderClass {


    public static String propertiesReader(String key){

        File file = new File(System.getProperty("user.dir")+"/projectConfig/config.properties");
        FileReader reader=null;
        try {
          reader = new FileReader(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        Properties properties =     new Properties();
        try {
            properties.load(reader);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
