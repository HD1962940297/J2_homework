package ��ҵ2;


public class Student {

	private static String name;  //ѧ������
	private static int age;      //����
	private static String education; //ѧ��
	
	public static String getName() {
		
		return name;
	}

	public static void setName(String name) {
		
		Student.name = name;
	}

	public static int getAge() {
		return age;
	}

	public static void setAge(int age) {
		
		if (age<0||age>130) {
			
			System.out.println("�������");
		}else {
			
			Student.age = age;
		}
	}

	public static String getEducation() {
		return education;
	}

	public static void setEducation(String education) {
		Student.education = education;
	}

	public static void show() {
		
		System.out.println();
	}
	
	public static void main(String[] args) {

		
	}

}
