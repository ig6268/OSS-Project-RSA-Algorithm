package rsa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main extends JFrame{
	JLabel state;
	JTextArea txt_area;
	static int m;//�� m
	static String c;// ��ȣ��
	static String e;// ����Ű
	static String d;// ����Ű
	static String n;// n = p*q
	static String pi;// ���Ϸ� �����Լ� (p-1)*(q-1)
	static int p;// ������ �Ҽ�p
	static int q;// ������ �Ҽ�q
	
	public main() { // gui�κ�
		setTitle("RSAŰ����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel Btn_panel = new JPanel();
		Btn_panel.setLayout(new FlowLayout());
		JButton btn1 = new JButton ("��ȣȭ");
		JButton btn2 = new JButton ("��ȣȭ");
		JButton btn3 = new JButton ("Ű����");
		JTextField tf1 = new JTextField(10);
		
		Btn_panel.add(btn1);
		Btn_panel.add(btn2);
		Btn_panel.add(new JLabel("�򹮰�(2~50������ ������)"));
		Btn_panel.add(tf1);
		Btn_panel.add(btn3);
		
		btn1.addActionListener(new ActionListener() { // ��ȣȭ ��ư
			//@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn2.addActionListener(new ActionListener() { //��ȣȭ ��ư
			//@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btn3.addActionListener(new ActionListener() { //Ű ���� ��ư
			//@Override
			public void actionPerformed(ActionEvent e) {
				
					m = new Integer(tf1.getText());
					txt_area.setText("�򹮰� : "+ m+"\n");

					if(m<2 || m>50)
					{
						txt_area.setText("��2~50������ �������� �ƴմϴ�.\n");
					}
					
				
				//Ű���� �Լ�
				create();
			}
		});

		// ���α׷� Ʋ
		state = new JLabel(); 
		state.setText("RSA Ű��� ��,��ȣȭ");
		txt_area = new JTextArea();
		add(txt_area, BorderLayout.CENTER);
		add(Btn_panel, BorderLayout.SOUTH);
		setSize(600, 600);
		setVisible(true);
	}
	
	public void create() { // Ű ���� �Լ�

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}

}
