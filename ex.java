package rsa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;


class start_Sub extends JFrame implements ActionListener{
	private Container con;
	private JTextField tf1 = new JTextField(10);  //아이디를 쓸 텍스트 필드
	private JTextField tf2 = new JTextField(10);  //비밀번호를 쓸 텍스트 필드
	private JTextField tf3 = new JTextField(8);  //공개키를 쓸 텍스트 필드
	private JTextField tf4 = new JTextField(8);  //n을 쓸 텍스트 필드
	//private JButton bt1 = new JButton("키입력");
	private JButton bt2 = new JButton("확인");
 
	private Statement stmt = null;
	private ResultSet rs = null;
	boolean member = false;
 
 public start_Sub() {
	 super("로그인");
	 this.init();
	 this.start();
	 this.setSize(350,170);
	 this.setLocation(700,400);
	 this.setVisible(true);
 	}
 public void init() {  //화면 구성
	 con = this.getContentPane();
	 JPanel pn1 = new JPanel(new FlowLayout());
	 pn1.add(new JLabel("ID"));
	 pn1.add(tf1);
	 pn1.add(new JLabel("PASSWD"));
	 pn1.add(tf2);
	 pn1.add(new JLabel("공개키E,N"));
	 pn1.add(tf3);
	 pn1.add(tf4);
	 
	 JPanel pn2 = new JPanel(new FlowLayout());
	// pn2.add(bt1);
	 pn2.add(bt2);
	 con.setLayout(new GridLayout(2,2));
  	 con.add(pn1);
     con.add(pn2);
  
 	}
 public void start() {  //이벤트
	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 //bt1.addActionListener(this);
	 bt2.addActionListener(this);
 	}

 public void login() {  //확인 버튼 이벤트시 수행할 메소드
	
	int pe=0;
	int pn=0;
	int pw=0;
	int c=0;
	String id;
	
	id = tf1.getText(); // id 값을 저장
	pw = new Integer(tf2.getText()); // 패스워드 저장
	pe = new Integer(tf3.getText()); // e값 저장
	pn = new Integer(tf4.getText()); // n값 저장
	
	//main de = new main();
	c = main.decode(pw,pe,pn); /* main 클래스의 decode 함수를 호출해 
								  pw,pe,pn을 인자값으로 주고 계산을 해서 c에 저장한다.*/
	
 	}
 
 public void actionPerformed(ActionEvent e) {  //ActionListener 구현
	 this.login(); // event발생시 login함수 실행
 }
}
public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start_Sub ex = new start_Sub();
	}

}
