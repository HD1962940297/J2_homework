package ��ҵ2;

public class Undergraduate extends Student{

	private static String specialty; //רҵ

	public static String getSpecialty() {
		return specialty;
	}
	
	public static void show () {
		
		System.out.println();
	}

	public static void setSpecialty(String specialty) {
		Undergraduate.specialty = specialty;
	}
	
}
