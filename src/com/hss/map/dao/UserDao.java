package com.hss.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hss.map.model.UserModel;
import com.hss.map.util.Util;

public class UserDao {
	
	Util util=new Util();
	Connection con=null;
	/**
	 * ע���û�
	 * ����1��ʾע��ɹ�
	 * ����0��ʾע��ʧ��
	 */
	public int addUser(UserModel user){
		int judge=0;
		con=util.getConnection();
		String sql="insert into attuser (name,password,adm) values (?,?,?)";
		try {
			PreparedStatement ptmt=con.prepareStatement(sql);
			
			ptmt.setString(1, user.getName());
			ptmt.setString(2, user.getPassword());
			ptmt.setInt(3, user.getAdm());
			ptmt.executeUpdate();
			judge=1;
			System.out.println("��ӳɹ�");
		} catch (SQLException e) {
			judge=0;
			System.out.println("���ʧ��");
			e.printStackTrace();
		}
		return judge;
	}
	/**
	 * �û���¼
	 * ���ص�ֵΪ��¼�Ƿ�ɹ����û��Ƿ�Ϊ����Ա
	 * */
	public int[] Login(String name,String password)
	{
		int[] num={0,0};
		String p=null;
		con=util.getConnection();
		String sql="select id,password,adm from attuser where name=?";
		try {
			PreparedStatement ptmt=con.prepareStatement(sql);
			ptmt.setString(1,name);
			ResultSet res=ptmt.executeQuery();
			while(res.next())
			{
				p=res.getString("password");
				num[1]=res.getInt("adm");
			}
			if(p==null)
			{
				System.out.println(p);
				num[0]=2;//��ʾ�û���������
			}
			if(password.equals(p))
			{
				num[0]=1;//��ʾ��¼�ɹ�
			}
			if(p!=null&&!password.equals(p))
			{
				num[0]=-1;//��ʾ���벻��ȷ
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	/**
	 * �鿴�û����Ƿ��ظ�
	 * �������ֵΪ1��ʾû���ظ�
	 * �������ֵΪ0��ʾ�ظ���
	 * */
	public int judges(String name)
	{
		int judge=0;
		int i=0;
		con=util.getConnection();
		String sql="select * from attuser where name=?";
		try {
			PreparedStatement ptmt=con.prepareStatement(sql);
			ptmt.setString(1, name);
			ResultSet res=ptmt.executeQuery();
			while(res.next())
			{
				i++;
			}
			if(i==0)
				judge=1;
			else judge=0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge;
	}
	
}
