package 作业2;


public class Student {

	private static String name;  //学生姓名
	private static int age;      //年龄
	private static String education; //学历
	
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
			
			System.out.println("输入错误！");
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
