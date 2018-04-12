package com.hss.map.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainView extends JFrame{
	
	AttractionView view=new AttractionView(); 
	public void mainUi(String name,int adm)
	{
		JFrame jframe=new JFrame("�����ʵ��ѧ����,��ӭ��"+name);
		JMenuBar jmenu=new JMenuBar();
		JMenu buttonSearch=new JMenu("		·�߲�ѯ	");
		JMenu buttonAttractions=new JMenu("	�������	");
		JMenu buttonToplogy=new JMenu("	��������ͼ	");
		JMenu buttonexit=new JMenu("�˳�");
		JMenuItem jmenuitem1=new JMenuItem("��ѯ·��");
		JMenuItem jmenuitem2=new JMenuItem("�������");
		JMenuItem jmenuitem3=new JMenuItem("��Ӿ���");
		JMenuItem jmenuitem4=new JMenuItem("ɾ������");
		JMenuItem jmenuitem5=new JMenuItem("�޸ľ�����Ϣ");
		JMenuItem jmenuitem6=new JMenuItem("��������ͼ");
		JMenuItem jmenuitem7=new JMenuItem("�˳�");
		buttonSearch.add(jmenuitem1);
		buttonAttractions.add(jmenuitem2);
		buttonAttractions.add(jmenuitem3);
		buttonAttractions.add(jmenuitem4);
		buttonAttractions.add(jmenuitem5);
		buttonToplogy.add(jmenuitem6);
		buttonexit.add(jmenuitem7);
		JPanel jpanel=new JPanel()
		{
				public void paintComponent(Graphics g)
				{
					ImageIcon icon =new ImageIcon("src/image/009.jpg");
					Image img=icon.getImage();
					g.drawImage(img, 0, 0, icon.getIconWidth(),icon.getIconHeight(),icon.getImageObserver());
					jframe.setSize(icon.getIconWidth(), icon.getIconHeight()+150);
				}
		};
		jframe.add(jpanel);
		jframe.setJMenuBar(jmenu);
		jmenu.add(buttonSearch);
		jmenu.add(buttonAttractions);
		jmenu.add(buttonToplogy);
		jmenu.add(buttonexit);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		jframe.setBounds(300, 00, 1000, 1000);
		
		/**��ѯ·��*/
		jmenuitem1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				view.pathAttUi();
			}
		});
		/**�������*/
		jmenuitem2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				view.ergodicAttUi();
			}
		});
		/**��Ӿ���*/
		jmenuitem3.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				if(adm==1)
				view.addAttUi();
				else
				JOptionPane.showMessageDialog(null,"�Բ�����û��Ȩ��");
			}
		});
		/**ɾ������*/
		jmenuitem4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(adm==1)
				view.delAttUi();
				else
					JOptionPane.showMessageDialog(null,"�Բ�����û��Ȩ��");
			}
		});
		/**�޸ľ�����Ϣ*/
		jmenuitem5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(adm==1)
				view.modifyAttUi();
				else
					JOptionPane.showMessageDialog(null,"�Բ�����û��Ȩ��");
					
			}
		});
		/**��������ͼ*/
		jmenuitem6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//�˳�ϵͳ
		jmenuitem7 .addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("�˳�ϵͳ");
				System.exit(0);
			}
		});
		
	}
	
	
}
