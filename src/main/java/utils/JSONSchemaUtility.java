package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONSchemaUtility {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static boolean compareJSONSchema(File jsonSchemaPath, String responseBody) {
		JSONObject jsonObj = new JSONObject();

		try {
			JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(jsonSchemaPath)));
			Schema schema = SchemaLoader.load(jsonSchema);
			schema.validate(objectMapper.convertValue(responseBody, JSONObject.class));
			jsonObj.put("errorMessage", "");
			return true;
		} catch (JSONException | FileNotFoundException | ValidationException e) {
			e.printStackTrace();
			jsonObj.put("errorMessage", e.getMessage());
		}
		return false;

	}
}
