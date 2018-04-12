package com.hss.map.dao;
/**
 * ��ѯ��������·��
 * @author hu
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hss.map.util.Util;

public class AttractionPath {
	
	Util util=new Util();
	Connection con=null;
	AttractionDao dao=new AttractionDao();
	int allnum=0;
	private static final int MAX=1000000;
	public List<List<Integer>> screatArray()
	{
		List<List<Integer>> list=new ArrayList<>();
		List<Integer> list1=null;
		con=util.getConnection();
		allnum=dao.returnnum();
		String str="path";
		try{
			for(int i=1;i<=allnum;i++)
			{
				list1=new ArrayList<>();
				for(int j=1;j<=allnum;j++)
				{
					String sql="select path"+j+" from attractions where id="+i;
					PreparedStatement ptmt=con.prepareStatement(sql);
					ResultSet re=ptmt.executeQuery();
					while(re.next())
					{
						int num=re.getInt("path"+j);
						list1.add(num);
					}
				}
				list.add(list1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		/*for(List<Integer> li:list)
		{
			for(Integer l:li)
			{
				System.out.print(l+"\t");
			}
			System.out.println();
		}*/
		return list;
		
	}
	public String shortPath(List<List<Integer>> table1,int startnum,int endnum)
	{
		//ʹ���ڽӾ�����д洢·��
		/*List<Integer> D=new ArrayList<>();//�������·������
		List<List<Integer>> p=new ArrayList<>();//·��
		List<Integer> finall=new ArrayList<>();//��finall==1˵������v1�Ѿ��ڼ���S��
		*/
		int n=dao.returnnum();//����ĸ���
		int[][] table=new int[n][n];
		int path[]=new int[n];//����������·����
		int[] D=new int[n];//�������·������
		int[][] p=new int[n][n];//·��
		int[] finall=new int[n];//��final=1��˵������vi���ڼ���s��
		int v0=startnum;
		int v,w;
		int listi=0;
		System.out.println(n);
		for(List<Integer> li:table1)
		{
			int listj=0;
			for(Integer l:li)
			{
				table[listi][listj]=l;
				listj++;
				
			}
			listi++;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(table[i][j]+",");
			}
			System.out.println();
		}
		for(v=0;v<n;v++)//ѭ�� ��ʼ��
	    {
	          finall[v] = 0;
	          D[v] = table[v0][v];
	          for (w = 0; w < n; w++)
	        	  p[v][w] = 0;//���·��
	          if (D[v] < MAX) 
	          {
	        	  p[v][v0] = 1; 
	        }
	    }
	    D[v0] = 0;
	    finall[v0]=0; //��ʼ�� v0�������ڼ���S
	    //��ʼ��ѭ�� ÿ�����v0��ĳ������v�����·�� ����v������S��
	    for (int i = 0; i < n; i++) 
	    {
	          int min = MAX;
	          for (w = 0; w < n; w++)
	          {
	               //���Ĺ���--ѡ��
	               if (finall[w]==0) //���w������V-S��
	               {
	                    //�����������ѡ���ĵ� Ӧ����ѡ����ǰV-S����S�й�����
	                    //��Ȩֵ��С�Ķ��� ��������Ϊ ��ǰ��V0����ĵ�
	            	   	if (D[w] < min)
	                    {
	                    	v = w;
	                    	min = D[w];
	                    }
	               }
	          }
	          finall[v] = 1; //ѡ���õ����뵽�ϼ�S��
	          for (w = 0; w < n; w++)//���µ�ǰ���·���;���
	          {
	               /*�ڴ�ѭ���� vΪ��ǰ��ѡ�뼯��S�еĵ�
	               	���Ե�VΪ�м�� ���� d0v+dvw �Ƿ�С�� D[w] ���С�� �����
	               */
	               if (finall[w]==0&&(min+table[v][w]<D[w]))
	               {
	                    D[w] = min + table[v][w];	                   
	                    for(int l=0;l<n;l++)
	                    {
	                    	p[l][w]=0;
	                    }
	                    p[v][w]=1;
	               } 
	              }
	        }
	    	path[0]=D[endnum];
			int number=endnum;//����λ��
			int k=2;
			path[1]=endnum+1;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(p[i][j]+" ");
				}
				System.out.println();
			}
			for(int i=0;i<n;i++)
			{
				if(p[i][number]==1)
				{
					number=i;
					path[k]=(number+1);
					k++;
				}
				if(number==startnum)//��ʼλ��
				{
					break;	
				}
			}
			path[k]=startnum+1;
			String pathname="���·��Ϊ:";
			for(int i=1;i<path.length;i++)
			{
				if(path[i]!=0)
				{
					if(i==1)
					pathname=pathname+dao.returnname(path[i]);
					else
					pathname=pathname+"һһһһ>"+dao.returnname(path[i]);
				}
				System.out.print(path[i]+" ");
				
			}
			System.out.println();
		return pathname+"\n���·���ĳ���Ϊ:"+path[0]+"��";
	}
	
}
