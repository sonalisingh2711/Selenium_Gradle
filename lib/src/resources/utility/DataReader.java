package utility;

import java.io.*;
import java.util.*;

public class DataReader {
    public Properties properties;

    public DataReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new FileReader(System.getProperty("user.dir") + "\\src\\resources\\config\\data.properties"));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getValue(String Value) {
        String value = properties.getProperty(Value);
        return value;
    }

}
