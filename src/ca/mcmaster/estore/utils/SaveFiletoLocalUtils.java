package ca.mcmaster.estore.utils;

import java.util.ResourceBundle;
import java.util.UUID;

public class SaveFiletoLocalUtils {

	public static String getSavePath(String name) {
		int hash = name.hashCode();
		int level1 = hash & 0xf;
		int level2 = hash & 0xf0;
		return "/" + level1 + "/" + level2;
	}

	public static String getRandomName(String fileName) {
		String uuid = UUID.randomUUID().toString();
		String randomName = uuid + fileName;
		return randomName;
	}

}
