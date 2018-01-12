package rsa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;




public class main extends JFrame{
	JLabel state;
	JTextArea txt_area;
	static int m;//평문 m
	static String c;// 암호문
	static String e;// 공개키
	static String d;// 개인키
	static int n = 0;// n = p*q
	static int pi;// 오일러 파이함수 (p-1)*(q-1)
	static int p=0;// 임의의 소수p
	static int q=0;// 임의의 소수q
	static int t = 0;// 최대공약수
	
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
					
				//키생성 함수 호출
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
		
		n = (p * q);
		txt_area.append("n값 = " + p+" X "+q+"= "+ n + "\n");
		
		GCD(p,q);
		txt_area.append("gcd("+p+","+q+") = "+t+"\n");
		
		pi = (p-1)*(q-1); //오일러 파이 pi
		txt_area.append("pi = (p-1) * (q-1) =  "+pi + "\n");
	}
	
	//임의의 수 p와 q를 반환하는 메소드
	public static int getRandomNum(int startNum, int endNum)
	{
		while(true)
		{
			Random random = new Random();
			int tempRange = endNum - startNum; // 생성범위는 끝수 - 처음수
			int result = (int)(random.nextDouble() * tempRange + startNum);
			isPN(result);
			return result;
		}
	}
	public static boolean isPN(int num)//prime number 소수
	{
		int t1 = num-1;
		int t2 = 2;
		
		while(t2 <= t1)
		{
			if(num%t2==0) // 인자값 num이 나누어 떨어지는지 확인한다.
			{
				break;
			}
			else
			{
				t2++;
			}
		}
		if(t2 > t1)
		{
			return true; // 소수
		}
		else
		{
			return false; // 소수가 아닙니다.
		}
	}
	
		public static int GCD(int n1, int n2)// =gcd(n1,n2)
	{
		//static int t = 0;
		
		if(n1 < n2)// n1과 n2를 정리
		{
			t = n1;
			n1 = n2;
			n2 = t;
		}
			
		t = n2;//나누는 수를 n2로 잡음
		
		while(true)
		{
			if(n1%t ==0 && n2%t ==0) // n1을 나눠서 0이되고 n2를 나눠서 
				return t;       //  나머지가 0이될때까지 나눔
			t--;// 위 조건을 만족 못하면 -1씩 줄이면서 될때까지 반복
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}

}
