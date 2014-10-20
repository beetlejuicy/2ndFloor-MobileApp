package com.secondfloor.ofertame.util;

public class StringUtil 
{
	public static boolean isNullOrEmpty(String a) {
		return a == null || a.isEmpty();
	} 

	public static boolean isNullOrWhiteSpace(String a) {
		return a == null || (a.length() > 0 && a.trim().length() <= 0);
	}
}
