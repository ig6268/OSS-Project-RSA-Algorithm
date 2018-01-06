package rsa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*; // BigInteger사용을 위해 
import java.util.Random;




public class main extends JFrame{
	JLabel state;
	JTextArea txt_area;
	static int m;//평문 m
	static String c;// 암호문
	static String e;// 공개키
	static String d;// 개인키
	static String n;// n = p*q
	static String pi;// 오일러 파이함수 (p-1)*(q-1)
	static int p;// 임의의 소수p
	static int q;// 임의의 소수q
	
	public main() { // gui부분
		setTitle("RSA키생성");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel Btn_panel = new JPanel();
		Btn_panel.setLayout(new FlowLayout());
		JButton btn1 = new JButton ("암호화");
		JButton btn2 = new JButton ("복호화");
		JButton btn3 = new JButton ("키생성");
		JTextField tf1 = new JTextField(10);
		
		Btn_panel.add(btn1);
		Btn_panel.add(btn2);
		Btn_panel.add(new JLabel("평문값(2~50사이의 정수값)"));
		Btn_panel.add(tf1);
		Btn_panel.add(btn3);
		
		btn1.addActionListener(new ActionListener() { // 암호화 버튼
			//@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn2.addActionListener(new ActionListener() { //복호화 버튼
			//@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btn3.addActionListener(new ActionListener() { //키 생성 버튼
			//@Override
			public void actionPerformed(ActionEvent e) {
				
					m = new Integer(tf1.getText());
					txt_area.setText("평문값 : "+ m+"\n");

					if(m<2 || m>50)
					{
						txt_area.setText("※2~50사이의 정수값이 아닙니다.\n");
					}
					
				//키생성 함수
				create();
			}
		});

		// 프로그램 틀
		state = new JLabel(); 
		state.setText("RSA 키사용 암,복호화");
		txt_area = new JTextArea();
		add(txt_area, BorderLayout.CENTER);
		add(Btn_panel, BorderLayout.SOUTH);
		setSize(600, 600);
		setVisible(true);
	}
	
	public void create() { // 키 생성 함수
		p = getRandomNum(1,100);
		q = getRandomNum(1,100);
		if(p == q)
		{
			create();
		}
		txt_area.append("임의의 두 소수 p,q = "+p+" , "+q+"\n");
	}
	
	//임의의 수 p와 q를 반환하는 메소드
	public static int getRandomNum(int startNum, int endNum)
	{
		while(true)
		{
			Random random = new Random();
			int tempRange = endNum - startNum; // 생성범위는 끝수 - 처음수
			int result = (int)(random.nextDouble() * tempRange + startNum);
			return result;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}

}
