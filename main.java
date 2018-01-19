package rsa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.math.*;
//import java.io.*;
//import java.lang.*;


public class main extends JFrame{
	JLabel state;
	JTextArea txt_area;
	static int m;//평문 m
	static int em;// 복호화된 m
	static int c;// 암호문
	static int e;// 공개키
	static int d;// 개인키
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
		JButton btn4 = new JButton ("예시");
		JTextField tf1 = new JTextField(10);
		
		Btn_panel.add(new JLabel("2~50사이의 정수값"));
		Btn_panel.add(tf1);
		Btn_panel.add(btn3);
		Btn_panel.add(btn1);
		Btn_panel.add(btn2);	
		Btn_panel.add(btn4);
		
		btn1.addActionListener(new ActionListener() { // 암호화 버튼
			//@Override
			public void actionPerformed(ActionEvent aa) {
				c = decode(m,e,n);
				txt_area.append("---------------------------------------------" + "\n");
				txt_area.append("암호문 C = "+c+"\n");
			}
		});
		btn2.addActionListener(new ActionListener() { //복호화 버튼
			//@Override
			public void actionPerformed(ActionEvent aa) {
				em = decode(c,d,m);
				txt_area.append("---------------------------------------------" + "\n");
				txt_area.append("복호화 M = "+ m +"\n");
			}
		});
		btn3.addActionListener(new ActionListener() { //키 생성 버튼
			//@Override
			public void actionPerformed(ActionEvent aa) {
				
					m = new Integer(tf1.getText());
					txt_area.setText("평문값 : "+ m+"\n");
					
					if(m<2 || m>50)//m값이 다를때는 경고문구 출력
					{
						txt_area.setText("※2~50사이의 정수값이 아닙니다.\n");
					}
					else if(m>=2 && m<=50)//2에서 50까지의 수일때만 함수출력
					{
						create();
					}
			}
		});
		
		btn4.addActionListener(new ActionListener() { // 사용예시 로그인 버튼
			//@Override
			public void actionPerformed(ActionEvent aa) {
				start_Sub bb = new start_Sub(); // ex클래스의 start_Sub 매소드 실행
			}
		});
		
		// 프로그램 틀
		//state = new JLabel(); 
		//state.setText("RSA 키사용 암,복호화");
		txt_area = new JTextArea();
		txt_area.setFont(new Font("바탕체",Font.BOLD,20));//글자크기 조절
		add(txt_area, BorderLayout.CENTER);
		add(Btn_panel, BorderLayout.SOUTH);
		//setLayout(new GridLayout(2,0));
		setSize(550, 400);
		setLocation(700,400);
		setVisible(true);
	}
	
	public void create() { // 키 생성 함수
		p = getRandomNum(2,100,true); // p,q를 생성할때 판별을 위해 t/f추가
		q = getRandomNum(2,100,true);
		
		txt_area.append("p,q = "+p+" , "+q+"\n");
		
		n = (p * q);
		txt_area.append("n = " +  n + "\n"); 
		
		pi = (p-1)*(q-1); //오일러 파이 pi
		
		txt_area.append("pi = "+pi + "\n");
		
		e = publickey(pi,n); 
		txt_area.append("e값 = " + e + "\n");
		
		//GCD(pi,e);
		//txt_area.append("gcd("+pi+","+e+") = "+t+"\n");
		
		d = publickey(pi,e); 
		txt_area.append("d값 = " + d + "\n");
		
		txt_area.append("공개키 값 = {"+e+","+n+"}\n");
		txt_area.append("개인키 값 = {"+d+","+n+"}\n");
	}
	
	//임의의 수 p와 q를 반환하는 메소드
	public static int getRandomNum(int sNum, int eNum, boolean PNum)
	{
		while(true)
		{
			Random random = new Random();
			int tempRange = eNum - sNum; // 생성범위는 끝수 - 처음수
			int result = (int)(random.nextDouble() * tempRange + sNum);

			
			if(PNum) //true를 포함할때만 소수를 판별 ex)p,q
			{
				if(PN(result))
				{
					return result;
				}
			}
			else //소수가 아닌 랜덤한 값이 필요할때 false ex)e값
			{
				return result;
			}
		}
	}
	//소수 판별기
	public static boolean PN(int num)//prime number 소수
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
				t2++; // 안나누어 떨어지면 +1
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
	
	public static int GCD(int n1, int n2) // =gcd(n1,n2)
	{
		
		if(n1 < n2) // n1과 n2를 정리
		{
			t = n1;
			n1 = n2;
			n2 = t;
		}
		t = n2; //나누는 수를 n2로 잡음
		
		while(true)
		{
			if(n1%t ==0 && n2%t ==0) // n1을 나눠서 0이되고 n2를 나눠서 
				return t;			//  나머지가 0이될때까지 나눔
			t--;// 위 조건을 만족 못하면 -1씩 줄이면서 될때까지 반복
		}
		
	}
	//공개키 값 e를 구하기 위한 함수
	public static int publickey(int pi, int n)
	{
		int a = getRandomNum(2,pi,false); // 2보다 크면서 오일러pi보다 작은 정수 e선택
		int e = a; //어떤값이 잡힐지 모르기때문에 a에 담음
		
		while(GCD(a,pi) != 1 ) //gcd가 1이 아니면 a값을 줄이면서 확인
		{
			a--;
			if(GCD(a,pi) == 1) // gcd가 1이면 e에 a값을 저장
			{
				e=a;
				break;
			}
		}
		return e; 
	}
	
	public static int privatekey(int e, int pi) //개인키 계산
	{
		int b1 = 0;
		
		while((e*b1)%pi != 1) // e를b1번 곱해서 mod pi를 한 값이 1이 아닐때 b1을 증가시킨다.
		{
			b1++;
			if(e*b1%pi == 1) // e를 b1번 곱해서 mod pi를 한 값이 1이면 b1의 값이 d가된다.
				d = b1;
				break;
		}
		return d;
	}
	public static int decode(int a1, int a2, int a3)//암,복호화 계산
	{	
		int result = a1;
		
		for(int i=1; i<a2; i++) // 지수(a2)만큼 곱한다.
		{
			result = (result * a1) % a3; // result의 a1승을 계산 mod a3
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}

}
