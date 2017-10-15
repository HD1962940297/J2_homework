package j2_work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.Statement;

public class DespositAccount {

	public static int a;            //选项变量 
	private static String account;  //账户
	private static String accName;  //储户姓名
	private static int balance;     //存款余额
	private static int apr;         //年利率
	
	
	//开户
	public static void kaihu() {
		
		int a;  //记录查询的变量
		String account=null,name = null,balance=null;
		double apr=0;
		conn();
		System.out.println("开户");
		
		System.out.println("请输入开户信息：");
		Scanner scanner = new Scanner(System.in);
			account = scanner.next();
			name = scanner.next();
			balance = scanner.next();
			apr = Double.parseDouble(scanner.next());
			
		try {
			
			Connection connect =  DriverManager.getConnection(
			          "jdbc:mysql://127.0.0.1:3306/模拟银行定期存款","root","123123");
			Statement statement = connect.createStatement();
			String sql = "INSERT INTO USER VALUES('"+account+"','"+name+"','"+balance+"','"+apr+"')";           
			a = statement.executeUpdate(sql);
			if(a==1) {
				System.out.println("开户成功");
			}else {
				System.out.println("开户失败");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//存款
	public static void cunkuan() {
		
		int a;
		String b;
		String balance;
		System.out.println("存款");
		conn();
		System.out.println("请输入账户和存款金额：");
		Scanner scanner = new Scanner(System.in);
		b = scanner.next();
		balance = scanner.next();
			
		try {
			
			Connection connect =  DriverManager.getConnection(
			          "jdbc:mysql://127.0.0.1:3306/模拟银行定期存款","root","123123");
			Statement statement = connect.createStatement();
			String sql = "UPDATE USER SET balance='"+balance+"' WHERE account ='"+b+"'";           
			a = statement.executeUpdate(sql);
			if(a==1) {
				System.out.println("存款成功");
			}else {
				System.out.println("存款失败");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//查询
	public static void search() {
		
		ResultSet a;
		String b;
		System.out.println("查询");
		conn();
		System.out.println("请输入账户：");
		Scanner scanner = new Scanner(System.in);
		b = scanner.next();
			
		try {
			
			Connection connect =  DriverManager.getConnection(
			          "jdbc:mysql://127.0.0.1:3306/模拟银行定期存款","root","123123");
			Statement statement = connect.createStatement();
			String sql = "SELECT * FROM USER WHERE account='"+b+"'";           
			a = statement.executeQuery(sql);
			if(a.next()) {
				
				System.out.println(a.getString(1)+" "+a.getString(2)+
						"  "+a.getString(3)+" "+a.getString(4));
			}else {
				
				System.out.println("查询失败");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//计算利息
	public static void countLixi() {
		
		System.out.println("计算利息");
		ResultSet a;
		String b;
		double c;
		conn();
		System.out.println("请输入账户：");
		Scanner scanner = new Scanner(System.in);
		b = scanner.next();
			
		try {
			
			Connection connect =  DriverManager.getConnection(
			          "jdbc:mysql://127.0.0.1:3306/模拟银行定期存款","root","123123");
			Statement statement = connect.createStatement();
			String sql = "SELECT * FROM USER WHERE account='"+b+"'";           
			a = statement.executeQuery(sql);
			if(a.next()) {
				
				System.out.println(a.getString(1)+" "+a.getString(2)+
						"  "+a.getString(3)+" "+a.getString(4));
				c=Integer.parseInt(a.getString(3))*Double.parseDouble(a.getString(4));
				System.out.println("您的利息为："+c);
			}else {
				
				System.out.println("计算失败");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//连接Mysql函数
	public static void conn() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载JDBC成功！");
		}catch (Exception e) {
			
			System.out.println("加载JDBC失败！");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
		System.out.println("*********欢迎使用模拟银行定期存款系统********");
		System.out.println("**                                  **");
		System.out.println("**  1，开户                                                                      **");
		System.out.println("**                                  **");
		System.out.println("**  2，存款                                                                      **");
		System.out.println("**                                  **");
		System.out.println("**  3，查询                                                                     **");
		System.out.println("**                                  **");
		System.out.println("**  4，计算利息                                                              **");
		System.out.println("**                                  **");
		System.out.println("**                                  **");
		System.out.println("**************************************");
		
		System.out.println("请选择你要办理的业务：");
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()) {
			
			a = scanner.nextInt();   //键盘录入办理业务序号
			switch(a) {
			case 1: 
				kaihu();break;
			case 2:
				cunkuan();break;
			case 3:
				search();break;
			case 4:
				countLixi();break;
			default:
				System.out.println("输入有误,请重输！");break;
			}
		}
	}
}
 