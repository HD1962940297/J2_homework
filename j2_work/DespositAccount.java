package j2_work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.Statement;

public class DespositAccount {

	public static int a;            //ѡ����� 
	private static String account;  //�˻�
	private static String accName;  //��������
	private static int balance;     //������
	private static int apr;         //������
	
	
	//����
	public static void kaihu() {
		
		int a;  //��¼��ѯ�ı���
		String account=null,name = null,balance=null;
		double apr=0;
		conn();
		System.out.println("����");
		
		System.out.println("�����뿪����Ϣ��");
		Scanner scanner = new Scanner(System.in);
			account = scanner.next();
			name = scanner.next();
			balance = scanner.next();
			apr = Double.parseDouble(scanner.next());
			
		try {
			
			Connection connect =  DriverManager.getConnection(
			          "jdbc:mysql://127.0.0.1:3306/ģ�����ж��ڴ��","root","123123");
			Statement statement = connect.createStatement();
			String sql = "INSERT INTO USER VALUES('"+account+"','"+name+"','"+balance+"','"+apr+"')";           
			a = statement.executeUpdate(sql);
			if(a==1) {
				System.out.println("�����ɹ�");
			}else {
				System.out.println("����ʧ��");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//���
	public static void cunkuan() {
		
		int a;
		String b;
		String balance;
		System.out.println("���");
		conn();
		System.out.println("�������˻��ʹ���");
		Scanner scanner = new Scanner(System.in);
		b = scanner.next();
		balance = scanner.next();
			
		try {
			
			Connection connect =  DriverManager.getConnection(
			          "jdbc:mysql://127.0.0.1:3306/ģ�����ж��ڴ��","root","123123");
			Statement statement = connect.createStatement();
			String sql = "UPDATE USER SET balance='"+balance+"' WHERE account ='"+b+"'";           
			a = statement.executeUpdate(sql);
			if(a==1) {
				System.out.println("���ɹ�");
			}else {
				System.out.println("���ʧ��");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//��ѯ
	public static void search() {
		
		ResultSet a;
		String b;
		System.out.println("��ѯ");
		conn();
		System.out.println("�������˻���");
		Scanner scanner = new Scanner(System.in);
		b = scanner.next();
			
		try {
			
			Connection connect =  DriverManager.getConnection(
			          "jdbc:mysql://127.0.0.1:3306/ģ�����ж��ڴ��","root","123123");
			Statement statement = connect.createStatement();
			String sql = "SELECT * FROM USER WHERE account='"+b+"'";           
			a = statement.executeQuery(sql);
			if(a.next()) {
				
				System.out.println(a.getString(1)+" "+a.getString(2)+
						"  "+a.getString(3)+" "+a.getString(4));
			}else {
				
				System.out.println("��ѯʧ��");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//������Ϣ
	public static void countLixi() {
		
		System.out.println("������Ϣ");
		ResultSet a;
		String b;
		double c;
		conn();
		System.out.println("�������˻���");
		Scanner scanner = new Scanner(System.in);
		b = scanner.next();
			
		try {
			
			Connection connect =  DriverManager.getConnection(
			          "jdbc:mysql://127.0.0.1:3306/ģ�����ж��ڴ��","root","123123");
			Statement statement = connect.createStatement();
			String sql = "SELECT * FROM USER WHERE account='"+b+"'";           
			a = statement.executeQuery(sql);
			if(a.next()) {
				
				System.out.println(a.getString(1)+" "+a.getString(2)+
						"  "+a.getString(3)+" "+a.getString(4));
				c=Integer.parseInt(a.getString(3))*Double.parseDouble(a.getString(4));
				System.out.println("������ϢΪ��"+c);
			}else {
				
				System.out.println("����ʧ��");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//����Mysql����
	public static void conn() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("����JDBC�ɹ���");
		}catch (Exception e) {
			
			System.out.println("����JDBCʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
		System.out.println("*********��ӭʹ��ģ�����ж��ڴ��ϵͳ********");
		System.out.println("**                                  **");
		System.out.println("**  1������                                                                      **");
		System.out.println("**                                  **");
		System.out.println("**  2�����                                                                      **");
		System.out.println("**                                  **");
		System.out.println("**  3����ѯ                                                                     **");
		System.out.println("**                                  **");
		System.out.println("**  4��������Ϣ                                                              **");
		System.out.println("**                                  **");
		System.out.println("**                                  **");
		System.out.println("**************************************");
		
		System.out.println("��ѡ����Ҫ�����ҵ��");
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()) {
			
			a = scanner.nextInt();   //����¼�����ҵ�����
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
				System.out.println("��������,�����䣡");break;
			}
		}
	}
}
 