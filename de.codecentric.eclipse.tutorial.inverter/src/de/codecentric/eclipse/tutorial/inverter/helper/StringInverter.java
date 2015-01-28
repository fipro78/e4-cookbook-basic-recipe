package de.codecentric.eclipse.tutorial.inverter.helper;

public class StringInverter {

	private StringInverter() {}
	
	public static String invert(String value) {
		return new StringBuilder(value).reverse().toString();
	}
}