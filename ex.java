package rsa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class start_Sub extends JFrame implements ActionListener{
	private Container con;
	private JTextField tf1 = new JTextField(10);  //���̵� �� �ؽ�Ʈ �ʵ�
	private JTextField tf2 = new JTextField(10);  //��й�ȣ�� �� �н����� �ʵ�
	private JButton bt1 = new JButton("Ű�Է�");
	private JButton bt2 = new JButton("Ȯ��");
 
	//private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	boolean member = false;
 
 public start_Sub() {
	 super("�α���");
	 this.init();
	 this.start();
	 this.setSize(380,100);
	 this.setLocation(500,400);
	 this.setVisible(true);
 	}
 public void init() {  //ȭ�� ����
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
 public void start() {  //�̺�Ʈ
	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 bt1.addActionListener(this);
	 bt2.addActionListener(this);
 	}

 public void checkMember() {  //Ȯ�� ��ư �̺�Ʈ�� ������ �޼ҵ�
	
 	}
 
 public void actionPerformed(ActionEvent e) {  //ActionListener ����

 }
}
public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start_Sub ex = new start_Sub();
	}

}
