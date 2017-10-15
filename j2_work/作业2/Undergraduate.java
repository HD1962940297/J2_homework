package 作业2;

public class Undergraduate extends Student{

	private static String specialty; //专业

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
