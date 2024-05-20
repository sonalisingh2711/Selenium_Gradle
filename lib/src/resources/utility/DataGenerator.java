package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

// This class will store all the methods to generate data
public class DataGenerator {
    public static String generateDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String date = dateFormat.format(new Date());
        System.setProperty("current.date.time", date);
        return date;
    }
}
