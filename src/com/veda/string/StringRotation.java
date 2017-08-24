/**
 * Checks if one string is a rotation of another.
 * @author Sesha Shayan Nandyal
 */

package com.veda.string;

public class StringRotation {
	public static void main(String[] args) {
		System.out.printf("%s is a rotation of %s is: %b \n", "waterbottle", "erbottlewat", 
				isOneStringRotatoinOfAnother("waterbottle", "erbottlewat"));
	}
	
	static boolean isOneStringRotatoinOfAnother(String string1, String string2) {
		if(string1 == null || string2 == null || string1.length() != string2.length()) {
			System.out.println("The strings are either null or empty or are not of the same length");
			return false;
		}
		
		String string1Appended = string1 + string1;
		
		int rotationPoint = string1Appended.indexOf(string2);

		if(rotationPoint == -1) {
			return false;
		}

		String preString1 = string1.substring(0, rotationPoint);
		String postString1 = string1.substring(rotationPoint);
		
		return string2.equals(postString1 + preString1);
	}
}
