package ca.mcmaster.estore.utils;

import java.util.UUID;

public class ActiveCodeUtils {
	public static String getActiveCode() {
		String activeCode = UUID.randomUUID().toString();
		return activeCode;
	}
}
