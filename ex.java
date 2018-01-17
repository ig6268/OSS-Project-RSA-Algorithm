package rsa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class start_Sub extends JFrame implements ActionListener{
	private Container con;
	private JTextField tf1 = new JTextField(10);  //아이디를 쓸 텍스트 필드
	private JTextField tf2 = new JTextField(10);  //비밀번호를 쓸 패스워드 필드
	private JButton bt1 = new JButton("키입력");
	private JButton bt2 = new JButton("확인");
 
	//private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	boolean member = false;
 
 public start_Sub() {
	 super("로그인");
	 this.init();
	 this.start();
	 this.setSize(380,100);
	 this.setLocation(500,400);
	 this.setVisible(true);
 	}
 public void init() {  //화면 구성
	 con = this.getContentPane();
	 JPanel pn1 = new JPanel(new FlowLayout());
	 pn1.add(new JLabel("ID"));
	 pn1.add(tf1);
	 pn1.add(new JLabel("Passwd"));
	 pn1.add(tf2);
	 JPanel pn2 = new JPanel(new FlowLayout());
	 pn2.add(bt1);
	 pn2.add(bt2);
	 con.setLayout(new GridLayout(2,1));
  	 con.add(pn1);
     con.add(pn2);
  
 	}
 public void start() {  //이벤트
	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 bt1.addActionListener(this);
	 bt2.addActionListener(this);
 	}

 public void checkMember() {  //확인 버튼 이벤트시 수행할 메소드
	
 	}
 
 public void actionPerformed(ActionEvent e) {  //ActionListener 구현

 }
}
public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start_Sub ex = new start_Sub();
	}

}
