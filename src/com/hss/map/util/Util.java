package com.hss.map.util;
import java.sql.*;

/**
 * 
 * @author hu
 * �������ݿ�
 * ������
 *
 */
public class Util {
		private static final String Url="jdbc:mysql://localhost:3306/map?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		private static final String User="root";
		private static final String Password="533533";
		public Connection getConnection()
		{
			Connection con=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("�ɹ��������ݿ�����");
				con=DriverManager.getConnection(Url,User,Password);
			}catch(ClassNotFoundException e)
			{
				System.out.println("���ݿ����ʧ��");
				e.printStackTrace();
			} catch (SQLException e) {
				
				System.out.println("���ݿ����ʧ��");
				e.printStackTrace();
			}
			return con;
		}
		
}
