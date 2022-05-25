package io.github.oliviercailloux.teaching_examples;

public class PhoneNumber {
	private int countryCode;
	private int prefix;
	private String number;

	public PhoneNumber(int countryCode, int prefix, String number) {
		this.countryCode = countryCode;
		this.prefix = prefix;
		this.number = number;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public int getPrefix() {
		return prefix;
	}

	public String getNumber() {
		return number;
	}
}
