package utility;

import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// This class reads json file and parse it
public class Environment {
	static JsonObject jsonObject = null;

	public static JsonObject readJson() {
		try {
			FileReader fileReader = new FileReader(
					System.getProperty("user.dir") + "\\src\\resources\\config\\environment.json");
			Environment.jsonObject = (JsonObject) JsonParser.parseReader(fileReader);
			return jsonObject;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;

	}

	public static String getValue(String key1, String key2) {
		Environment.readJson();
		JsonObject key = jsonObject.getAsJsonObject(key1);
		String value = key.get(key2).toString();
		String parse_value = value.substring(1, value.length() - 1);
		return parse_value;
	}

}
